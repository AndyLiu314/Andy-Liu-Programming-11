package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //this is the opening instruction
        System.out.println("To begin the encryption, please type in a word or letter. After that, type in the new string and it will be decrypted into your original input.");

        //this creates a loop that only runs twice. The first time is to encrypt the string and the second time is meant to decrypt
        for (int i = 0; i < 2; i++) {

            //this sets up the scanner to read any string including ones with spaces.
            String choice = "";
            choice = scan.nextLine();
            //this changes your string input into an integer
            int length = choice.length();

            //if this your first input, this block of code will be executed.
            if (i == 0) {
                //if the length of the string is less than equal to 1 (if it is one letter or less), the code will add an "a" to the end of the string to encrypt it.
                if (length <= 1) {
                    System.out.println(choice + "a");
                } else {
                    //every other length will be encrypted by moving the first letter to the end and adding an "a"
                    //code refers to the first letter
                    String code = choice.substring(0,1);
                    //code1 refers to every other letter in the string
                    String code1 = choice.substring(1,length);
                    //this encrypts the string
                    System.out.println(code1+code+"a");
                }
            //this is your second input and the decryption
            } else {
                //if the length of the string is less than equal to 2, it will take out the last letter which decrypts all string that originated as a single letter.
                if (length <= 2) {
                    System.out.println(choice.substring(0,length-1));
                //else refers to every other length
                } else {
                    //code is the second last letter and not the last letter because an "a" was added to the end as part of the encryption. This removes the "a"
                    String code = choice.substring(length-2, length-1);
                    //code1 refers to all the other letters in the string
                    String code1 = choice.substring(0,length-2);
                    //this swaps the last letter and everything else which decrypts the string into it's original string
                    System.out.println(code + code1);
                }
            }
        }
    }
}