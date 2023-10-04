public class Player {
    protected char letter;
    private String name;
    int numberOfWins = 0;


    public Player(String name, int numberOfWins) {
        this.name = name;
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfWinning() {
        return numberOfWins;
    }

    public void incrementNumberOfWins() {
        numberOfWins++;
        System.out.println(getName() + " has won " + numberOfWins + " times :)");
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
