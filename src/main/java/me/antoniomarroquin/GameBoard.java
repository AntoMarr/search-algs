package me.antoniomarroquin;

import java.util.HashSet;

import me.antoniomarroquin.objects.Coin;
import me.antoniomarroquin.objects.Wall;

public class GameBoard {

    // walls used by State objects and for drawing to board
    public static HashSet<Wall> walls = new HashSet<>();
    
    public HashSet<Coin> coins = new HashSet<>();

    private State initialState;
    
    public GameBoard(String map) {
        convertStringToGameBoard(map.split("\n"));
    }

    private void convertStringToGameBoard(String[] map) {
        Coordinate initialStateCoord = null;
        
        int y = 0;
        for (int i = map.length; i >= 0; i--) {
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
        }

        initialState = new State(initialStateCoord, coins.toArray(new Coin[] {}));
    }
}
