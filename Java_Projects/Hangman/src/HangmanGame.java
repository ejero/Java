/*
Project Title: Hangman Game
Project Description: Word guessing game
Version or Date: Version_01
Author: Rosita Emakpo
 */
import java.util.ArrayList;
public class HangmanGame {

    private String word;
    private int numberOfGuesses;
    private int numberOfLettersLeft;
    private char[] currentStateOfWord;

    private ArrayList<Character>lettersGuessed = new ArrayList<>();

    /**
     * Constructor sets up the game to be played with a word and some number of
     * guesses. The class should have private variables that keep track of:
     * <li>The original secret word
     * <li>The number of guesses remaining
     * <li>The number of letters that still need to be guessed
     * <li>The current state of word to be guessed (e.g. "L A B _ R A _ _ R Y")
     * @param secretWord the word that the player is trying to guess
     * @param numGuesses the number of guesses allowed
     */
    public HangmanGame(String secretWord, int numGuesses) {
        this.word = secretWord.toUpperCase();
        this.numberOfGuesses = numGuesses;
        numberOfLettersLeft = secretWord.length();
        currentStateOfWord = new char[secretWord.length()];
        for(int i = 0 ; i < currentStateOfWord.length ; i++) {
            currentStateOfWord[i] = '_';
        }

    }
    /**
     * @return the original secret word.
     */
    public String getSecretWord() {
        return word;
    }

    /**
     * Simulates the player guessing a letter in the word and updates the state of game
     * accordingly -- number of guesses remaining, number of letters
     * remaining to be guessed, the state of the secret word, and list of letters guessed.<br>
     * NOTES on GAME LOGIC:<br>
     * <li> if the guessed letter is not in the word, and hasn't been guessed yet, numGuesses is
     decremented
     * <li> if the guessed letter is in the word, and hasn't been guessed yet, then update the
     current state of
     * the guessed word to reveal the position(s) of the letter(s) that was just guessed, and
     update numLettersRemaining.
     * <li> There should be no guess penalty for guessing a letter that has already been
     * guessed - but should still return true/false that the char is/isn't in the word.
     * @param ch the char that is the next letter to be guessed on the word
     * @return true if the game isn't over and the guessed letter was in the word, false
    otherwise
     */
    public boolean makeGuess(char ch) {

        boolean found = false;
        if(lettersGuessed.contains(ch)){
            return false;
        }
        for(int i =0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(letter == ch){
                currentStateOfWord[i] = ch;
                numberOfLettersLeft --;
                found = true;
            }
        }

        lettersGuessed.add(ch);

        if(! found) {
            numberOfGuesses--;
        }
        return found;
    }


    /**
     * @return true if there are no more letters to be guessed and there is still at least one
    guess remaining
     */
    public boolean isWin() {
        if(numberOfLettersLeft == 0 && numberOfGuesses > 1){
            return true;
        }
        return false;
    }

    /**
     * @return true if either num guesses remaining is 0 or num letters remaining to be guessed
    is 0.
     */
    public boolean gameOver() {
        if(numberOfGuesses == 0 || numberOfLettersLeft == 0){
            return true;
        }
        return false;
    }

    /**
     * @return the number of guesses the player has left
     */
    public int numGuessesRemaining() {
        return numberOfGuesses;
    }

    /**
     * The number of letters remaining to be guessed in the secret word - i.e.
     * the number of blank spaces the player sees, which may be different from
     * the actually number of letters it will take to fill those blanks.
     * @return the number of letters in the secret word that still have to be guessed
     */
    public int numLettersRemaining() {

        return numberOfLettersLeft;

    }

    /**
     * Gives a display-ready String-ified version of the current state of the secret word, showing
     letters
     * that have been guessed and blank spaces for letters that still need to be guessed.
     * For example if the secret word is "LABORATORY" and the player has guessed L, A, B, R,
     and Y
     * the method might return something like "L A B _ R A _ _ R Y"
     * @return a String of the current state of the secret word.
     */
    public String displayGameState() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < currentStateOfWord.length; i++){
            builder.append(currentStateOfWord[i]);
            builder.append(" ");
        }
        return builder.toString();
    }

    /**
     * A String representing the letters guessed so far in the order they were guessed.
     * Duplicates should not be added.
     * @return a String showing which letters have already been guessed.
     */
    public String lettersGuessed() {
        StringBuilder s = new StringBuilder();
        for(char c : lettersGuessed) {
            s.append(c);
        }
        return s.toString();
    }


}
