public class Player {
    protected char letter;
    private String name;
    int numberOfWins = 0;


    public Player(String name, char letter, int numberOfWins) {
        this.name = name;
        this.numberOfWins = numberOfWins;
        this.letter = letter;

    }

    public String getName() {
        return name;
    }


    public char getGamePiece() {
        return letter;
    }

    public void setGamePiece(char gamePiece) {
        this.letter = gamePiece;
    }

    public void incrementNumberOfWins() {
        numberOfWins++;
        System.out.println(getName() + " has won " + numberOfWins + " times :)");
    }

    public String toString() {
        return getName();
    }
}
