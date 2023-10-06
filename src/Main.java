import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;
        int choice = 0;


        System.out.println("""
                                      
                                      (--Tic-Tac-Toe--)
                                                     
                                         X | O | X \s
                                        ---+---+---
                                           | O |   \s
                                        ---+---+---
                                           | O |   \s
                                                              
                                      
                       Unleash Your Xs and Os - Tic-Tac-Toe, Let's Go!
                """);

        do {

            try {

                System.out.println(""" 
                        How many players?
                        1. One Player
                        2. Two players
                        """);

                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        Game game = new Game();
                        game.playGameWithComputer(sc);
                        break;

                    case 2:
                        game = new Game();
                        game.playGameTwoPlayers(sc);
                        break;
                }

                if (choice != 1 && choice != 2) {
                    System.out.println("Not a valid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input! Please try again!");
                sc.nextLine();
            }
        } while (choice != 1 && choice != 2);



    }
    }


