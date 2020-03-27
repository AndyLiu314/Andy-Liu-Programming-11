import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: Nothing
    //Modifies: this
    //Effects: returns a String showing the amount, date, and account of the withdraw
    public String toString(){
        return "Withdraw Of: $"+amount+"\tDate: "+date.toString()+"\tFrom Account: "+account;
    }
}
