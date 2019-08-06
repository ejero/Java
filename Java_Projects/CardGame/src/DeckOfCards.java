/*
Project Title: Poker
Project Description: Implement a simulation of a popular casino game usually called video poker
Version or Date: 5/6/19
How to Start the Project: Press on
Author: Rosita Emakpo
User Instructions: Press 1 to play
 */

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;

public class DeckOfCards {
    private Card[] deck;
    private int token;
    private int pair;


    public DeckOfCards() {
        //Ace = 1 , Jack = 11, Queen = 12, King = 13.
        int [] rank = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] suit = {"Diamonds", "Clubs", "Hearts", "Spades"};
        this.deck = new Card[52];
        token = 50;
        pair = 0;



        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < 13; x++) {
                //Add a rank and suit to each card creating a deck of 52 cards
                deck[(x + (i * 13))] = new Card(rank[x], suit[i]);
            }
        }
    }




    /**
     * Displays deck in sorted order.
     */
    public void displayDeck() {
        for (Card card : deck)
            System.out.println(card);
    }


    /**
     * Method to shuffle the deck.
     */
    public void shuffleDeck() {

        int cardCount = deck.length;
        Random number = new Random();
        for (int i = 0; i < deck.length; i++) {
            int firstPosition = 0;
            int secondPosition = number.nextInt(cardCount - 1);

            //Switching the cards position.
            Card temp = deck[firstPosition];
            deck[firstPosition] = deck[secondPosition];
            deck[secondPosition] = temp;

            //Print shuffled array
            System.out.println(deck[i]);
        }
    }


    /**
     * Deals first 5 cards after deck as been shuffled.
     */
    public void dealCards() {
        //printing 5 cards
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                System.out.println(" ");
            }
            //System.out.print(deck[i]);
        }
    }




    /**
     * Display sorted hand.
     */

    public void displaySortedHand(){
        try{
            PrintWriter out = new PrintWriter("csis.txt");
            sortHand();
            for(int i = 0; i < 5; i++){
                System.out.println(deck[i]);
                out.println(deck[i]);
            }
            System.out.println(" ");
            out.close();
        }

        catch (FileNotFoundException exception){
            System.out.println("File not found!");
        }
    }


    /**
     * Method to replace some cards from hand. Chooses 3 new elements from deck array. Hand will now show
     * index 2 - 4 with new cards.
     */
    public void replaceSome(){
        System.out.println(" ");

        for (int first = 0; first < 3; first++) {
            Card pos = deck[deck.length - 1];
            int second;
            for (second = deck.length - 1; second > 0; second--)
                deck[second] = deck[second - 1];
            deck[second] = pos;
        }

        sortHand();
        for(int i = 0; i < 5; i++){
            System.out.println(deck[i]);
        }
        System.out.println(" ");
    }


    /**
     * Method to replace all cards in hand. Moves index 6 elements. Then sorts and prints array.
     */
    public void replaceAll() {
        System.out.println(" ");
        for (int first = 0;  first< 6; first++) {
            Card pos = deck[deck.length - 1];
            int second;
            for (second = deck.length - 1; second > 0; second--)
                deck[second] = deck[second - 1];
            deck[second] = pos;
        }

        sortHand();
        for(int i = 0; i < 5; i++){
            System.out.println(deck[i]);
        }
        System.out.println(" ");
    }



    /**
     * Pay a token each time player plays a hand.
     */
    public void payToken() {
        token--;
        System.out.println("You have " + token + " tokens left");
    }



    /**
     * Method to sort a hand of cards by rank value. Sorting is needed to compare the cards
     * later.
     */
    public void sortHand(){
        int first, second,low;


        for(first = 0; first < 5; first++){
            low = first;
            for(second = first + 1; second < 5; second++){
                if(deck[second].getRank() < deck[low].getRank()){
                    low = second;
                }
            }
            //Swapping Elements
            Card temp = deck[first];
            deck[first] = deck[low];
            deck[low] = temp;
        }
    }



    /**
     * Method to check hand for one pair.
     * @return pair;
     */
    public boolean checkPair() {
        boolean pair = false;

        sortHand();
        if ((deck[0].getRank() == deck[1].getRank() || (deck[0].getRank() == deck[2].getRank()
                || (deck[0].getRank() == deck[3].getRank() || (deck[0].getRank() == deck[4].getRank()))))) {
            pair = true;

        }else if((deck[1].getRank() == deck[2].getRank() || (deck[1].getRank() == deck[3].getRank()
                || (deck[1].getRank() == deck[4].getRank())))){
            pair = true;

        }else if((deck[2].getRank() == deck[3].getRank() || (deck[2].getRank() == deck[4].getRank()))){
            pair = true;

        }else if((deck[3].getRank() == deck[4].getRank())){
            pair = true;

        }
        return pair;
    }

    /**
     * Check hand for two pair.
     * @return twoPair;
     */
    public boolean checkTwoPair(){
        boolean twoPair = false;

        for(int i = 0; i < 5; i++){

            if ((deck[0].getRank() == deck[1].getRank() && (deck[2].getRank() == deck[3].getRank()
                    || (deck[1].getRank() == deck[2].getRank() && (deck[3].getRank() == deck[4].getRank()
                    || (deck[0].getRank() == deck[1].getRank() && (deck[3].getRank() == deck[4].getRank()))))))) {
                twoPair = true;
            }
        }
        return twoPair;
    }


    /**
     *Test if hand has three cards of same value.
     * @return threeOfAKind;
     */
    public boolean checkThreeOfAKind(){
        boolean threeOfAKind = false;

        for(int i = 0; i < 5; i++){
            if((deck[0].getRank() == deck[1].getRank() && (deck[0].getRank() == (deck[2].getRank())))) {
                threeOfAKind = true;
            }else if((deck[1].getRank() == deck[2].getRank()) && (deck[1].getRank())== deck[3].getRank()){
                threeOfAKind = true;
            }else if((deck[2].getRank() == deck[3].getRank()) && (deck[2].getRank() == deck[4].getRank())){
                threeOfAKind = true;
            }

        }
        return threeOfAKind;
    }


    /**
     * Chcecks if hand has four of a kind.
     * @return fourOfAKind.
     */
    public boolean checkFourOfAKind(){
        boolean fourOfAKind = false;

        for(int i = 0; i < 5; i++){
            if(deck[0].getRank() == deck[1].getRank() && (deck[0].getRank() == deck[2].getRank())
                    && (deck[0].getRank() ==  deck[3].getRank())){
                fourOfAKind = true;
            }else if((deck[2].getRank() == deck[2].getRank() && (deck[1].getRank() == deck[3].getRank())
                    && (deck[1].getRank() ==  deck[4].getRank()))){
                fourOfAKind = true;
            }
        }
        return fourOfAKind;
    }

    /**
     * Checks hand for straight: five cards with consecutive values, no same suit.
     * @return straight.
     */
    public boolean checkStraight(){
        sortHand();
        boolean straight = false;
        for(int i = 0; i < 5; i++){
            if(deck[0].getRank() + 1 == deck[1].getRank() && (deck[1].getRank() + 1 == deck[2].getRank())
                    && (deck[2].getRank() + 1 ==  deck[3].getRank()
                    && (deck[3].getRank() + 1 == deck[4].getRank())))
                straight = true;
        }
        return straight;
    }


    /**
     * Checks hand for flush. Five cards of same suit.
     * @return flush.
     */
    public boolean checkFlush(){
        sortHand();
        boolean flush = false;
        for(int i = 0; i < 5; i++){
            if(deck[0].getSuit() == deck[1].getSuit() && (deck[1].getSuit() == deck[2].getSuit()
                    && (deck[2].getSuit() == deck[3].getSuit()
                    && deck[3].getSuit() == deck[4].getSuit())))
                flush = true;
        }

        return flush;
    }

    /**
     * Checks hand for Fullhouse. Three of a kind and a pair.
     * @return fullHouse
     */
    public boolean checkFullHouse(){
        sortHand();
        boolean fullHouse = false;
        for(int i = 0; i < 5; i++){
            if(checkThreeOfAKind() && checkTwoPair())
                fullHouse = true;
        }

        return fullHouse;
    }


    /**
     *Checks hand for straight flush.  Five cards with consecutive values of the same suit
     * @return straightFlush.
     */
    public boolean checkStraightFlush(){
        sortHand();
        boolean straightFlush = false;
        if(checkStraight() && checkFlush()){
            straightFlush = true;

        }
        return straightFlush;
    }

    /**
     * Checks hand for royal flush. Best hand, A 10, jack, queen, king, and ace, all of the same suit
     * @return RoyalFlush.
     */
    public boolean checkRoyalFlush(){
        //Ace = 1 , Jack = 11, Queen = 12, King = 13.
        sortHand();
        boolean RoyalFlush = false;
        for(int i = 0; i < 5; i++){
            if(checkFlush()
                    && deck[0].getRank() == 1
                    && deck[1].getRank() == 10
                    && deck[2].getRank() == 11
                    && deck[3].getRank() == 12
                    && deck[4].getRank() == 13)

                RoyalFlush = true;
        }
        return RoyalFlush;
    }

    /**
     * Tally the tokens earned.
     * @return token.
     */
    public int tokenCount(){
        System.out.println("You now have " + token + " tokens left.");
        return token;
    }

    /**
     * Method to test each possible winning poker hand. From best hand to worst.
     */
    public void scoreGame(){

        if(checkRoyalFlush()){
            checkRoyalFlush();
            token += 250;
            System.out.println("Royal flush");

        }else if(checkStraightFlush()){
            checkStraightFlush();
            token += 50;
            System.out.println("Straight flush");

        }else if(checkFourOfAKind()){
            checkFourOfAKind();
            token += 25;
            System.out.println("Four of a kind");

        }else if(checkFullHouse()){
            checkFullHouse();
            token+=6;
            System.out.println("Full house");

        }else if(checkFlush()){
            checkFlush();
            token += 4;
            System.out.println("Flush");

        }else if( checkStraight()){
            checkStraight();
            token +=4;
            System.out.println("Straight");

        }else if(checkThreeOfAKind()){
            checkThreeOfAKind();
            token+=3;
            System.out.println("Three of a kind");

        }else if(checkTwoPair()){
            checkTwoPair();
            token+=2;
            System.out.println("Two pair");

        }else if(checkPair()){
            checkPair();
            token +=1;
            System.out.println("One Pair");

        }else
            System.out.println("No pair, lowest hand!");


    }



}




