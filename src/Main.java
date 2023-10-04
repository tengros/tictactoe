import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String input;
        int playAgain = 0;
        boolean playAgain2 = true;

        System.out.println("""
                                      
                                      (--Tic-Tac-Toe--)
                                                     
                                         X | O | X \s
                                        ---+---+---
                                           | O |   \s
                                        ---+---+---
                                           | O |   \s
                                                              
                                      
                       Unleash Your Xs and Os - Tic-Tac-Toe, Let's Go!
                """);

        Game game = new Game();
        game.createPlayers(sc);


        System.out.println();


        System.out.println("""
                                      
                                (--How to place your letters--)
                                                     
                 Each digit              1 | 2 | 3 \s
                 representants          ---+---+---
                 it's respective         4 | 5 | 6 \s
                 position on the        ---+---+---
                 game board.             7 | 8 | 9  \s
                               
                """);
        do {
            game.shufflePlayers();

            System.out.println("Tic-Tac-Toe, Let's Go!");
            game.clearLists();
            char[][] board = new Board().newBoard();
            System.out.println("The board is now empty, where do you want to place your letter? ");
            Board.printBoard(board);


            while (true) {
                game.placeLetter(game.getCurrentPlayer(), board);
                String result = Game.checkWinner();
                System.out.println(result);
                if (!result.equals("")) {
                    break;
                }
                game.switchPlayers();
            }
            System.out.println("Do you want to play again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            playAgain = sc.nextInt();
            if (playAgain == 2) {
                playAgain2 = false;
                break;
            } else if (playAgain < 1 || playAgain > 2) {
                System.out.println("Not a valid choice");
            }

        } while (playAgain2);


    }


}