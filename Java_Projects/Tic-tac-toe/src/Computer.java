/*
Project Title: Computer-AI class
Project Description: Computer will learn by saving losing moves to an array.
Version or Date: version_01
Author: Rosita Emakpo
 */
import java.util.Random;
import java.util.ArrayList;

public class Computer {

    //keep track of losing games.
    ArrayList<GameBoard> losingGames = new ArrayList<GameBoard>();
    Random rand;

    /**
     * Constructs a Computer that will first take a random move.
     */
    public Computer(){
        rand = new Random(0);

    }

    /**
     * Computer A.I saves immediately preceding losing combination in an ArrayList to "learn".
     * @param board;
     */
    public void saveBoard(GameBoard board) {
        GameBoard copy = new GameBoard();
        copy.createBoard();
        for(int i = 0 ; i < GameBoard.ROW ; i++) {
            for(int j = 0 ; j < GameBoard.COL ; j++) {
                copy.chooseMove(i, j, board.get(i, j));
            }
        }
        losingGames.add(copy);
    }

    /**
     * Computer (AI)makes a random move.
     * @param board;
     */
    public void makeMove(GameBoard board) {
        int i = 0;
        while(true) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if(board.chooseMove(row, col, 'O')) {
                // the move has been chosen, is it a losing move
                // we can find out by going through all of what we have to see if it has been seen before
                boolean winning = true;
                for(GameBoard losing: losingGames) {
                    if(losing.equals(board)) {
                        i++;
                        if(i == 100) {
                            System.out.println("No winning moves");
                            winning = true;
                            break;
                        }
                        //System.out.println("THAT LOSES");
                        board.clear(row, col);
                        winning = false;
                    }
                }
                if(winning) {
                    break;
                }
            }
        }
    }
}
