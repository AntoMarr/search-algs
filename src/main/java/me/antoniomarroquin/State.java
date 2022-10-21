package me.antoniomarroquin;

import java.util.Arrays;
import java.util.HashSet;

import me.antoniomarroquin.objects.Coin;
import me.antoniomarroquin.objects.Wall;

public class State {
    enum Move {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        PICKUP
    }

    private HashSet<Wall> walls = new HashSet<>();
    private HashSet<Coin> coins = new HashSet<>();

    private Move move;
    private State parent;

    public State(Wall[] walls, Coin[] coins) {
        this.walls.addAll(Arrays.asList(walls));
        this.coins.addAll(Arrays.asList(coins));
    }

    public State(State parent, Move move) {
        this.parent = parent;
        this.move = move;
    }
}
