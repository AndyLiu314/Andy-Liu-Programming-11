package sample;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Controller  implements Initializable{
    //public Date date;
    public Label lblDate;
    public Button btnAddDate;
    public Button btnFindDate;
    public Button btnFindDate1;
    public javafx.scene.control.DatePicker DatePicker;
    public ListView EventList;
    public RadioButton radioHigh;
    public RadioButton radioMed;
    public RadioButton radioLow;
    public TextField txtName;
    public TextField txtInfo;
    public Label lblEvent;
    public Label lblName;
    public Label lblImportance;
    public Label lblInfo;
    public ToggleGroup Importance;
    public Label lblAlarmCurrentTime;
    public VBox btnSetAlarm;
    public TextField txtSeconds;
    public TextField txtMinutes;
    public TextField txtHours;
    public Button btnAlarmSet;
    public TextArea txtA;
    public Button btnRem;

    //this initializes the radio buttons so it can be used in the app
    public void initialize (URL url, ResourceBundle resource) {
        this.radioHigh.setUserData("High");
        this.radioLow.setUserData("Low");
        this.radioMed.setUserData("Medium");

        this.radioHigh.setToggleGroup(this.Importance);
        this.radioMed.setToggleGroup(this.Importance);
        this.radioLow.setToggleGroup(this.Importance);
    }
    //Writes a date to the events.txt and adds an Event object
    public void AddDate(ActionEvent actionEvent) throws IOException {
        LocalDate dt = DatePicker.getValue();
        String eventName=txtName.getText();
        String infoStr=txtInfo.getText();
        if(dt==null) {
            //limits the length of text in TextField to prevent bugs or issues.
            lblDate.setText("please pick a date!");
        } else if(eventName.trim().length()<1) {
            lblDate.setText("please enter an Event Name!");
        } else if(eventName.trim().length()>50) {
            lblDate.setText("Name - Maximum 50 Characters");
        } else if(infoStr.trim().length()>100) {
            lblDate.setText("Info - Maximum 100 Characters");
        } else {
            //if everything passes, a new Event object will be created using parameters from the TextFields.
            String imp = this.Importance.getSelectedToggle().getUserData().toString();
            Events event = new Events(dt,eventName, infoStr, imp);
            event.writeToFile(true);

            EventList.getItems().add(event);
            txtName.clear();
            txtInfo.clear();
            lblDate.setText("Success!");
        }
    }

    public void FindDate(ActionEvent actionEvent) {
        //finds current date using the Date class
        Date date = new Date();
        lblDate.setText(String.valueOf(date));
        lblAlarmCurrentTime.setText(String.valueOf(date));
    }

    public void DisplayEvent(MouseEvent mouseEvent) {
        //displays the selected event in the ListView
        Events en;
        en = (Events) EventList.getSelectionModel().getSelectedItem();
        lblEvent.setText(String.valueOf(en.getDate()));
        lblName.setText(en.getName());
        lblImportance.setText(String.valueOf(en.getImportance()));
        lblInfo.setText(en.getInfo());
        btnRem.setDisable(false);
    }

    public void SetAlarm(ActionEvent actionEvent) {
        try{
            //sets an alarm using the parameters such as Hours, Minutes, Seconds from TextField
            Date date = new Date();
            int hour = Integer.parseInt(this.txtHours.getText());
            int min = Integer.parseInt(this.txtMinutes.getText());
            int sec = Integer.parseInt(this.txtSeconds.getText());
            txtA.setText(date+"\nAlarm set for: "+hour+" Hours, "+min+" Minutes, "+sec+" Seconds");
            //adds all the time together in seconds.
            //1 hour is 3600s
            //1 minute is 60s
            Alarm alm=new Alarm(hour*60*60 + min*60 +sec,txtA);
            alm.runAlarm();
        } catch (Exception e) {
            //any invalid input will print out this message
            System.out.println("Invalid Value (Alarm)");
            txtA.setText("Invalid Value (Alarm)");
        }

    }

    public void RemoveEvent(ActionEvent actionEvent) {
        //clears text and removes Event object
        lblEvent.setText("");
        lblName.setText("");
        lblImportance.setText("");
        lblInfo.setText("");
        btnRem.setDisable(true);
        int selectedIdx = EventList.getSelectionModel().getSelectedIndex();
        EventList.getItems().remove(selectedIdx);

        //erases the previously saved txt in the events.txt
        ObservableList<Events> evt= EventList.getItems();
        int x=0;
        for (Events ev : evt) {
            if(x==0){
                ev.writeToFile(false);
            }else {
                ev.writeToFile(true);
            }
            x++;
        }
    }

    public void tabEventsChanged(Event event) {
        //this method updates the Listview whenever a different tab pane is selected.
        //before this, the Listview wouldnt update when I added an Event object
        String date="";
        String name="";
        String info="";
        String importance="";
        ObservableList<Events> evt= FXCollections.observableArrayList();
        EventList.getItems().clear();
        try{
            //this creates a new filereader to read the event.txt file
            FileReader fr=new FileReader("events.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            int i=0;
            //this looks through each line in event.txt to read
            while((line=br.readLine())!=null){
                if(i%5==0){
                    date=line;
                }else if(i%5==1){
                    name=line;
                }else if(i%5==2){
                    info=line;
                }else if(i%5==3){
                    importance=line;
                }else {
                    LocalDate dt = LocalDate.parse(date);
                    Events ev = new Events(dt,name,info,importance);
                    evt.add(ev);

                }
                i++;
            }
            br.close();
            //the text in each line of events.txt is added to EventList as Event objects
            EventList.setItems(evt);

        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
