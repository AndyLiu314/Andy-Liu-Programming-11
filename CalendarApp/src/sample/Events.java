package sample;

import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class Events {
    private LocalDate date;
    private String name;
    private String info;
    private String importance;

    public Events(LocalDate date, String name, String info, String importance){
        //constructor for Event object which has date, name, info, and importance as parameters
        this.date = date;
        this.name = name;
        this.info = info;
        this.importance = importance;
    }

    public void writeToFile(boolean append) {
        try {
            //writes the Event object into the events.txt file using the parameters
            FileWriter fw = new FileWriter("events.txt", append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(date + "\r");
            bw.write(name + "\r");
            bw.write(info + "\r");
            bw.write(String.valueOf(importance) + "\r");
            bw.write(";\r");
            bw.close();
        }catch(Exception ex){
            //if the app is not able to write to the file, it will print this error message
            System.out.println(ex.getMessage());
        }
    }

    public LocalDate getDate() {
        return date;
    }
    public String getInfo() { return info; }
    public String getName() {
        return name;
    }
    public String getImportance() { return importance; }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setImportance(String importance) {
        this.importance = importance;
    }


    public String toString(){
        return name;
    }
}
