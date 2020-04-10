package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sun.security.x509.FreshestCRLExtension;

public class Controller {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtPhoneNumber;
    public TextField txtNickname;
    public Button btnAddFriend;
    public ListView <Friend> FriendList = new ListView<>();
    public Label lblName;
    public Label lblAge;
    public Label lblPhone;
    public Label lblNickname;
    public Button btnRemove;



    public void AddFriend(ActionEvent actionEvent) {
        Friend friend = new Friend(txtName.getText(), Integer.parseInt(txtAge.getText()), Long.parseLong(txtPhoneNumber.getText()), txtNickname.getText());
        FriendList.getItems().add(friend);
        txtName.clear();
        txtAge.clear();
        txtPhoneNumber.clear();
        txtNickname.clear();
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend friend;
        friend = FriendList.getSelectionModel().getSelectedItem();
        lblNickname.setText(friend.getNickname());
        lblName.setText(friend.getName());
        lblAge.setText(Integer.toString(friend.getAge()));
        lblPhone.setText(Long.toString(friend.getPhone()));
        btnRemove.setDisable(false);
    }

    public void RemoveFriend(ActionEvent actionEvent) {
        Friend friend;
        friend = FriendList.getSelectionModel().getSelectedItem();
        FriendList.getItems().remove(friend);
        lblNickname.setText("");
        lblName.setText("");
        lblAge.setText("");
        lblPhone.setText("");
        btnRemove.setDisable(true);
    }
}
