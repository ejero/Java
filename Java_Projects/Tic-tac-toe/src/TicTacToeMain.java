/*
Project Title: Main tic-tac-toe class to play the game
Project Description: Display game board.
Version or Date: version_01
Author: Rosita Emakpo
How to play: Enter row and column to make a move.
 */

import java.util.Scanner;
public class TicTacToeMain {

    static Scanner sc;


    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Welcome to the game of Tic-Tac-Toe\n");
        GameBoard gameBoard = new GameBoard();
        gameBoard.createBoard();
        Computer computer = new Computer();

        //stops playing when false.
        while (true) {
            playGame(gameBoard, computer);
            System.out.println("Do you want to play again y or n ?");
            String s = sc.nextLine().trim();
            if (s.isEmpty() || s.charAt(0) == 'n' || s.charAt(0) == 'N') {
                System.out.println("Bye");
                break;
            }
            //computer.rand = new Random(0);
            gameBoard.clear();
        }

    }

    private static void playGame(GameBoard gameBoard, Computer computer) {

        while (true) {
            System.out.println(gameBoard);
            System.out.println("Please choose a row and a column (example: 1 1)\n");
            int row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();

            if (row >= 0 && row < GameBoard.ROW && col >= 0 && col < GameBoard.COL) {
                if (!gameBoard.chooseMove(row, col, 'X')) {
                    System.out.println("That square is already occupied");
                } else {
                    //Human has played a valid move
                    int winner = gameBoard.findWinner();
                    if (winner == 1) {
                        gameBoard.displayBoard();
                        System.out.println("Congrats you won");
                        gameBoard.clear(row, col);
                        computer.saveBoard(gameBoard);
                        return;
                    } else if (winner == 3) {
                        gameBoard.displayBoard();
                        System.out.println("It's a tie");
                        return;
                    }
                    computer.makeMove(gameBoard);
                    winner = gameBoard.findWinner();
                    if (winner == 2) {
                        gameBoard.displayBoard();
                        System.out.println("The computer won");
                        return;
                    } else if (winner == 3) {
                        System.out.println("It's a tie");
                        return;

                    }
                }

            } else {
                System.out.println("Not valid move");
            }
        }
    }
}
