import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //Constructor
    Customer(){
        name = "Unknown";
        accountNumber = 0;
        savingBalance = 0.0;
        checkBalance = 0.0;
    }

    Customer(String name, int accountNumber, double savingBalance, double checkBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;
        this.deposits = new ArrayList<Deposit>();
        this.withdraws = new ArrayList<Withdraw>();
    }

    //Requires: amt >= 0, a date, and the String "Checking" or "Saving" for which account it is going into
    //Modifies: this, deposits
    /*Effects: adds amt to checkBalance or savingBalance
               adds a new Deposit object into the deposits ArrayList
               returns amt deposited
     */
    public double deposit(double amt, Date date, String account){
        if(account == CHECKING){
            checkBalance += amt;
            Deposit dp = new Deposit(amt, date, account);
            this.deposits.add(dp);
            return amt;
        }
        if (account == SAVING){
            savingBalance += amt;
            Deposit dp = new Deposit(amt, date, account);
            this.deposits.add(dp);
            return amt;
        }
        return 0;
    }

    //Requires: amt >= 0, a date, and the String "Saving" or "Checking" for which account it is going into
    //Modifies: this, withdraws
    /*Effects: removes amt from checkBalance or savingBalance only if checkOverdraft returns false
               adds a new withdraw object into the withdraws ArrayList
               returns amt withdrawn
     */
    public double withdraw(double amt, Date date, String account){
        if(account == CHECKING){
            if(!checkOverdraft(amt, account)){
                checkBalance -= amt;
                Withdraw wd = new Withdraw(amt, date,account);
                this.withdraws.add(wd);
                return amt;
            } else {
                System.out.println("Checking Account Withdraw Failed");
            }
        }
        if(account == SAVING){
            if(!checkOverdraft(amt, account)){
                savingBalance -= amt;
                Withdraw wd = new Withdraw(amt, date,account);
                this.withdraws.add(wd);
                return amt;
            } else {
                System.out.println("Saving Account Withdraw Failed");
            }
        }
        return 0;
    }

    //Requires: amt >= 0, the String "Checking" or "Saving" for which account it is going into
    //Modifies: this
    //Effects: returns true if the withdraw goes above the OVERDRAFT limit, returns false if it doesn't
    private boolean checkOverdraft(double amt, String account){
        if(account == CHECKING){
            if(checkBalance - amt < OVERDRAFT){
                return true;
            }
        }
        if (account == SAVING){
            if(savingBalance - amt < OVERDRAFT){
                return true;
            }
        }
        return false;
    }

    //Requires: String "Checking" or "Saving" for which account it is going into
    //Modifies: this
    //Effects: returns checkBalance or savingBalance
    public double findbalance (String account){
        if (account == CHECKING){
            return checkBalance;
        }
        if (account == SAVING){
            return savingBalance;
        }
        return 0;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
