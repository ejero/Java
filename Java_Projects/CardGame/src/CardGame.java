/*
Project Title: Poker
Project Description: Implement a simulation of a popular casino game usually called video poker
Version or Date: 5/6/19
How to Start the Project: Press one
Author: Rosita Emakpo
User Instructions: Press 1 to play
 */

import java.util.Scanner;

public class CardGame {

    public static void main(String[] args){

        System.out.println("Welcome to the game of Poker!\nPlease press 1. to play or 2. to Quit\n");
        Scanner in = new Scanner(System.in);
        int startGame = in.nextInt();
        if(startGame == 1){
            DeckOfCards game = new DeckOfCards();
            game.shuffleDeck();
            game.dealCards();
            game.sortHand();

            game.displaySortedHand();

            System.out.println("Like your hand?\n 1. Keep Hand\n 2. Reject Some\n 3. Reject all ");
            Scanner in2 = new Scanner(System.in);
            int changeCards = in2.nextInt();
            if(changeCards == 1){
                game.payToken();
                game.scoreGame();
                game.tokenCount();

            }else if(changeCards == 2){
                game.replaceSome();
                game.sortHand();
                game.payToken();
                game.scoreGame();
                game.tokenCount();

            }else if(changeCards == 3){
                game.replaceAll();
                game.sortHand();
                game.payToken();
                game.scoreGame();
                game.tokenCount();
            }

        }else {
            System.out.println("Thank you for playing!");
        }
        System.out.println(" ");
        System.out.println("Would you like to play again?\n 1. Yes \n 2. No\n");
        Scanner in4 = new Scanner(System.in);

        int playAgain = in4.nextInt();

        if(playAgain == 1){
            DeckOfCards game = new DeckOfCards();
            game.shuffleDeck();
            game.dealCards();
            game.sortHand();

            game.displaySortedHand();

            System.out.println("Like your hand?\n 1. Keep Hand\n 2. Reject Some\n 3. Reject all ");
            Scanner in2 = new Scanner(System.in);
            int changeCards = in2.nextInt();
            if(changeCards == 1){
                game.payToken();
                game.scoreGame();
                game.tokenCount();

            }else if(changeCards == 2){
                game.replaceSome();
                game.sortHand();
                game.payToken();
                game.scoreGame();
                game.tokenCount();

            }else if(changeCards == 3){
                game.replaceAll();
                game.sortHand();
                game.payToken();
                game.scoreGame();
                game.tokenCount();

            }

        }else if(playAgain == 2){
            System.out.println(" Thank you for playing");
        }


    }


}

