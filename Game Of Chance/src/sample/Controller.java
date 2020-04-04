package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;

public class Controller {
    public Label lblWalletAmount;
    public Label lblCurrentPool;
    public TextField txtGetAmount;
    public Button btnBet;
    public double pool = 0;
    public Button btnContinue;
    public Label lblWinLose;
    public Button btnReset;
    private double wallet = 15000;
    public Button btnSpin;
    public Label lblRandomNum;
    public int randnum;
    public Button btnHigher;
    public Button btnLower;
    public int answer;


    public void setWallet(double amt){
        wallet = amt;
    }

    public double getWallet (){
        return wallet;
    }

    public void setPool(double amt){
        pool = amt;
    }

    public double getPool(){
        return pool;
    }

    public void setRand(int amt) {randnum = amt;}

    public int getRand() { return randnum; }

    public void setAnswer(int amt) {answer = amt;}

    public int getAnswer() {return answer;}


    public void Bet(ActionEvent actionEvent) {
        double num = Double.parseDouble(txtGetAmount.getText());
        if (num <= wallet){
            setPool(pool+num);
            setWallet(wallet-num);
            lblCurrentPool.setText(Double.toString(getPool()));
            lblWalletAmount.setText(Double.toString(getWallet()));
            btnBet.setDisable(true);
            btnHigher.setDisable(false);
            btnLower.setDisable(false);
        }
    }

    public void Spin(ActionEvent actionEvent) {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(11);
            if(rand !=0) break;
        }
        setRand(rand);
        lblRandomNum.setText(Integer.toString(rand));
        btnBet.setDisable(false);
        btnSpin.setDisable(true);
    }

    public int GuessHigher(ActionEvent actionEvent) {
        setAnswer(1);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnHigher.setDisable(true);
        btnContinue.setDisable(false);
        return answer;
    }

    public int GuessLower(ActionEvent actionEvent) {
        setAnswer(0);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnHigher.setDisable(true);
        btnContinue.setDisable(false);
        return answer;
    }

    public void Continue(ActionEvent actionEvent) {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(11);
            if(rand !=0) break;
        }
        lblRandomNum.setText(Integer.toString(rand));


        if (answer == 1 && rand>randnum){
            setWallet(wallet += pool*2);
            lblWalletAmount.setText(Double.toString(getWallet()));
            setPool(0);
            lblCurrentPool.setText(Double.toString(getPool()));
            lblWinLose.setVisible(true);
            lblWinLose.setText("You Win!");
        }
        else if (answer == 0 && rand<randnum){
            setWallet(wallet += pool*2);
            lblWalletAmount.setText(Double.toString(getWallet()));
            setPool(0);
            lblCurrentPool.setText(Double.toString(getPool()));
            lblWinLose.setVisible(true);
            lblWinLose.setText("You Win!");
        }
        else {
            setPool(0);
            lblWinLose.setVisible(true);
            lblWinLose.setText("You Lose!");
            lblCurrentPool.setText(Double.toString(getPool()));
        }

        btnContinue.setDisable(true);
        btnSpin.setDisable(false);
    }

    public void Reset(ActionEvent actionEvent) {
        btnSpin.setDisable(false);
        btnContinue.setDisable(true);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnBet.setDisable(true);

        setPool(0);
        setWallet(15000);
        lblCurrentPool.setText(Double.toString(getPool()));
        lblWalletAmount.setText(Double.toString(getWallet()));

        setRand(0);
        lblRandomNum.setText(Integer.toString(randnum));

        lblWinLose.setVisible(false);
    }
}
