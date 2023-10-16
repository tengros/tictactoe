public class Player {
    protected char letter;
    private String name;
    int numberOfWins = 0;


    // A player contains a name, a letter to play with and an int that tells how many times they won
    public Player(String name, char letter, int numberOfWins) {
        this.name = name;
        this.numberOfWins = numberOfWins;
        this.letter = letter;

    }

    public String getName() {
        return name;
    }


    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    // Increase with 1 every time a player won the game
    public void incrementNumberOfWins() {
        numberOfWins++;
        System.out.println(getName() + " has won " + numberOfWins + " times :)");
    }

    public String toString() {
        return getName();
    }
}
