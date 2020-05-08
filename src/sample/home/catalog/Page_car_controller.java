package sample.home.catalog;
import java.io.*;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.models.PackageData;
import sample.models.Car;
import sample.Main;
import sample.start.StartPage_Controller;

public class Page_car_controller {
    public static Car car_catalog;
    public static Image picture;

    @FXML
    private Button btn_back;

    @FXML
    private ImageView model_image_1;

    @FXML
    private Label model;

    @FXML
    private Label price;

    @FXML
    private Button btn_buy;

    @FXML
    private Label volume;

    @FXML
    private Label drive_type;

    @FXML
    private Label fuel_type;

    @FXML
    private Label hp;

    @FXML
    private Label time;

    @FXML
    private Label fuel;

    @FXML
    private Label body_type;




    @FXML
    void initialize() throws SQLException, IOException {
        btn_back.setOnAction(actionEvent -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_catalog.fxml"));
                Main.setscene(root1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        model.setText(car_catalog.getModel());
        price.setText("$ "+ car_catalog.getPrice());
        volume.setText(car_catalog.getVolume());
        drive_type.setText(car_catalog.getDrive_type());
        fuel_type.setText(car_catalog.getFuel_type());
        hp.setText(""+car_catalog.getHp());
        time.setText(car_catalog.getTime());
        fuel.setText(car_catalog.getFuel());
        body_type.setText(car_catalog.getBody_type());

        model_image_1.setImage(picture);



        Rectangle clip = new Rectangle(
                model_image_1.getFitWidth(), model_image_1.getFitHeight()
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        model_image_1.setClip(clip);
        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = model_image_1.snapshot(parameters, null);
        // remove the rounding clip so that our effect can show through.
        model_image_1.setClip(null);
        // apply a shadow effect.
        model_image_1.setEffect(new DropShadow(80, Color.LIGHTGREY));
        // store the rounded image in the imageView.
        model_image_1.setImage(image);


        btn_buy.setOnAction(actionEvent -> {
            PackageData pd=new PackageData("BUY", StartPage_Controller.user , car_catalog);
            Main.connect(pd);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Car buying");
            alert.setHeaderText("Order has been");
            alert.showAndWait();
        });
    }
}


