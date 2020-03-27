import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.Date;

public class MethodTest {
    Customer test;

    @Before
    //created a customer
    public void setup(){
       test = new Customer("john", 123, 100, 100);
    }

    @Test
    public void testWithdrawCheck(){
        //create a new date object to use
        Date date = new Date();
        //check the amount already in the account
        assertEquals(test.findbalance("Checking"), 100, 0);
        //remove the specified amount from the account
        test.withdraw(50, date, "Checking");
        //check the new total of the account
        assertEquals(test.findbalance("Checking"), 50, 0);
    }

    @Test
    public void testWithdrawSaving(){
        Date date = new Date();
        //check the amount already in the account
        assertEquals(test.findbalance("Saving"), 100, 0);
        //remove specified amount from the account
        test.withdraw(50, date,"Saving");
        //check the new total of the account
        assertEquals(test.findbalance("Saving"), 50, 0);
    }

    @Test
    public void testDepositChecking(){
        Date date = new Date();
        //check the amount already in the account
        assertEquals(test.findbalance("Checking"), 100, 0);
        //add the specified amount to the account
        test.deposit(50,date,"Checking");
        //check the new total of the account
        assertEquals(test.findbalance("Checking"), 150, 0);
    }

    @Test
    public void testDepositSaving(){
        Date date = new Date();
        //check the amount already in the account
        assertEquals(test.findbalance("Saving"), 100, 0);
        //add the specified amount to the account
        test.deposit(50,date,"Saving");
        //check the new total of the account
        assertEquals(test.findbalance("Saving"), 150, 0);
    }

    @Test
    public void testDepositCheckingToString(){
        Date date = new Date();
        //create a new deposit object for the account
        Deposit d1 = new Deposit(100, date, "Checking");
        //create the desired String output
        String output = "Deposit Of: $100.0\tDate: "+date.toString()+"\tInto Account: Checking";
        //compare and make that both outputs are the same
        assertEquals(output, d1.toString());
    }

    @Test
    public void testDepositSavingToString() {
        Date date = new Date();
        //same as the previous test but with a Saving account
        Deposit d1 = new Deposit(250, date, "Saving");
        String output = "Deposit Of: $250.0\tDate: " + date.toString() + "\tInto Account: Saving";
        assertEquals(output, d1.toString());
    }

    @Test
    public void testWithdrawSavingToString() {
        Date date = new Date();
        //create a new withdraw object for the account
        Withdraw w1 = new Withdraw(250, date, "Saving");
        //create the desired String output
        String output = "Withdraw Of: $250.0\tDate: " + date.toString() + "\tFrom Account: Saving";
        //compare the outputs to ensure they are the same
        assertEquals(output, w1.toString());
    }

    @Test
    public void testWithdrawCheckingToString(){
        Date date = new Date();
        //same as the previous test but with a Checking account
        Withdraw w1 = new Withdraw(100, date, "Checking");
        String output = "Withdraw Of: $100.0\tDate: "+date.toString()+"\tFrom Account: Checking";
        assertEquals(output, w1.toString());
    }
}
