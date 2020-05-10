package sample.admin.users;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import sample.Main;
import sample.models.PackageData;
import sample.models.User;

public class Page_userProfile_controller {
    public static User user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_delete;

    @FXML
    private Label label_userID;

    @FXML
    private Label label_username;

    @FXML
    private Label label_password;

    @FXML
    private Label label_role;

    @FXML
    private Label label_lastName;

    @FXML
    private Label label_gender;

    @FXML
    private Label label_email;

    @FXML
    private Label label_phoneNumber;

    @FXML
    private Label label_city;

    @FXML
    private Button btn_back;

    @FXML
    private Label label_firstName;

    @FXML
    void initialize() {
        btn_back.setOnAction(event->{
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/users/Page_admin_users.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        label_userID.setText(user.getId_user());
        label_username.setText(user.getUsername());
        label_password.setText(user.getPassword());
        label_role.setText(user.getRole());
        label_lastName.setText(user.getLastname());
        label_firstName.setText(user.getFirstname());
        label_gender.setText(user.getGender());
        label_email.setText(user.getEmail());
        label_phoneNumber.setText(user.getPhone());
        label_city.setText(user.getCity());

        btn_delete.setOnAction(event->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete User");
            alert.setHeaderText("Are you sure you want to delete a user?");
            Optional<ButtonType> res= alert.showAndWait();
            if(res.get()==ButtonType.OK){
                PackageData packageData=new PackageData("DELETE_USER",user);
                Main.connect(packageData);
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/users/Page_admin_users.fxml"));
                    Main.setscene(root1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });
    }
}
