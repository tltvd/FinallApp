package sample.home.garage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Page_garage_controller {


    @FXML
    private Button btn_back;

    @FXML
    private Button btn_save;

    @FXML
    private TableView<Car> table_cars;

    @FXML
    private TableColumn<Car, String> tableColumn_brand;

    @FXML
    private TableColumn<Car, String> tableColumn_model;

    @FXML
    private TableColumn<Car, String> tableColumn_probeg;
    private Connection con;
    DatabaseHandler db;

    ObservableList<Car> list;



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
        db=new DatabaseHandler();
        populateTableview();
    }

    private void populateTableview(){
        try {
            list= FXCollections.observableArrayList();
            ResultSet rs=db.getCars();
            while (rs.next()) {
                Car car = new Car();
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                list.add(car);
            }


            tableColumn_model.setCellValueFactory(new PropertyValueFactory<>("model"));
            tableColumn_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));




            table_cars.setItems(list);


        }catch (SQLException e){
            e.printStackTrace();
        }

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
