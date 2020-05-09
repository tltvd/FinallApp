package sample.home.garage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import sample.models.Car;
import sample.DataBase.DatabaseHandler;
import sample.Main;
import sample.models.Order;
import sample.models.PackageData;
import sample.start.StartPage_Controller;

public class Page_garage_controller {

    public static ArrayList<Order> orders;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_save;

    @FXML
    private TableView<Order> table_cars;

    @FXML
    private TableColumn<Order, String> tableColumn_model;

    @FXML
    private TableColumn<Order, String> tableColumn_bodyType;

    @FXML
    private TableColumn<Order, String> tableColumn_year;

    @FXML
    private TableColumn<Order, String> tableColumn_hp;

    @FXML
    private TableColumn<Order, String> tableColumn_time;

    private ObservableList<Order> list;

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

        PackageData dp = new PackageData("LIST_GARAGE", StartPage_Controller.user);
        Main.connect(dp);
        list=FXCollections.observableArrayList(orders);
        populateTableview();
    }

    private void populateTableview(){
        tableColumn_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        tableColumn_bodyType.setCellValueFactory(new PropertyValueFactory<>("body_type"));
        tableColumn_hp.setCellValueFactory(new PropertyValueFactory<>("hp"));
        tableColumn_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableColumn_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        table_cars.setItems(list);
    }

    public void Filesaver(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(Main.window);//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            //Save
            System.out.println("Процесс открытия файла");
        }
    }
}
