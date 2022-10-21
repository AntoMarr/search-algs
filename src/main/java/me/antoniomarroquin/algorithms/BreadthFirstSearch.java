package me.antoniomarroquin.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import me.antoniomarroquin.Problem;
import me.antoniomarroquin.State;
import me.antoniomarroquin.State.Move;

public class BreadthFirstSearch implements Search {

    public int maxDepth = 0;

    @Override
    public State search(Problem problem) {
        State node = problem.initialState;
        if (node.isGoalState()) {
            return new State(node, Move.VICTORY, problem);
        }
        Queue<State> frontier = new LinkedList<State>();
        HashSet<State> reached = new HashSet<State>();

        frontier.add(node);
        reached.add(problem.initialState);

        while(!frontier.isEmpty()) {
            if (node.depth > maxDepth) {
                System.out.println(node.depth);
                maxDepth++;
            }

            node = frontier.poll();
            for (State state : node.getNextStates()) {
                if (state.isGoalState()) {
                    return new State(state, Move.VICTORY, problem);
                }
                if (!reached.contains(state)) {
                    reached.add(state);
                    frontier.add(state);
                }
            }
        }
        return null;
    }
    
}
