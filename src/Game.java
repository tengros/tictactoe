import java.util.*;

public class Game {

    Scanner sc = new Scanner(System.in);

    // Create lists of players' positions to later determine the winner.
    static ArrayList<Integer> firstPlayerPositions = new ArrayList<>();
    static ArrayList<Integer> secondPlayerPositions = new ArrayList<>();

    private int input;
    private int menuChoice;
    static Player firstPlayer;
    static Player secondPlayer;
    private Player currentPlayer;
    private boolean validMove = true;

    private ArrayList<Player> players;


    // Initiates the game based on menu selection.
    public Game(int menu) {
        this.menuChoice = menu;
        players = new ArrayList<>();
    }

    //Get the current player
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    // Tells if the position is taken or not.
    public static boolean posTaken(int position) {
        if (firstPlayerPositions.contains(position) || secondPlayerPositions.contains(position)) {
            return true;
        } else {
            return false;
        }
    }

    // Create players based on the menu selection.
    public void createPlayers(Scanner sc) {

        System.out.print("Name of player 1: ");
        String input = sc.nextLine();
        Player p1 = new Player(input, 'X', 0);
        firstPlayer = p1;
        players.add(p1);

        if (menuChoice == 1) {
            System.out.print("Name of player 2: X-O-Matic");
            Player p2 = new Player("X-O-Matic", 'O', 0);
            secondPlayer = p2;
            players.add(p2);

        } else if (menuChoice == 2) {
            System.out.print("Name of player 2: ");
            input = sc.nextLine();
            Player p2 = new Player(input, 'O', 0);
            secondPlayer = p2;
            players.add(p2);
        }
    }

    // Method for place the letters and add them to the players positions.
    public void placeLetter(Player currentPlayer, char[][] board) {

        int randomNumber;
        Random random = new Random();
        while (true) {
            try {
                if (getCurrentPlayer().getName().equals("X-O-Matic")) {
                    input = randomNumber = random.nextInt(9) + 1;
                } else {
                    input = sc.nextInt();
                }
                if (input >= 1 && input <= 9) {
                    if (!posTaken(input)) {
                        if (currentPlayer.equals(firstPlayer)) {
                            firstPlayerPositions.add(input);
                        } else if (currentPlayer.equals(secondPlayer)) {
                            secondPlayerPositions.add(input);
                        }
                        validMove = true;
                        break;

                    }
                    if (!getCurrentPlayer().getName().equals("X-O-Matic")) {
                        System.out.println("Position already taken, please try again!");
                    }

                } else {
                    System.out.println("Invalid choice, try again!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Incorrect enter! Please try again!");
                sc.nextLine();
            }
        }

        switch (input) {

            case 1:
                board[0][1] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 2:
                board[0][5] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 3:
                board[0][9] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 4:
                board[2][1] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 5:
                board[2][5] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 6:
                board[2][9] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 7:
                board[4][1] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 8:
                board[4][5] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            case 9:
                board[4][9] = currentPlayer.getLetter();
                System.out.println();
                Board.printBoard(board);
                break;
            default:
                System.out.println("Incorrect enter! Please try again!");
                validMove = false;
                break;
        }
    }

    // Display the rules of the game
    public void rules() {
        System.out.println("""
                                      
                                (--How to place your letters--)
                                                     
                 Each digit              1 | 2 | 3 \s
                 representants          ---+---+---
                 it's respective         4 | 5 | 6 \s
                 position on the        ---+---+---
                 game board.             7 | 8 | 9  \s
                               
                """);
    }

    // Create a list of letters, then shuffles the order of letters and set the player who gets X as the starting player.
    public void shufflePlayers() {
        List<Character> letters = Arrays.asList('X', 'O');
        Collections.shuffle(letters);

        firstPlayer.setLetter(letters.get(0));
        secondPlayer.setLetter(letters.get(1));

        currentPlayer = (firstPlayer.getLetter() == 'X') ? firstPlayer : secondPlayer;

        System.out.println(currentPlayer.getName() + " starts the game using " + currentPlayer.getLetter());

    }

    // If it is a Valid move (true) then switch current player.
    public void switchPlayers() {
        if (validMove) {
            if (currentPlayer == players.get(0)) {
                currentPlayer = players.get(1);
                System.out.println("Good move, now it's " + getCurrentPlayer() + "s turn!");
            } else {
                currentPlayer = players.get(0);
                System.out.println("Good move, now it's " + getCurrentPlayer() + "s turn!");
            }
        }
    }

    // Define winning combinations, creates list of them and then check for winning combinations.
    // The game goes on as long as there is not a draw, no winning combinations and the board not is ful.
    public static String checkWinner() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        // Check each winning combination
        for (List<Integer> l : winning) {
            if (firstPlayerPositions.containsAll(l)) {
                System.out.println();
                System.out.println("Tic-Tac-Toe - " + firstPlayer.getName() + " won the game!");
                firstPlayer.incrementNumberOfWins();
                return "One more time, right?";
            } else if (secondPlayerPositions.containsAll(l)) {
                System.out.println();
                System.out.println("Tic-Tac-Toe - " + secondPlayer.getName() + " won the game!");
                secondPlayer.incrementNumberOfWins();
                return "One more time, right?";


            }
        }

        if (firstPlayerPositions.size() + secondPlayerPositions.size() == 9) {
            return "It's a draw!";
        }

        return "";
    }

    // Clear the lists so the game is clean for a new game.
    public void clearLists() {
        firstPlayerPositions.clear();
        secondPlayerPositions.clear();

    }

    // Asks if the players wants to play a new game
    public boolean playAgain(Scanner sc) {
        boolean playAgain2 = true;
        do {
            try {
                System.out.println("Do you want to play again?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int playAgain = sc.nextInt();
                if (playAgain == 2) {
                    playAgain2 = false;
                    System.out.println("Thank you for playing. Have a nice day :-)");
                    break;
                } else if (playAgain == 1) {
                    playAgain2 = true;
                } else {
                    System.out.println("Not a valid choice");
                    playAgain2 = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input! Please try again!");
                playAgain2 = false;
                sc.nextLine();
            }
        } while (!playAgain2);

        return playAgain2;
    }

    //Game flow code
    public void playGame(Scanner sc) {

        createPlayers(sc); //Create and set up the players
        System.out.println();
        rules(); // Display the game rules
        System.out.println();

        // The main game loop
        while (true) {
            shufflePlayers(); // Shuffle and set the orders of players
            System.out.println("Tic-Tac-Toe, Let's Go!");
            clearLists();
            char[][] board = new Board().newBoard(); // Initialize the game board
            System.out.println("The board is now empty, where do you want to place your letter " + getCurrentPlayer() + " ?");
            Board.printBoard(board); // Print out empty game board

            // The sub-game loop
            while (true) {
                placeLetter(getCurrentPlayer(), board);
                String result = Game.checkWinner(); // Check if there is a winner or a draw and display the resuly
                System.out.println(result);
                if (!result.isEmpty()) {
                    break; // If the game is over, break out the sub-game loop
                }
                switchPlayers(); //Switch to the next players turn

            }
            if (!playAgain(sc)) {
                break; //Asks if the player wants to play again , and if not then exit the main loop.
            }
        }


    }

}


