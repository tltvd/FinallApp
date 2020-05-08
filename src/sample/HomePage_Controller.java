package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomePage_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label username_label;

    @FXML
    private Button home_button;

    @FXML
    private Button account_button;

    @FXML
    private Button my_Garage_button;

    @FXML
    private Button newCar_button;

    @FXML
    private Button tuning_button;

    @FXML
    private Button media_button;

    @FXML
    private Button logOut_button;

    @FXML
    private Button exit_button;

    @FXML
    private TextField search_textfield;

    @FXML
    private Pane pnlhome;

    @FXML
    private VBox pnItems;

    @FXML
    private Pane pnlMyGarage;

    @FXML
    private Pane pnlBuy;

    @FXML
    private VBox pnlBuy_items;

    @FXML
    private Pane pnlMedia;

    @FXML
    private Pane pnlTuning;

    @FXML
    private Pane pnlMyAccount;




    public void colorChange(Button button){

        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color : rgba(0,0,0,0.6)"));
        button.setOnMouseExited(event -> button.setStyle("-fx-background-color :  #181818"));
    }
    public void panechanger(Button button){
        button.setOnAction(event -> {
            if (button== my_Garage_button) {
                pnlhome.setVisible(false);
                pnlBuy.setVisible(false);

                pnlMedia.setVisible(false);
                pnlTuning.setVisible(false);
                pnlMyGarage.setVisible(true);
                pnlMyAccount.setVisible(false);
            }
            if (button==home_button) {
                pnlhome.setVisible(true);
                pnlBuy.setVisible(false);
                pnlMedia.setVisible(false);
                pnlTuning.setVisible(false);
                pnlMyGarage.setVisible(false);
                pnlMyAccount.setVisible(false);
            }
            if (button== newCar_button) {
                pnlhome.setVisible(false);
                pnlBuy.setVisible(true);

                pnlMedia.setVisible(false);
                pnlTuning.setVisible(false);
                pnlMyGarage.setVisible(false);
                pnlMyAccount.setVisible(false);
            }
            if (button==tuning_button) {
                pnlhome.setVisible(false);
                pnlBuy.setVisible(false);
                pnlMedia.setVisible(false);
                pnlTuning.setVisible(true);
                pnlMyGarage.setVisible(false);
                pnlMyAccount.setVisible(false);
            }
            if (button== media_button) {
                pnlhome.setVisible(false);
                pnlBuy.setVisible(false);

                pnlMedia.setVisible(true);
                pnlTuning.setVisible(false);
                pnlMyGarage.setVisible(false);
                pnlMyAccount.setVisible(false);
            }
            if (button== account_button) {
                pnlhome.setVisible(false);
                pnlBuy.setVisible(false);
                pnlMedia.setVisible(false);
                pnlTuning.setVisible(false);
                pnlMyGarage.setVisible(false);
                pnlMyAccount.setVisible(true);
            }
        });


    }


    @FXML
    void initialize() {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/sample/HomePage/overview/Item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> nodes[j].setStyle("-fx-background-color : rgba(0,0,0,0.6)"));
                nodes[i].setOnMouseExited(event -> nodes[j].setStyle("-fx-background-color : #02030A"));
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Node[] cars = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/sample/home/items/buy_pnl_item.fxml"));

                pnlBuy_items.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        colorChange(home_button);
        colorChange(logOut_button);
        colorChange(media_button);
        colorChange(tuning_button);
        colorChange(my_Garage_button);
        colorChange(newCar_button);
        colorChange(exit_button);
        colorChange(account_button);

        my_Garage_button.setOnAction(event -> panechanger(my_Garage_button));
        home_button.setOnAction(event -> panechanger(home_button));
        newCar_button.setOnAction(event -> panechanger(newCar_button));
        tuning_button.setOnAction(event -> panechanger(tuning_button));
        media_button.setOnAction(event -> panechanger(media_button));
        account_button.setOnAction(event -> panechanger(account_button));
        exit_button.setOnAction(event -> Main.window.close());
        logOut_button.setOnAction(event -> {
            try {
                Parent root2 = FXMLLoader.load(getClass().getResource("/sample/start/Page_start.fxml"));
                Main.setscene(root2);
                Main.window.centerOnScreen();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });




    }

    public void handleClicks(ActionEvent actionEvent) {
    }
}



