public class Player {
    protected char letter;
    private String name;


    public Player(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }

    public char getGamePiece() {
        return letter;
    }

    public void setGamePiece(char gamePiece) {
        this.letter = gamePiece;
    }
}
