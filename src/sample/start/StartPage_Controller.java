package sample.start;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import sample.models.PackageData;
import sample.Main;
import sample.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class StartPage_Controller {

    public static User user;

    @FXML
    private TextField username_textfield;
    @FXML
    private PasswordField password_textfield;
    @FXML
    private Button sign_in_button;
    @FXML
    private Button sign_up_button;


    public void initialize() throws SQLException {
        sign_up_button.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/sample/signUp/Page_signUp.fxml"));
                Main.setscene(root);
                Main.window.centerOnScreen();


            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        sign_in_button.setOnAction(event -> {

            String username, password;
            username = username_textfield.getText().trim();
            password = password_textfield.getText().trim();
            loginUser(username,password);


        });
        password_textfield.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                String username, password;
                username = username_textfield.getText().trim();
                password = password_textfield.getText().trim();
                loginUser(username, password);
            }
        });
        username_textfield.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                String username, password;
                username = username_textfield.getText().trim();
                password = password_textfield.getText().trim();
                loginUser(username, password);
            }
        });
    }
    private void loginUser(String username, String password) {
        if (username.equals("") && password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please enter your username and password");
            alert.showAndWait();
        }
        if (!username.equals("") && password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please enter your password!");
            alert.showAndWait();
        }
        if (username.equals("") && !password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Please enter your username!");
            alert.showAndWait();
        }
        if (!username.equals("") && !password.equals("")) {
            User user_check = new User();
            user_check.setUsername(username);
            user_check.setPassword(password);
            PackageData pd = new PackageData("SIGN_IN", user_check);
            Main.connect(pd);

            if (user_check.getUsername().equals(user.getUsername()) && user_check.getPassword().equals(user.getPassword())) {
                try{
                    if (user.getRole().equals("ADMIN")) {
                        Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/Page_admin.fxml"));
                        Main.setscene(root1);
                    } else {
                        Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/Page_home.fxml"));
                        Main.setscene(root1);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Incorrect login or password!");
                alert.showAndWait();
            }
        }

    }
}

