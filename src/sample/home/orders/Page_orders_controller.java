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
        populateTableview();
        PackageData dp = new PackageData("LIST_ORDER", StartPage_Controller.user);
        Main.connect(dp);
        list=FXCollections.observableArrayList(orders);
    }

    private void populateTableview() {


        for (int i = 0; i < list.size(); i++) {
            tableColumn_model.setCellValueFactory(new PropertyValueFactory<>(orders.get(i).getCar().getModel()));
            tableColumn_orderId.setCellValueFactory(new PropertyValueFactory<>(orders.get(i).getOrder_id()));
            tableColumn_status.setCellValueFactory(new PropertyValueFactory<>(orders.get(i).getStatus()));
            tableColumn_date.setCellValueFactory(new PropertyValueFactory<>(orders.get(i).getDate()));
        }
        table_orders.setItems(list);

    }


}
