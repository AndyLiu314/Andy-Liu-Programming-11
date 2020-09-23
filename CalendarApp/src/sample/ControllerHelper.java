package sample;

import java.time.LocalDate;
//this class allows for the testing of the FindDate method
public class ControllerHelper {
    private LocalDate ctrlDate;

    public ControllerHelper (LocalDate dt) {
        this.ctrlDate=dt;
    }

    //this returns the date which can be used for testing
    public String FindDate() {
        return String.valueOf(this.ctrlDate);
    }
}
