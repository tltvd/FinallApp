package sample.signUp;

import java.io.IOException;
import java.net.UnknownServiceException;

import sample.models.PackageData;
import sample.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import sample.Main;



public class Page_signUp_Controller {

    public static boolean checkUsername=false;

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

        String role="USER";

        User user=new User( username,password,firstname,lastname,city,phone,email,gender,role);

        boolean cheker=check(user);

        //PackageData packageData=new PackageData("USERNAME_CHECK",user);
       // Main.connect(packageData);
        /*
        else if(checkUsername= false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("imya zanyato!");
            alert.showAndWait();
        }
        */

        if(!cheker){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please check the information you provided!");
            alert.showAndWait();
        }
        else {
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


    private boolean check(User user){
        boolean res=false;
        if(!user.getUsername().isEmpty() && !user.getPassword().isEmpty() && !user.getFirstname().isEmpty()
                && !user.getLastname().isEmpty()  && !user.getCity().isEmpty() && !user.getPhone().isEmpty()
                && !user.getEmail().isEmpty() && !user.getGender().isEmpty() && !user.getRole().isEmpty() && user.getEmail().contains("@")){
            res=true;
        }
        return res;
    }

}