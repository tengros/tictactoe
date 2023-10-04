public class Board {
    public static char[][] newBoard() {
        char[][] board = {
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},

        };
        return board;
    }


    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

}






