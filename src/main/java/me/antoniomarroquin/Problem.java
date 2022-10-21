package me.antoniomarroquin;

import java.util.HashSet;

import me.antoniomarroquin.objects.Coin;
import me.antoniomarroquin.objects.Wall;

public class Problem {

    // walls used by State objects and for drawing to board
    public HashSet<Wall> walls = new HashSet<Wall>();
    
    public HashSet<Coin> coins = new HashSet<Coin>();

    public State initialState;
    
    public Problem(String map) {
        convertStringToGameBoard(map.split("\n"));
        System.out.println(map.split("\n")[1]);
    }

    private void convertStringToGameBoard(String[] map) {
        Coordinate initialStateCoord = null;
        
        int y = 0;
        for (int i = map.length - 1; i >= 0; i--) {
            int x = 0;
            for (char c : map[i].toCharArray()) {
                switch (c) {
                    case 'w':
                        walls.add(new Wall(new Coordinate(x, y)));
                        break;
                    case '.':
                        coins.add(new Coin(new Coordinate(x, y)));
                        break;
                    case 'S':
                        initialStateCoord = new Coordinate(x, y);
                }
                x++;
            }
            y++;
        }

        initialState = new State(initialStateCoord, coins.toArray(new Coin[] {}), this);
    }
}
