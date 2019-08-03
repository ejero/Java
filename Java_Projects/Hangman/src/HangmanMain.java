/*
Project Title: Hangman Game
Project Description: Word guessing game
Version or Date: Version_01
Author: Rosita Emakpo
 */

import java.util.*;
public class HangmanMain {

    public static void main(String[] args){

        Scanner S = new Scanner(System.in);
        System.out.println("Welcome to Hangman!\nTry to guess the secret word one letter at a time.");
        HangmanGame game = new HangmanGame("umbrella", 5);

        while(!game.gameOver()){
            System.out.println("\nSecret Word: "+game.displayGameState());
            System.out.println("\nLetters Guessed: "+game.lettersGuessed());
            System.out.println("Guesses remaining: "+game.numGuessesRemaining());
            System.out.println("Letters remaining: "+game.numLettersRemaining());

            String input = "";
            while(input.length()<1){
                System.out.print("Next guess: ");
                input = S.nextLine().toUpperCase(); //ensure all guesses converted to upper case
                System.out.println(); //force the line break
            }
            char nextLetter = input.charAt(0);
            if(game.makeGuess(nextLetter)){
                System.out.println("Yes!");
            }
            else{
                System.out.println("Nope!");
            }
        }

        if(game.isWin()){
            System.out.println("\n\n"+game.displayGameState());
            System.out.println("CONGRATS! YOU WIN!");
        }
        else{
            System.out.println("Sorry, you lose. The word was: "+game.getSecretWord());
        }

    }


}
