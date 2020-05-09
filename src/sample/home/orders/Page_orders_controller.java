package sample.home.orders;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.models.Car;
import sample.models.Order;
import sample.models.PackageData;
import sample.start.StartPage_Controller;

public class Page_orders_controller {

    public static ArrayList<Order> orders;

    @FXML
    private Button btn_back;

    @FXML
    private TableView<Order> table_orders;

    @FXML
    private TableColumn<Order, String> tableColumn_orderId;

    @FXML
    private TableColumn<Order, String> tableColumn_model;

    @FXML
    private TableColumn<Order, String> tableColumn_status;

    @FXML
    private TableColumn<Order, String> tableColumn_date;

    @FXML
    private TableColumn<Order, Integer> tableColumn_sum;

    public static ObservableList<Order> list;

    @FXML
    void initialize() {
        btn_back.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/Page_home.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        PackageData dp = new PackageData("LIST_ORDER", StartPage_Controller.user);
        Main.connect(dp);

        list=FXCollections.observableArrayList(orders);
        populateTableview();

    }

    private void populateTableview() {


        tableColumn_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        tableColumn_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableColumn_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableColumn_orderId.setCellValueFactory(new PropertyValueFactory<>("id_order"));
        tableColumn_sum.setCellValueFactory(new PropertyValueFactory<>("price"));

        table_orders.setItems(list);
    }


}
