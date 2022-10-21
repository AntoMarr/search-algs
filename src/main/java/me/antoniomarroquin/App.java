package me.antoniomarroquin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import me.antoniomarroquin.State.Move;
import me.antoniomarroquin.algorithms.BreadthFirstSearch;
import me.antoniomarroquin.objects.Wall;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine() + "\n");
        }

        Problem gb = new Problem(sb.toString());

        System.out.println("\n---WALLS---");
        for (Wall wall : gb.walls) {
            System.out.println("x: " + wall.coordinate.getX() + "\ty: " + wall.coordinate.getY());
        }

        if (new BreadthFirstSearch().search(gb).move == Move.VICTORY) {
            System.out.println("VICTORY!");
        }
    }
}
