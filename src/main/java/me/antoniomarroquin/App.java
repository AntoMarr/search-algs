package me.antoniomarroquin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import me.antoniomarroquin.objects.Coin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            new App().testGameBoard();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void testGameBoard() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("bigCorners.txt"));

        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            sb.append(sc.next());
        }

        GameBoard gb = new GameBoard(sb.toString());

        for (Coin coin : gb.coins) {
            System.out.println("x: " + coin.coordinate.getX() + "\ty: " + coin.coordinate.getY());
        }
    }
}
