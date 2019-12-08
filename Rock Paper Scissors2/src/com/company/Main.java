package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
            // write your code here
            Scanner scan = new Scanner(System.in);


        //I set string names here so I don't have to type these words out over and over again
        String uc = "Player Choice: ";
        String cc = "Computer Choice: ";
        String s = "Scissors!";
        String p = "Paper!";
        String r = "Rock!";
        String w = "You Win!";
        String l = "You Lose!";
        String d = "Draw!";
        String star = "*************************************";
        String title = "Choose rock, paper, or scissors. Type 'r' for rock, 'p' for paper, and 's' and for scissors. To exit, enter 'x'";
        String error = "Oops, invalid selection, please play again.";
        String end = "Thank You For Playing!";

        String choice = "";

        int wincounter = 0;
        int losecounter = 0;

        //This is the opening line and the instructions for the game
        System.out.println(title);

        //this scans for user input which equals choice


        do {
            //This generates a random number between 0 and 999
            double random = Math.random() * 1000;
            /*after a random number is obtained, divide it by 3 and the remainder is either 0, 1, or 2
            If the integer is 0, the computer chooses rock
            If the integer is 1, the computer chooses paper
            If the integer is 2, the computer chooses scissors
            */
            int response = (int) random % 3;


            System.out.println(star);
            System.out.println("Wins: " + wincounter  + "\tLosses: " + losecounter);
            System.out.println(uc);
            choice = scan.next();


            //if your choice is "r", the console will state "You win!", "You Lost!" or "Draw!" which depends on the number it got.
            if (choice.equals("r")) {
                /*after that, it will display it's choice of rock, paper or scissors depending on the randomly selected number
                It will also show the player's input and what they chose.
                 */
                if (response == 2) {
                    //this first line displays the outcome of the game and the whether you won or lost
                    System.out.println(w);
                    wincounter++;
                    //the second line displays the computer choice first and then the player choice.
                    System.out.println(cc + s + "\t" + uc + r);
                    //this process is repeated exactly the same way for the three other outcomes
                } else if (response == 0) {
                    System.out.println(d);
                    System.out.println(cc + r + "\t"+ uc + r);
                } else if (response == 1) {
                    System.out.println(l);
                    losecounter++;
                    System.out.println(cc + p + "\t"+ uc + r);
                }


            //If your choice is "p", the console will state "You win!", "You Lost!" or "Draw!" which depends on the number it got.
            } else if (choice.equals("p")) {
                //this process is the exact same as the one for rock
                //the only difference is that the results will change because the player picked paper
                if (response == 2) {
                    System.out.println(l);
                    losecounter++;
                    System.out.println(cc + s + "\t"+ uc + p);
                } else if (response == 0) {
                    System.out.println(w);
                    wincounter++;
                    System.out.println(cc + r + "\t"+ uc + p);
                } else if (response == 1) {
                    System.out.println(d);
                    System.out.println(cc + p + "\t"+ uc + p);
                }


                //If your choice is "s", the console will state "You win!", "You Lost!" or "Draw!" which depends on the number it got.
            } else if (choice.equals("s")) {
                //the process here is also the same as the other ones mentioned above except the results will be based off the player picking scissors.
                if (response == 2) {
                    System.out.println(d);
                    System.out.println(cc + s + "\t"+ uc + s);
                } else if (response == 0) {
                    System.out.println(l);
                    losecounter++;
                    System.out.println(cc + r + "\t"+ uc + s);
                } else if (response == 1) {
                    System.out.println(w);
                    wincounter++;
                    System.out.println(cc + p + "\t"+ uc + s);
                }

            //If anything other than 'r', 's', or, 'p' is inputted, an error message will popup telling you to play again
            } else if (!choice.equals("x")){
                System.out.println(error);
            }

        }while(!choice.equals("x"));


        if(choice.equals("x")){
            System.out.println(end);

        }
    }
}


