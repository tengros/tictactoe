public class Player {
    private String name;
    private char gamePiece;


    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(char gamePiece) {
        this.gamePiece = gamePiece;
    }
}
