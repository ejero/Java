/**
 * Created by Rosita Emakpo
 * Project title: Roman Numerals
 * Project Description: Project that converts positive integers to Roman Numerals.
 * User Instructions: Type in a positive integer to display the Roman numeral equivalent.
 */


import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class RomanNumTester {

    public static void main (String[] args){

        try{
            PrintWriter out = new PrintWriter("out.txt");
            RomanNumerals r1 = new RomanNumerals();
            r1.convertInt();
            out.printf( "Your number is:  " + r1.getYourNum());
            out.close();
        }

        catch(FileNotFoundException exception){
            System.out.println("File not found");
        }

    }
}
