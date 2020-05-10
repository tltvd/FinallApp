package sample.admin.users;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.models.Order;
import sample.models.PackageData;
import sample.models.User;

public class Page_admin_users_controller {

    public static ArrayList<User> users;

    @FXML
    private Button btn_back;

    @FXML
    private TableView<User> table_users;

    @FXML
    private TableColumn<User, String> tableColumn_userid;

    @FXML
    private TableColumn<User, String> tableColumn_username;

    @FXML
    private TableColumn<User, String> tableColumn_firstname;

    @FXML
    private TableColumn<User, String> tableColumn_lastname;

    @FXML
    private Button btn_view;

    public static ObservableList<User> list;

    @FXML
    void initialize() {
        btn_back.setOnAction(event->{
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/users/Page_admin.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        PackageData dp = new PackageData("LIST_USERS_ADMIN");
        Main.connect(dp);
        list= FXCollections.observableArrayList(users);
        populateTableview();
        btn_view.setOnAction(event->{
            Page_userProfile_controller.user=table_users.getSelectionModel().getSelectedItem();
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/users/Page_admin_users_profile.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText("Please select the user!");
                alert.showAndWait();
            }
        });

    }


    private void populateTableview() {
        tableColumn_userid.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        tableColumn_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        tableColumn_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        tableColumn_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        table_users.setItems(list);
    }
}
