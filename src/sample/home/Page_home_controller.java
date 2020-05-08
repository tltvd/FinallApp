package sample.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import sample.Main;

public class Page_home_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_orders;

    @FXML
    private Button btn_garage;

    @FXML
    private Button btn_logOut;

    @FXML
    private Button btn_catalog;


    @FXML
    void initialize() {
        btn_orders.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/orders/Page_orders.fxml"));
                Main.setscene(root1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btn_catalog.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_catalog.fxml"));
                Main.setscene(root1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btn_profile.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/profile/Page_profile.fxml"));
                Main.setscene(root1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btn_garage.setOnAction(event -> {
            try {
                Parent root2 = FXMLLoader.load(getClass().getResource("/sample/home/garage/Page_garage.fxml"));
                Main.setscene(root2);
                Main.window.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btn_logOut.setOnAction(event -> {
            try {
                Parent root2 = FXMLLoader.load(getClass().getResource("/sample/start/Page_start.fxml"));
                Main.setscene(root2);
                Main.window.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
