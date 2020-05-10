package sample.admin.orders;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.models.Order;
import sample.models.PackageData;



public class Page_admin_orders_controller {

    public static ArrayList<Order> orders;


    @FXML
    private TableView<Order> table_orders;

    @FXML
    private TableColumn<Order, String> tableColumn_orderId;

    @FXML
    private TableColumn<Order, String> tableColumn_user;

    @FXML
    private TableColumn<Order, String> tableColumn_model;

    @FXML
    private TableColumn<Order, String> tableColumn_status;

    @FXML
    private TableColumn<Order, String> tableColumn_date;

    @FXML
    private TableColumn<Order, Integer> tableColumn_sum;

    @FXML
    private ComboBox<String> order_status;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_delete;


    public static ObservableList<Order> list;
    public static ObservableList<String> combo;

    @FXML
    void initialize() {
        PackageData dp = new PackageData("LIST_ORDER_ADMIN");
        Main.connect(dp);
        list= FXCollections.observableArrayList(orders);
        populateTableview();
        btn_back.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/Page_admin.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ArrayList<String> str=new ArrayList<>();
        String st1="NEW";
        String st2="ACCEPTED";
        String st3="AWAITING PAYMENT";
        String st4="FORMED";
        String st5="RELEASED";
        String st6="COMPLETED";
        String st7="CANCELED";
        str.add(st1);
        str.add(st2);
        str.add(st3);
        str.add(st4);
        str.add(st5);
        str.add(st6);
        str.add(st7);
        combo= FXCollections.observableArrayList(str);
        order_status.setItems(combo);

        table_orders.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });
        btn_edit.setOnAction(event->{
            try {
            Order selectedItem = table_orders.getSelectionModel().getSelectedItem();
            selectedItem.setStatus(order_status.getSelectionModel().getSelectedItem());
            if(selectedItem.getStatus().equals("null")){
                selectedItem.setStatus(table_orders.getSelectionModel().getSelectedItem().getStatus());
            }
            PackageData packageData = new PackageData("CHANGE_STATUS",selectedItem);
            Main.connect(packageData);
            Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/orders/Page_admin_orders.fxml"));
            Main.setscene(root1);
            } catch (IOException ignored) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText("Please, select the cat to change status!");
            }
        });
        btn_delete.setOnAction(event->{
            Order selectedItem = table_orders.getSelectionModel().getSelectedItem();
            PackageData packageData = new PackageData("DELETE_ORDER",selectedItem);
            Main.connect(packageData);
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/admin/orders/Page_admin_orders.fxml"));
                Main.setscene(root1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    private void populateTableview() {
        tableColumn_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        tableColumn_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableColumn_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableColumn_orderId.setCellValueFactory(new PropertyValueFactory<>("id_order"));
        tableColumn_sum.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableColumn_user.setCellValueFactory(new PropertyValueFactory<>("username"));

        table_orders.setItems(list);
    }
    public void onEdit() {
        if (table_orders.getSelectionModel().getSelectedItem() != null) {
            Order selectedItem = table_orders.getSelectionModel().getSelectedItem();
            order_status.setValue(selectedItem.getStatus());
        }
    }
}
