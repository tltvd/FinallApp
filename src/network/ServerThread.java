package network;

import sample.models.Car;
import sample.DataBase.Const;
import sample.DataBase.DatabaseHandler;
import sample.models.Order;
import sample.models.PackageData;
import sample.models.User;
import sample.start.StartPage_Controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }


    public void run (){
        try {
            DatabaseHandler db=new DatabaseHandler();
            db.getDbConnection();
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            PackageData pd=null;
            System.out.println("USER CONNECTED");
            while ((pd = (PackageData) inputStream.readObject())!= null){
                if(pd.getOperationType().equals("SIGN_UP")){
                    User userFromClient=pd.getUser();
                    db.addUser(userFromClient);
                    System.out.println("----------A NEW USER WAS REGISTERED----------");
                }
                else if(pd.getOperationType().equals("UPDATE")){
                    User userFromClient=pd.getUser();
                    db.updatePassword(userFromClient);
                }
                else if(pd.getOperationType().equals("SHOW_CAR")){
                    Car car=new Car();
                    ResultSet infoClient=db.returnCar(pd.getCar());
                    while(infoClient.next()){
                        car.setModel(infoClient.getString(Const.CARS_MODEL));
                        car.setBrand(infoClient.getString(Const.CARS_BRAND));
                        car.setBody_type(infoClient.getString(Const.CARS_BODY_TYPE));
                        car.setDrive_type(infoClient.getString(Const.CARS_DRIVE_TYPE));
                        car.setFuel(infoClient.getString(Const.CARS_FUEL));
                        car.setFuel_type(infoClient.getString(Const.CARS_FUEL_TYPE));
                        car.setPrice(infoClient.getInt(Const.CARS_PRICE));
                        car.setHp(infoClient.getInt(Const.CARS_HP));
                        car.setId_car(infoClient.getString(Const.CARS_ID));
                        car.setYear(infoClient.getInt(Const.CARS_YEAR));
                        car.setTime(infoClient.getString(Const.CARS_TIME));
                        car.setVolume(infoClient.getString(Const.CARS_VOLUME));
                    }
                    PackageData data=new PackageData(car);
                    outputStream.writeObject(data);
                }
                else if(pd.getOperationType().equals("SIGN_IN")){
                    User user=new User();
                    ResultSet infoClient=db.getUser(pd.getUser());
                    while(infoClient.next()){
                        user.setUsername(infoClient.getString(Const.USERS_USERNAME));
                        user.setPassword(infoClient.getString(Const.USERS_PASSWORD));
                        user.setRole(infoClient.getString(Const.USERS_ROLE));
                        user.setCity(infoClient.getString(Const.USERS_CITY));
                        user.setEmail(infoClient.getString(Const.USERS_EMAIL));
                        user.setFirstname(infoClient.getString(Const.USERS_FIRSTNAME));
                        user.setLastname(infoClient.getString(Const.USERS_LASTNAME));
                        user.setId_user(infoClient.getString(Const.USERS_ID));
                        user.setPhone(infoClient.getString(Const.USERS_PHONE));
                    }
                    PackageData data=new PackageData(user);
                    outputStream.writeObject(data);
                    System.out.println("----------THE USER HAS LOGGED IN----------");
                }
                else if(pd.getOperationType().equals("BUY")){
                    User user=pd.getUser();
                    Car car=pd.getCar();
                    db.addOrder(user,car);
                }
                else if(pd.getOperationType().equals("LIST_ORDER")){
                    ArrayList<Order> orders=new ArrayList<>();
                    ResultSet infoClient=db.getOrders(pd.getUser());
                    while(infoClient.next()){
                        Order order=new Order();
                        order.setId_user(infoClient.getString(Const.CARS_MODEL));
                        order.setDate(infoClient.getString(Const.ORDERS_DATE));
                        order.setId_car(infoClient.getString(Const.ORDERS_ID_CAR));
                        order.setStatus(infoClient.getString(Const.ORDERS_STATUS));
                        Car car=new Car();
                        car.setModel(infoClient.getString(Const.CARS_MODEL));
                        car.setBrand(infoClient.getString(Const.CARS_BRAND));
                        car.setBody_type(infoClient.getString(Const.CARS_BODY_TYPE));
                        car.setDrive_type(infoClient.getString(Const.CARS_DRIVE_TYPE));
                        car.setFuel(infoClient.getString(Const.CARS_FUEL));
                        car.setFuel_type(infoClient.getString(Const.CARS_FUEL_TYPE));
                        car.setPrice(infoClient.getInt(Const.CARS_PRICE));
                        car.setHp(infoClient.getInt(Const.CARS_HP));
                        car.setId_car(infoClient.getString(Const.CARS_ID));
                        car.setYear(infoClient.getInt(Const.CARS_YEAR));
                        car.setTime(infoClient.getString(Const.CARS_TIME));
                        car.setVolume(infoClient.getString(Const.CARS_VOLUME));
                        order.setCar(car);
                        orders.add(order);
                    }
                    /*
                                        while(infoClient.next()){
                        order.setId_user(infoClient.getString(Const.CARS_MODEL));
                        order.setDate(infoClient.getString(Const.ORDERS_DATE));
                        order.setId_car(infoClient.getString(Const.ORDERS_ID_CAR));
                        order.setStatus(infoClient.getString(Const.ORDERS_STATUS));
                        Car car=new Car();
                        car.setModel(infoClient.getString(Const.CARS_MODEL));
                        car.setBrand(infoClient.getString(Const.CARS_BRAND));
                        car.setBody_type(infoClient.getString(Const.CARS_BODY_TYPE));
                        car.setDrive_type(infoClient.getString(Const.CARS_DRIVE_TYPE));
                        car.setFuel(infoClient.getString(Const.CARS_FUEL));
                        car.setFuel_type(infoClient.getString(Const.CARS_FUEL_TYPE));
                        car.setPrice(infoClient.getInt(Const.CARS_PRICE));
                        car.setHp(infoClient.getInt(Const.CARS_HP));
                        car.setId_car(infoClient.getString(Const.CARS_ID));
                        car.setYear(infoClient.getInt(Const.CARS_YEAR));
                        car.setTime(infoClient.getString(Const.CARS_TIME));
                        car.setVolume(infoClient.getString(Const.CARS_VOLUME));
                        order.setCar(car);
                        orders.add(order);
                    }
                     */


                    PackageData data=new PackageData(orders);
                    outputStream.writeObject(data);
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
