package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private ArrayList<Integer> Search (String word, ArrayList<String>lines) throws IOException{
        ArrayList<Integer> position = new ArrayList<Integer>();
        //linenum acts as a counter for the index of the lines
        int linenum = 0;
        for (String line : lines){
            //searches for the word and adds the linenum to the array list
            if((line.indexOf(word)) >= 0){
                position.add(linenum);
            }
            //if the word is not found, adds 1 to the count
            linenum++;
        }
        //returns the arraylist
        return position;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();

        Main test = new Main();
        ArrayList<Integer> linenumbers = test.Search("and", lines);
        //prints out the lines that the word is in
        for (int num : linenumbers) {
            System.out.println(num);
        }

    }
}