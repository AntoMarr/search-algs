package me.antoniomarroquin;

import java.util.LinkedList;
import java.util.Queue;

public class State {
    enum Move {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Queue<Move> moves = new LinkedList<>();
}
