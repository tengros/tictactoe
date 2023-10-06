import java.util.*;

public class Game {

    static ArrayList<Integer> firstPlayerPositions = new ArrayList<>();
    static ArrayList<Integer> secondPlayerPositions = new ArrayList<>();

    private int choice;
    static Player firstPlayer;
    static Player secondPlayer;
    private Player currentPlayer;
    private boolean validMove = true;

    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static boolean posTaken(int position) {
        if (firstPlayerPositions.contains(position) || secondPlayerPositions.contains(position)) {
            return true;
        } else {
            return false;
        }
    }

    public void createPlayers(Scanner sc) {
        System.out.print("Name of player 1: ");
        String input = sc.nextLine();
        Player p1 = new Player(input, 0);
        players.add(p1);

        System.out.print("Name of player 2: ");
        input = sc.nextLine();
        Player p2 = new Player(input, 0);
        players.add(p2);
    }

    public void createPlayerAndComputer(Scanner sc) {
        System.out.print("Name of player 1: ");
        String input = sc.nextLine();
        Player p1 = new Player(input, 0);
        players.add(p1);

        System.out.print("Name of player 2: X-O-Matic");
        Player p2 = new Player("X-O-Matic", 0);
        players.add(p2);
        firstPlayer = players.get(0);
        secondPlayer = players.get(1);
        firstPlayer.setGamePiece('X');
        secondPlayer.setGamePiece('O');
        System.out.println();
        System.out.println(firstPlayer.getName() + " starts the game using " + firstPlayer.getGamePiece());
        currentPlayer = firstPlayer;
    }

    public void computerPlaceLetter(Player currentPlayer, char[][] board) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int randomNumber;
            Random random = new Random();
            choice = randomNumber = random.nextInt(9) + 1;

            if (choice >= 1 && choice <= 9) {
                if (!posTaken(choice)) {
                    if (currentPlayer.equals(firstPlayer)) {
                        firstPlayerPositions.add(choice);
                    } else if (currentPlayer.equals(secondPlayer)) {
                        secondPlayerPositions.add(choice);
                    }
                    validMove = true;
                    break;

                }

            }
        }

        switch (choice) {

            case 1:
                board[0][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 2:
                board[0][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 3:
                board[0][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 4:
                board[2][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 5:
                board[2][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 6:
                board[2][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 7:
                board[4][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 8:
                board[4][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 9:
                board[4][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            default:
                System.out.println("Incorrect enter! Please try again!");
                validMove = false;
                break;
        }
    }

    public void placeLetter(Player currentPlayer, char[][] board) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {

                choice = scanner.nextInt();

                if (choice >= 1 && choice <= 9) {
                    if (!posTaken(choice)) {
                        if (currentPlayer.equals(firstPlayer)) {
                            firstPlayerPositions.add(choice);
                        } else if (currentPlayer.equals(secondPlayer)) {
                            secondPlayerPositions.add(choice);
                        }
                        validMove = true;
                        break;

                    } else {
                        System.out.println("Position already taken, please try again!");
                    }

                } else {
                    System.out.println("Invalid choice, try again!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Incorrect enter! Please try again!");
                scanner.nextLine();
            }
        }

        switch (choice) {

            case 1:
                board[0][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 2:
                board[0][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 3:
                board[0][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 4:
                board[2][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 5:
                board[2][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 6:
                board[2][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 7:
                board[4][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 8:
                board[4][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            case 9:
                board[4][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard(board);
                break;
            default:
                System.out.println("Incorrect enter! Please try again!");
                validMove = false;
                break;
        }
    }

    public void playGameWithComputer(Scanner sc) {

        createPlayerAndComputer(sc);
        System.out.println();
        rules();
        while (true) {
            System.out.println("Tic-Tac-Toe, Let's Go!");
            clearLists();
            char[][] board = new Board().newBoard();
            System.out.println("The board is now empty, where do you want to place your letter " + getCurrentPlayer() + " ?");
            Board.printBoard(board);
            while (true) {
                placeLetter(getCurrentPlayer(), board);
                String result = Game.checkWinner();
                System.out.println(result);
                if (!result.isEmpty()) {
                    break;
                }
                switchPlayers();
                computerPlaceLetter(getCurrentPlayer(), board);
                result = Game.checkWinner();
                System.out.println(result);
                if (!result.isEmpty()) {
                    break;
                }
                switchPlayers();
            }
            if (!playAgain(sc)) {
                break;
            }
        }


    }

    public void playGameTwoPlayers(Scanner sc) {

        createPlayers(sc);
        System.out.println();
        rules();
        System.out.println();
        while (true) {
            shufflePlayers();
            System.out.println("Tic-Tac-Toe, Let's Go!");
            clearLists();
            char[][] board = new Board().newBoard();
            System.out.println("The board is now empty, where do you want to place your letter " + getCurrentPlayer() + " ?");
            Board.printBoard(board);
            while (true) {
                placeLetter(getCurrentPlayer(), board);
                String result = Game.checkWinner();
                System.out.println(result);
                if (!result.isEmpty()) {
                    break;
                }
                switchPlayers();

            }
            if (!playAgain(sc)) {
                break;
            }
        }


    }

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

        for (List<Integer> l : winning) {
            if (firstPlayerPositions.containsAll(l)) {
                System.out.println("Tic-Tac-Toe - " + firstPlayer.getName() + " won the game!");
                firstPlayer.incrementNumberOfWins();
                return "One more time, right?";
            } else if (secondPlayerPositions.containsAll(l)) {
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

    public void shufflePlayers() {
        Collections.shuffle(players);
        firstPlayer = players.get(0);
        secondPlayer = players.get(1);
        firstPlayer.setGamePiece('X');
        secondPlayer.setGamePiece('O');
        System.out.println(firstPlayer.getName() + " starts the game using " + firstPlayer.getGamePiece());
        currentPlayer = firstPlayer;
    }

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

    public void clearLists() {
        firstPlayerPositions.clear();
        secondPlayerPositions.clear();

    }

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



}


