package sample.home.catalog;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sample.models.PackageData;
import sample.models.Car;
import sample.Main;

public class Page_catalog_controller {



    @FXML
    private Button btn_back;

    @FXML
    private ImageView image_sClass;

    @FXML
    private Button btn_s;

    @FXML
    private ImageView image_eClass;

    @FXML
    private Button btn_e;

    @FXML
    private ImageView image_aClass;

    @FXML
    private Button btn_a;

    @FXML
    private ImageView image_gClass;

    @FXML
    private Button btn_g;

    @FXML
    private ImageView image_gtClass;

    @FXML
    private Button btn_gt;

    @FXML
    private ImageView image_cClass;

    @FXML
    private Button btn_c;

    @FXML
    private ImageView image_clsClass;

    @FXML
    private Button btn_cls;

    @FXML
    private ImageView image_glbClass;

    @FXML
    private Button btn_glb;

    @FXML
    private ImageView image_gleClass;

    @FXML
    private Button btn_gle;

    @FXML
    private ImageView image_glsMaybachClass;

    @FXML
    private Button btn_gls;

    @FXML
    private ImageView image_sMaybachClass;

    @FXML
    private Button btn_maybach;




    @FXML
    void initialize() {
        Car car=new Car();
        btn_back.setOnAction(event -> {
            try {
                Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/Page_home.fxml"));
                Main.setscene(root1);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

         btn_s.setOnAction(event ->{
             try {
                 car.setModel("s 63 amg");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_sClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);


             } catch (IOException e) {
                 e.printStackTrace();
             }
         });

         btn_e.setOnAction(event ->{
             try {
                 car.setModel("e 63 amg");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_eClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_a.setOnAction(event ->{
             try {
                 car.setModel("a 35 amg");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_aClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_g.setOnAction(event ->{
             try {
                 car.setModel("g 63 amg");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_gClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_gt.setOnAction(event ->{
             try {
                 car.setModel("AMG GT Coupe");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_gtClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_c.setOnAction(event ->{
             try {
                 car.setModel("C 43 AMG");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Page_car_controller.picture=image_cClass.getImage();
                 Main.connect(pd);
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_cls.setOnAction(event ->{
             try {
                 car.setModel("CLS 350 D");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_clsClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);


             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_glb.setOnAction(event ->{
             try {
                 car.setModel("GLB 250");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_glbClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_gle.setOnAction(event ->{
             try {
                 car.setModel("GLE 450");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_gleClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });


         btn_gls.setOnAction(event ->{
             try {
                 car.setModel("Maybach GLS 600");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_glsMaybachClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });
         btn_maybach.setOnAction(event -> {
             try {
                 car.setModel("Maybach S 650");
                 PackageData pd=new PackageData("SHOW_CAR",car);
                 Main.connect(pd);
                 Page_car_controller.picture=image_sMaybachClass.getImage();
                 Parent root1 = FXMLLoader.load(getClass().getResource("/sample/home/catalog/Page_car.fxml"));
                 Main.setscene(root1);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         });

    }

}