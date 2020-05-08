package sample.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import sample.Main;

public class Page_admin_controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_orders;

    @FXML
    private Button bt_cars;

    @FXML
    private Button btn_users;

    @FXML
    private Button btn_logOut;

    @FXML
    void initialize() {
    }

    public void handleClicks(ActionEvent actionEvent){
        if (actionEvent.getSource()==btn_logOut) {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/start/Page_start.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }

