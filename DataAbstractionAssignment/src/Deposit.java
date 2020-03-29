import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: Nothing
    //Modifies: this
    //Effects: returns a String showing the amount, date, and account of the deposit
    public String toString(){
        return "Deposit Of: $"+amount+"\tDate: "+date.toString()+"\tInto Account: "+account;
    }
}
