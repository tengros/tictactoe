import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
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
        Player firstPlayer = players.get(0);
        Player secondPlayer = players.get(1);
        firstPlayer.setGamePiece('X');
        secondPlayer.setGamePiece('O');
        System.out.println(firstPlayer.getName() + " starts the game using " +firstPlayer.getGamePiece());
    }

    }


