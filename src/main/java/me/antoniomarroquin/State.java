package me.antoniomarroquin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

import me.antoniomarroquin.objects.Coin;

public class State {
    enum Move {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        PICKUP,
        VICTORY
    }

    private HashSet<Coin> coins = new HashSet<>();

    private Move move;
    private State parent;
    private Coordinate coordinate;

    // should only be used for first state
    public State(Coordinate coordinate, Coin[] coins) {
        this.coordinate = coordinate;
        this.coins.addAll(Arrays.asList(coins));
    }

    // for every child state
    public State(State parent, Move move) {
        this.parent = parent;
        this.move = move;
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
}
