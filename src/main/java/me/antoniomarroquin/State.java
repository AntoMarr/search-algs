package me.antoniomarroquin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

import me.antoniomarroquin.objects.Coin;
import me.antoniomarroquin.objects.Wall;

public class State {
    public enum Move {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        PICKUP,
        VICTORY
    }

    private HashSet<Coin> coins = new HashSet<Coin>();

    public Move move;
    private State parent;
    private Coordinate coordinate;
    private Problem problem;

    public int depth;

    // should only be used for first state
    public State(Coordinate coordinate, Coin[] coins, Problem problem) {
        this.coordinate = coordinate;
        this.coins.addAll(Arrays.asList(coins));
        this.problem = problem;

        depth = 0;
    }

    // for every child state
    public State(State parent, Move move, Problem problem) {
        this.parent = parent;
        this.move = move;
        this.problem = problem;

        depth = parent.depth + 1;
        coordinate = parent.coordinate;

        for (Coin coin : parent.coins)
            coins.add(new Coin(coin.coordinate, coin.isPickedUp()));

        switch (move) {
            case UP:
                coordinate.moveUp();
                break;
            case DOWN:
                coordinate.moveDown();
                break;
            case LEFT:
                coordinate.moveLeft();
                break;
            case RIGHT:
                coordinate.moveRight();
                break;
            case PICKUP:
                for (Coin coin : coins)
                    if (coordinate.equals(coin.coordinate))
                        coin.pickUp();
                break;
            case VICTORY:
                System.out.println("DO LATER: DECLARE VICTORY");
                break;
        }
    }

    public HashSet<State> getNextStates() {
        HashSet<State> nextStates = new HashSet<State>();

        if (isOnCoin()) {
            nextStates.add(new State(this, Move.PICKUP, problem));
            return nextStates;
        }
        if (!isOnWall(coordinate.getUp()))
            nextStates.add(new State(this, Move.UP, problem));
        else
            System.out.println("WALL");
        if (!isOnWall(coordinate.getDown()))
            nextStates.add(new State(this, Move.DOWN, problem));
        if (!isOnWall(coordinate.getLeft()))
            nextStates.add(new State(this, Move.LEFT, problem));
        if (!isOnWall(coordinate.getRight()))
            nextStates.add(new State(this, Move.RIGHT, problem));
        return nextStates;
    }

    public boolean isGoalState() {
        for (Coin coin : coins)
            if (coin.isPickedUp() == false)
                return false;
        return true;
    }

    public boolean isOnCoin() {
        for (Coin coin : coins) {
            if (coordinate.equals(coin.coordinate)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnWall(Coordinate coordinate) {
        return problem.walls.contains(new Wall(coordinate));
    }
 
    public Stack<Move> getFullSetOfMoves() {
        State p = parent;
        Stack<Move> moves = new Stack<>();

        moves.add(move);

        while (p != null){
            moves.add(p.move);
            
            p = p.parent;
        }

        return moves;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof State)) {
            return false;
        }

        State o = (State) object;

        if (this.coordinate.equals(o.coordinate)) {
            for (Coin coin : coins) {
                for (Coin c : o.coins) {
                    if (!coin.equals(c))
                        return false;
                }
            }
            return true;
        }
        
        return false;
    }
}
