/*
Project Title: Game board
Project Description: Display game board.
Version or Date: version_01
How to Start the Project: run
Author: Rosita Emakpo
Palomar ID:  011434732
 */
public class GameBoard {

    public static final int ROW = 3;
    public static final int COL = 3;
    private char[][] gameBoard = new char[ROW][COL];

    /**
     * Constructs a game board.
     */
    public GameBoard() {

    }


    /**
     * Creates a board with 3 rows and 3 columns.
     */
    public void createBoard() {

        //rows
        for (int rows = 0; rows < 3; rows++) {
            //columns
            for (int columns = 0; columns < 3; columns++) {
                gameBoard[rows][columns] = ' ';
            }
        }

    }


    /**
     * Display game board.
     */
    public void displayBoard() {
        System.out.println(toString());

    }

    /**
     * @return 0 when the game is not completed.
     * 1 when the human has won. 2 when the computer has won. 3 for tie.
     */
    public int findWinner() {
        // check for a winner in a row
        for (int i = 0; i < ROW; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2]) {
                if (gameBoard[i][0] == 'X') return 1;
                if (gameBoard[i][0] == 'O') return 2;
            }
        }

        // check for a winner in the columns
        for (int i = 0; i < COL; i++) {
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i]) {
                if (gameBoard[0][i] == 'X') return 1;
                if (gameBoard[0][i] == 'O') return 2;
            }
        }
        // check the first diagonal
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) {
            if (gameBoard[0][0] == 'X') return 1;
            if (gameBoard[0][0] == 'O') return 2;
        }

        // check the opposite diagonal
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2]) {
            if (gameBoard[2][0] == 'X') return 1;
            if (gameBoard[2][0] == 'O') return 2;
        }
        // check for ties
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (gameBoard[i][j] == ' ') {
                    return 0;
                }
            }
        }

        return 3;
    }

    /**
     * Method to clear the game board.
     */
    public void clear() {
        for(int i = 0 ; i < ROW ; i++) {
            for(int j = 0 ; j < COL ; j++) {
                clear(i, j);
            }
        }
    }


    /**
     * Method that clears humans last move so computer can save losing move and learn.
     * @param row;
     * @param col;
     */
    public void clear(int row, int col) {
        gameBoard[row][col] = ' ';
    }

    /**
     * Get each token and save to copy of array. Returns the game board.
     * @param row;
     * @param col;
     * @return gameBoard;
     */
    public char get(int row, int col) {
        return gameBoard[row][col];
    }

    /**
     * Display game board as String.
     * @return b;
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < ROW; i++) {
            b.append("-------\n");
            for (int j = 0; j < COL; j++) {
                b.append("|");
                b.append(gameBoard[i][j]);
            }
            b.append("|\n");
        }
        b.append("-------\n");
        return b.toString();
    }

    /**
     * Human's turn to play a move. By a row and column. If false Computers move.
     * @param row;
     * @param col;
     * @param ch;
     * @return false
     */
    public boolean chooseMove(int row, int col, char ch) {

        if (gameBoard[row][col] == ' ') {
            gameBoard[row][col] = ch;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameBoard gameBoard1 = (GameBoard) o;
        for(int i = 0 ; i < ROW ; i++) {
            for(int j = 0 ; j < COL ; j++) {
                if(gameBoard1.get(i, j) != gameBoard[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
