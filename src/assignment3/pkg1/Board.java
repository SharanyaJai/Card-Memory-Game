/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.pkg1;

import java.util.Scanner;

/**
 *
 * Class Board
 *
 * @author sharanya
 */
public class Board {

    /**
     * Initializes Game object, calls corresponding methods, keeps the game On.
     * @throws Exception  catches any unexpected Exception
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Game game = new Game();
        Scanner sc1 = new Scanner(System.in);
        String continueGame;

        System.out.println(" Start new game? Enter Y or y");
        try {
            continueGame = sc1.nextLine();
            while (continueGame.equals("Y") || continueGame.equals("y")) {
                game.setGame();
                game.displayBoard();
                game.playGame();
                System.out.println("Start new game? Enter Y or N");
                continueGame = sc1.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred");
        }

    }

}
