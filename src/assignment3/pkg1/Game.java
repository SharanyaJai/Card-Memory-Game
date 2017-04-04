/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.pkg1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class Game
 *
 * @author sharanya
 */
public class Game {

    ArrayList<Character> cards = new ArrayList<Character>();
    ArrayList<Point> positions = new ArrayList<Point>();
    char[] A = new char[16];
    int count = 0;

    /**
     * Inputs the card values and shuffles it
     */
    void setGame() {
        cards.add('A');
        cards.add('A');
        cards.add('Q');
        cards.add('Q');
        cards.add('K');
        cards.add('K');
        cards.add('J');
        cards.add('J');
        cards.add('2');
        cards.add('2');
        cards.add('5');
        cards.add('5');
        cards.add('6');
        cards.add('6');
        cards.add('9');
        cards.add('9');
        Collections.shuffle(cards);
        for (int a = 0; a < 16; a++) {
            A[a] = '$';
        }
    }

    /**
     * Displays deck of the cards
     */
    public void displayBoard() {

        System.out.print("\t");
        for (int k = 1; k < 5; k++) {
            System.out.print(k + "\t");
        }
        int k = 0;
        System.out.print("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    System.out.print((i + 1) + "\t");
                } else {
                    System.out.print(A[k++] + "\t");
                }

            }
            System.out.println();
        }
        
    }

    /**
     * Displays the leader board with the two cards opened - only when cards
     * don't match, (a,b) hold x (first card opened) and (c,d) hold y (second
     * card opened)
     *
     * @param a row 1
     * @param b column 1
     * @param c row 2
     * @param d column 2 
     * @param x card1 value
     * @param y card2 value
     */

    public void displayBoard1(int a, int b, int c, int d, char x, char y) {

        System.out.print("\t");
        for (int k = 1; k < 5; k++) {
            System.out.print(k + "\t");
        }
        int k = 0;
        System.out.print("\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    System.out.print((i + 1) + "\t");
                } else {
                    if (k == ((a * 4) + b)) {
                        System.out.print(x + "\t");//  when k equals value of (a,b) in a 2D array, displays x (first card)
                    } else if (k == ((c * 4) + d)) {
                        System.out.print(y + "\t");//  when k equals value of (c,d) in a 2D array, displays y (second card)
                    } else {
                        System.out.print(A[k] + "\t");
                    }
                    k++;
                }

            }
            System.out.println();
        }
        
    }

    /**
     * Inputs coordinates from user, checks if they match and updates board,
     * continues till all cards are matched.
     *
     * @throws IndexOutOfBoundsException catches IndexoutofBoundsException
     */
    public void playGame() throws IndexOutOfBoundsException {
        while (count < 8) {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0, mark = 1, m1 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter value for row 1:");
            String s="\0";
            Point p1, p2;

            do {
                s = sc.nextLine();
                do {
                    mark = 1;
                    m1 = 0;
                    try {
                        x1 = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        mark = 0;
                        m1 = 1;
                        System.out.println("Please enter a valid Integer 1");

                    }
                    if (!(x1 >= 1 && x1 <= 4)) {
                        mark = 0;
                        if (m1 != 1) {
                            System.out.println("Please enter coordinates between 1 to 4");

                        }
                        s = sc.nextLine();
                    }

                } while (mark == 0);

                System.out.println("Enter value for column 1:");
                s = sc.nextLine();
                do {
                    mark = 1;
                    m1 = 0;
                    try {
                        y1 = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        mark = 0;
                        m1 = 1;
                        System.out.println("Please enter a valid Integer 2");
                        //s = sc.nextLine();

                    }
                    if (!(y1 >= 1 && y1 <= 4)) {
                        mark = 0;
                        if (m1 != 1) {
                            System.out.println("Please enter coordinates between 1 to 4");
                            //s = sc.nextLine();
                        }
                        s = sc.nextLine();
                        //x1 = sc.nextInt();
                    }

                } while (mark == 0);
                x1 -= 1;
                y1 -= 1;
                p1 = new Point(x1, y1);
                if (positions.contains(p1)) {
                    System.out.println("Already opened! Please enter row1 and column 1 again");
                }
            } while (positions.contains(p1));

            System.out.println("Enter value for row 2:");
            
            do {
                s = sc.nextLine();
                do {
                    mark = 1;
                    m1 = 0;
                    try {
                        x2 = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        mark = 0;
                        m1 = 1;
                        System.out.println("Please enter a valid Integer ");

                    }
                    if (!(x2 >= 1 && x2 <= 4)) {
                        mark = 0;
                        if (m1 != 1) {
                            System.out.println("Please enter coordinates between 1 to 4");

                        }
                        s = sc.nextLine();
                    }

                } while (mark == 0);
                System.out.println("Enter value for column 2:");
                s = sc.nextLine();
                do {
                    mark = 1;
                    m1 = 0;
                    try {
                        y2 = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        mark = 0;
                        m1 = 1;
                        System.out.println("Please enter a valid Integer");
                        // s = sc.nextLine();

                    }
                    if (!(y2 >= 1 && y2 <= 4)) {
                        mark = 0;
                        if (m1 != 1) {
                            System.out.println("Please enter coordinates between 1 to 4");

                        }
                        s = sc.nextLine();
                    }

                } while (mark == 0);

                x2 -= 1;
                y2 -= 1;

                p2 = new Point(x2, y2);
                if (positions.contains(p2)) {
                    System.out.println("Already opened! Please enter row2 and column 2 again");
                }
            } while (positions.contains(p2));
            System.out.println("Coordinates entered - x1:" + x1 + " y1:" + y1 + " x2:" + x2 + " y2:" + y2);

            System.out.println(cards.get((x1 * 4) + y1) + "\t" + cards.get((x2 * 4) + y2));
             if (cards.get((x1 * 4) + y1).equals(cards.get((x2 * 4) + y2))) {
                System.out.println("Success! You have " + (7 - count) + " pair(s) more to go");
                count++;
                A[(x1 * 4) + y1] = cards.get((x1 * 4) + y1);
                A[(x2 * 4) + y2] = cards.get((x2 * 4) + y2);
                positions.add(new Point(x1, y1));
                positions.add(new Point(x2, y2));

                displayBoard();

            } else {

                displayBoard1(x1, y1, x2, y2, cards.get((x1 * 4) + y1), cards.get((x2 * 4) + y2));
                System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
                displayBoard();
                System.out.println("Cards Dont match! Try again");
            }
        }
        if (count == 8) {
            System.out.println("Done!");
        }

    }
}
