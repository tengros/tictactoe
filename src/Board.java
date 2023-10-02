    public class Board {
        static char[][] board = {
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
                {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-', '-'},
                {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},

        };

        public static void printEmptyBoard1() {
            for (char[] row : board) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }

        }

    }






