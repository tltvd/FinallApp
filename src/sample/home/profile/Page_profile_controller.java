package sample.home.profile;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import sample.models.PackageData;
import sample.models.User;
import sample.Main;
import sample.start.StartPage_Controller;


public class Page_profile_controller extends StartPage_Controller{


    @FXML
    private Button btn_cancel;


    @FXML
    private PasswordField field_newPassword;

    @FXML
    private PasswordField field_oldPassword;

    @FXML
    private Label label_firstName;

    @FXML
    private Label label_lastName;

    @FXML
    private Label label_username;

    @FXML
    private Label label_city;

    @FXML
    private Label label_email;

    @FXML
    private Label label_phoneNumber;

    @FXML
    private Button btn_change;

    @FXML
    void initialize(ActionEvent event) {

    }

    @FXML
    public void initialize() throws SQLException {



            label_lastName.setText(StartPage_Controller.user.getLastname());
            label_firstName.setText(StartPage_Controller.user.getFirstname());
            label_city.setText(StartPage_Controller.user.getCity());
            label_email.setText(StartPage_Controller.user.getEmail());
            label_phoneNumber.setText(StartPage_Controller.user.getPhone());
            label_username.setText(StartPage_Controller.user.getUsername());

        btn_cancel.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/Page_home.fxml"));
                Main.setscene(root1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btn_change.setOnAction(event ->{
            if( (!field_newPassword.getText().equals("") && !field_oldPassword.getText().equals(""))){
                User userUpdate =new User();
                if(field_oldPassword.getText().equals(StartPage_Controller.user.getPassword())){
                    userUpdate.setId_user(StartPage_Controller.user.getId_user());
                    userUpdate.setPassword(field_newPassword.getText().trim());
                    PackageData pd=new PackageData(userUpdate);
                    pd.setOperationType("UPDATE");
                    Main.connect(pd);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successfully!");
                    alert.setHeaderText("Your password has been successfully changed.");
                    alert.showAndWait();
                    field_oldPassword.setText("");
                    field_newPassword.setText("");
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("ERROR!");
                    alert.showAndWait();
                }

            }
        });

/*
        btn_change.setOnAction(event ->{
            if((!field_lastName.getText().equals("") && !field_lastName.getText().equals("")) || (!field_newPassword.getText().equals("") && !field_oldPassword.getText().equals(""))){
                User userUpdate =new User();
                if(!field_lastName.getText().equals("") && !field_lastName.getText().equals("")){
                    userUpdate.setId_user(StartPage_Controller.user.getId_user());
                    userUpdate.setFirstname(field_firstName.getText());
                    userUpdate.setLastname(field_lastName.getText());
                    PackageData pd=new PackageData(userUpdate);
                    pd.setOperationType("UPDATE_FULLNAME");
                    Main.connect(pd);
                }
                else if(!field_newPassword.getText().equals("") && field_oldPassword.getText().equals(StartPage_Controller.user.getPassword())){
                    userUpdate.setId_user(StartPage_Controller.user.getId_user());
                    userUpdate.setPassword(field_newPassword.getText());
                    PackageData pd=new PackageData(userUpdate);
                    pd.setOperationType("UPDATE_PASSWORD");
                    Main.connect(pd);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successfully!");
                    alert.setHeaderText("Your password has been successfully changed.");
                    alert.showAndWait();
                }
                else if(!field_lastName.getText().equals("") && !field_lastName.getText().equals("") && !field_newPassword.getText().equals("") && field_oldPassword.getText().equals(StartPage_Controller.user.getPassword())){
                    userUpdate.setId_user(StartPage_Controller.user.getId_user());
                    userUpdate.setFirstname(field_firstName.getText());
                    userUpdate.setLastname(field_lastName.getText());
                    userUpdate.setPassword(field_newPassword.getText());
                    PackageData pd=new PackageData(userUpdate);
                    pd.setOperationType("UPDATE_ALL");
                    Main.connect(pd);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successfully!");
                    alert.setHeaderText("Your first and last name has been successfully changed.");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Old password incorect!");
                    alert.showAndWait();
                }

            }
        });

 */



    }
}
