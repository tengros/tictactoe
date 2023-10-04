import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String input;

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
        game.shufflePlayers();

        System.out.println("""
                                      
                                (--How to place your letters--)
                                                     
                 Each digit              1 | 2 | 3 \s
                 representants          ---+---+---
                 it's respective         4 | 5 | 6 \s
                 position on the        ---+---+---
                 game board.             7 | 8 | 9  \s
                               
                """);
        System.out.println("Tic-Tac-Toe, Let's Go!");
        System.out.println("The board is now empty, where do you want to place your letter? ");
        Board.printBoard();

        while (true) {
            game.placeLetter(game.getCurrentPlayer());
            String result = Game.checkWinner();
            System.out.println(result);
            if (!result.equals("")) {
                break;
            }
            game.switchPlayers();
        }


    }


}