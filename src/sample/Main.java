package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.admin.orders.Page_admin_orders_controller;
import sample.admin.users.Page_admin_users_controller;
import sample.home.garage.Page_garage_controller;
import sample.home.orders.Page_orders_controller;
import sample.models.PackageData;
import sample.home.catalog.Page_car_controller;
import sample.signUp.Page_signUp_Controller;
import sample.start.StartPage_Controller;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Main extends Application {
    public static final int WIDTH=1000;
    public static final int HEIGHT=700;
    public static Stage window;


    public static void connect(PackageData pd){
        try{
            Socket socket=new Socket("localhost",8888);
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());


            if(pd.getOperationType().equals("SIGN_UP")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST_GARAGE")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();
                Page_garage_controller.orders= infoFromServer.getOrders();
            }
            else if(pd.getOperationType().equals("SHOW_CAR")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();
                Page_car_controller.car_catalog= infoFromServer.getCar();
            }
            else if(pd.getOperationType().equals("LIST_ORDER")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();
                Page_orders_controller.orders= infoFromServer.getOrders();
            }
            else if(pd.getOperationType().equals("SIGN_IN")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();
                StartPage_Controller.user= infoFromServer.getUser();
            }
            else if(pd.getOperationType().equals("UPDATE")){
                outputStream.writeObject(pd);
                StartPage_Controller.user.setPassword(pd.getUser().getPassword());
            }
            else if(pd.getOperationType().equals("BUY")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST_ORDER_ADMIN")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();
                Page_admin_orders_controller.orders= infoFromServer.getOrders();
            }
            else if(pd.getOperationType().equals("CHANGE_STATUS")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("DELETE_ORDER")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST_USERS_ADMIN")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();
                Page_admin_users_controller.users= infoFromServer.getUsersArray();
            }
            else if(pd.getOperationType().equals("DELETE_USER")){
                outputStream.writeObject(pd);
            }




            else if(pd.getOperationType().equals("USERNAME_CHECK")){
                outputStream.writeObject(pd);
                PackageData infoFromServer=(PackageData)inputStream.readObject();

                if(infoFromServer.getUser().getUsername().equals("isempty")){
                    Page_signUp_Controller.checkUsername=true;
                }
                else {
                    Page_signUp_Controller.checkUsername=false;
                }
            }




            inputStream.close();
            outputStream.close();
            socket.close();


        }catch (Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Problem connecting to the server!");
            alert.showAndWait();
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("start/Page_start.fxml"));
        window.setTitle("Germany Motors");
        InputStream iconStream = getClass().getResourceAsStream("content/mercedes-benz.png");
        Image image = new Image(iconStream);
        window.getIcons().add(image);

        window.setScene(new Scene(root, WIDTH, HEIGHT));
        window.initStyle(StageStyle.DECORATED);

        window.setResizable(false);
        window.show();

    }

    public static void setscene(Parent root){
        window.setScene(new Scene(root, WIDTH, HEIGHT));

    }

    public static void main(String[] args) {
        System.out.println("START");
        launch(args);

    }
}
