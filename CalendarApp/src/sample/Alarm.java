package sample;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Alarm {
    //the toolkit is used to connect to the system in order to make a notification sound when the alarm goes off
    Toolkit toolkit;
    Timer timer;
    TextArea info;
    long delay;

    public Alarm (long delayTime, TextArea list) {
        //gets the toolkit needed for the windows notification sound
        this.toolkit = Toolkit.getDefaultToolkit();
        this.info=list;
        this.timer = new Timer();
        this.delay=delayTime;
    }

    public Alarm (long delayTime) {
        this.toolkit = Toolkit.getDefaultToolkit();
        this.timer = new Timer();
        this.delay=delayTime;
    }

    public void runAlarm(){
        Date date = new Date();
        //This prints out a message telling you how long until an alarm will sound
        System.out.println("Remind me after " + delay + " seconds." + date);
        //I multiply it by 1000 so it counts in seconds which is much easier to measure.
        //this schedules an alarm to go off after a specified amount of time
        timer.schedule(new RemindTask(), delay*1000,1*1000);
    }

    public String toString(){
        return "Remind me after " + delay + " seconds.";
    }


    class RemindTask extends TimerTask {
        //sets the amount of alarm beeps to 1
        int numWarningBeeps = 1;

        public void run() {
            try {
                if (numWarningBeeps > 0) {
                    //toolkit.beep is responsible for the beeping windows notification
                    toolkit.beep();
                    Date date = new Date();
                    //info is the TextArea that displays information about when the alarm is set for
                    String oldtxt = info.getText();
                    info.setText(oldtxt+"\nReminder: " + date);
                    System.out.println("Reminder: " + date);
                    //this will cancel the if statement because the numWarningBeeps will be 0
                    numWarningBeeps--;
                } else {
                    System.out.println("Timer Cancelled");
                    //cancels the alarm once it is completed
                    timer.cancel();
                }
            } catch (Exception e) {
                //if there is any exception, this message will display
                System.out.println("Exception: " + e.toString());
            }
        }
    }
}

