import java.util.*;

public class Game {

    static ArrayList<Integer> firstPlayerPositions = new ArrayList<>();
    static ArrayList<Integer> secondPlayerPositions = new ArrayList<>();

    private int choice;
    Player firstPlayer;
    Player secondPlayer;
    private Player currentPlayer;
    private String currentPlayer2;
    private boolean validMove = true;

    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int readIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Felaktig input! Vänligen ange en siffra.");
                scanner.next(); // för att rensa bort den felaktiga inputen
            }
        }
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
        Player p1 = new Player(input);
        players.add(p1);

        System.out.print("Name of player 2: ");
        input = sc.nextLine();
        Player p2 = new Player(input);
        players.add(p2);
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

    public void placeLetter(Player currentPlayer) {
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
                Board.board[0][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 2:
                Board.board[0][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 3:
                Board.board[0][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 4:
                Board.board[2][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 5:
                Board.board[2][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 6:
                Board.board[2][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 7:
                Board.board[4][1] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 8:
                Board.board[4][5] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            case 9:
                Board.board[4][9] = currentPlayer.getGamePiece();
                System.out.println();
                Board.printBoard();
                break;
            default:
                System.out.println("Incorrect enter! Please try again!");
                validMove = false;
                break;
        }
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
                return "Tic-Tac-Toe - First player won!";
            } else if (secondPlayerPositions.containsAll(l)) {
                return "Tic-Tac-Toe - Second player won!";
            }
        }

        if (firstPlayerPositions.size() + secondPlayerPositions.size() == 9) {
            return "It's a draw!";
        }

        return "";
    }
}


