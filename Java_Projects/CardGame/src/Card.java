/*
Project Title: Poker
Project Description: Implement a simulation of a popular casino game usually called video poker
Version or Date: 5/6/19
How to Start the Project: Press on
Author: Rosita Emakpo
User Instructions: Press 1 to play
 */
public class Card
{
    private int rank;
    private String suit;

    public Card(int cardRank, String cardSuit){
        this.rank = cardRank;
        this.suit = cardSuit;
    }

    public String toString(){

        return rank + " of " + suit;
    }


    public int getRank(){

        return rank;
    }

    public String getSuit(){
        return suit;
    }

}
