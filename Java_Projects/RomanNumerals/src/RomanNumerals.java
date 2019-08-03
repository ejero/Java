/**
 * Created by Rosita Emakpo
 * Project title: Roman Numerals
 * Project Description: Project that converts positive integers to Roman Numerals.
 *
 */

import java.util.Scanner;

public class RomanNumerals {

    private int yourNum;
    private String Thousands;
    private String Fivehundred;
    private String oneHunred;
    private String twoHundred;
    private String threeHundred;
    private String fourHundred;
    private String sixHundred;
    private String sevenHundred;
    private String eightHundred;
    private String nineHunded;
    private String ninety;
    private String eighty;
    private String seventy;
    private String sixty;
    private String fifty;
    private String forty;
    private String thirty;
    private String twenty;
    private String ten;
    private String five;
    private String nine;
    private String eight;
    private String seven;
    private String six;
    private String four;
    private String three;
    private String two;
    private String one;
    private String romNum;


    /**
     * Constructs a Roman Numbers object with an empty string.
     */
    public RomanNumerals(){
        romNum = "";
        yourNum = 0;
        Thousands = "M";
        nineHunded = "CM";
        eightHundred = "DCCC";
        sevenHundred = "DCC";
        sixHundred = "DC";
        Fivehundred = "D";
        fourHundred = "CD";
        threeHundred = "CCC";
        twoHundred = "CC";
        oneHunred = "C";
        ninety = "XC";
        eighty = "LXXX";
        seventy = "LXX";
        sixty = "LX";
        fifty = "L";
        forty = "XL";
        thirty = "XXX";
        twenty = "XX";
        ten = "X";
        nine = "IX";
        eight ="VIII";
        seven = "VII";
        six = "VI";
        five = "V";
        four = "IV";
        three = "III";
        two = "II";
        one = "I";
    }

    /**
     * Method that takes user input integer then converts it to a Roman numeral.
     * no parameters.
     */

    public void convertInt(){

        Scanner num = new Scanner(System.in);
        System.out.println("Please provide an in from 1 to 3999");
        yourNum = num.nextInt();

        while (yourNum >= 1000 && yourNum<= 3999){
            System.out.print(Thousands);
            yourNum -= 1000;
            romNum = Thousands;
        }

        while(yourNum >= 900 && yourNum < 1000){
            System.out.print(nineHunded);
            yourNum -=900;
            romNum = nineHunded;
        }

        while(yourNum >= 800 && yourNum < 900){
            System.out.print(eightHundred);
            yourNum -=800;
            romNum = eightHundred;
        }

        while(yourNum >= 700 && yourNum < 800){
            System.out.print(sevenHundred);
            yourNum -=700;
            romNum = sevenHundred;
        }

        while(yourNum >= 600 && yourNum < 700){
            System.out.print(sixHundred);
            yourNum -=600;
            romNum = sixHundred;
        }

        while(yourNum >= 500 && yourNum < 600){
            System.out.print(Fivehundred);
            yourNum -=500;
            romNum = Fivehundred;
        }

        while(yourNum >= 400 && yourNum < 500){
            System.out.print(fourHundred);
            yourNum -=400;
            romNum = fourHundred;
        }

        while(yourNum >= 300 && yourNum < 400){
            System.out.print(threeHundred);
            yourNum -=300;
            romNum = threeHundred;
        }

        while(yourNum >= 200 && yourNum < 300){
            System.out.print(twoHundred);
            yourNum -=200;
            romNum = twoHundred;
        }

        while(yourNum >= 100 && yourNum < 200){
            System.out.print(oneHunred);
            yourNum -=100;
            romNum = oneHunred;
        }

        while(yourNum >= 90 && yourNum < 100){
            System.out.print(ninety);
            yourNum -=90;
            romNum = ninety;
        }

        while(yourNum >= 80 && yourNum < 90){
            System.out.print(eighty);
            yourNum -=80;
            romNum = eighty;
        }

        while(yourNum >= 70 && yourNum < 80){
            System.out.print(seventy);
            yourNum -=70;
            romNum = seventy;
        }

        while(yourNum >= 60 && yourNum < 70){
            System.out.print(sixty);
            yourNum -=60;
            romNum = sixty;
        }

        while(yourNum >= 50 && yourNum < 60){
            System.out.print(fifty);
            yourNum -=50;
            romNum = fifty;
        }

        while(yourNum >= 40 && yourNum < 50){
            System.out.print(forty);
            yourNum -=40;
            romNum = forty;
        }

        while(yourNum >= 30 && yourNum < 40){
            System.out.print(thirty);
            yourNum -=30;
            romNum = thirty;
        }

        while(yourNum >= 20 && yourNum < 30){
            System.out.print(twenty);
            yourNum -=20;
            romNum = twenty;
        }

        while(yourNum >= 10 && yourNum < 20){
            System.out.print(ten);
            yourNum -=10;
            romNum = ten;
        }

        while(yourNum >= 9 && yourNum < 10){
            System.out.print(nine);
            yourNum -=900;
            romNum = nine;
        }

        while(yourNum >= 8 && yourNum < 9){
            System.out.print(eight);
            yourNum -= 8;
            romNum = eight;
        }

        while(yourNum >= 7 && yourNum < 8){
            System.out.print(seven);
            yourNum -= 7;
            romNum = seven;
        }

        while(yourNum >= 6 && yourNum < 7){
            System.out.print(six);
            yourNum -= 6;
            romNum = six;
        }

        while(yourNum >= 5 && yourNum < 6){
            System.out.print(five);
            yourNum -= 5;
            romNum = five;
        }
        while(yourNum >= 4 && yourNum < 5){
            System.out.print(four);
            yourNum -= 4;
            romNum = four;
        }
        while(yourNum >= 3 && yourNum < 4){
            System.out.print(three);
            yourNum -= 3;
            romNum = three;
        }

        while(yourNum >= 2 && yourNum < 3){
            System.out.print(two);
            yourNum -= 2;
            romNum = two;
        }

        while(yourNum >= 1 && yourNum < 2){
            System.out.print(one);
            yourNum -= 1;
            romNum = one;
        }

    }


    /**
     * Method that will return the result in Roman numerals.
     * @return romNum;
     */
    public String getYourNum(){
        return romNum;
    }

}
