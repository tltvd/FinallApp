package sample.signUp;

import java.io.IOException;

import sample.models.PackageData;
import sample.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import sample.Main;



public class Page_signUp_Controller {

    @FXML
    private PasswordField password_textfield;
    @FXML
    private Button register_button;
    @FXML
    private Button cancel_button;
    @FXML
    private TextField username_textfield;
    @FXML
    private TextField email_textfield;
    @FXML
    private TextField number_textfield;
    @FXML
    private RadioButton male_rad_button;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton female_rad_button;
    @FXML
    private TextField firstname_textfield;
    @FXML
    private TextField lastname_textfield;
    @FXML
    private TextField city_textfield;
    @FXML
    void initialize() {
        cancel_button.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/start/Page_start.fxml"));
                Main.setscene(root1);
                Main.window.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        register_button.setOnAction(event -> signUpNewUser());
    }

    private void signUpNewUser() {
        String password = password_textfield.getText();
        String username=username_textfield.getText();
        String firstname=firstname_textfield.getText();
        String lastname=lastname_textfield.getText();
        String city=city_textfield.getText();
        String gender;
        String email=email_textfield.getText();
        String phone=number_textfield.getText();
        if(male_rad_button.isSelected())
            gender="Male";
        else
            gender="Female";
        if(!male_rad_button.isSelected() && !female_rad_button.isSelected()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Choose gender!");
            alert.showAndWait();
        }

        String role="USER";


        User user=new User( username,password,firstname,lastname,city,phone,email,gender,role);
        PackageData pd=new PackageData("SIGN_UP",user);
        Main.connect(pd);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Registration completed!");
        alert.showAndWait();
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("/sample/start/Page_start.fxml"));
            Main.setscene(root1);
            Main.window.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}