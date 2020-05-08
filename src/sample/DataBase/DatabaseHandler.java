package sample.DataBase;

import sample.models.Car;
import sample.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

public class DatabaseHandler extends Configs {
    Connection dbConnection;


    public Connection getDbConnection()throws SQLException,ClassNotFoundException{
        String connectionString= "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }


    public void updatePassword(User user){

        try {
            String update="UPDATE users SET password ="+user.getPassword()+" WHERE users.id_user = "+user.getId_user();
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.executeUpdate();
            prSt.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void addOrder(User user, Car car){
        //String insert= "INSERT INTO "+Const.ORDERS_TABLE+"("+Const.ORDERS_ID_ORDER+","+Const.ORDERS_ID_USER+","+Const.ORDERS_ID_CAR+","+Const.ORDERS_STATUS+") VALUES(?,?,?,?)";
        String insert= "INSERT INTO "+Const.ORDERS_TABLE+"("+Const.ORDERS_ID_USER+","+Const.ORDERS_ID_CAR+","+Const.ORDERS_STATUS+","+Const.ORDERS_DATE+") VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            String s="created";
            Date date=new Date();
            String str=new String();
            str+=date;
            prSt.setString(1, user.getId_user());
            prSt.setString(2, car.getId_car());
            prSt.setString(3, s);
            prSt.setString(4, str);
            prSt.executeUpdate();
            prSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void addUser(User user){
        String insert= "INSERT INTO "+Const.USER_TABLE+"("+Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+","+Const.USERS_USERNAME+","+
                Const.USERS_PASSWORD+","+Const.USERS_CITY+","+Const.USERS_EMAIL+","+Const.USERS_GENDER+","+ Const.USERS_PHONE+","+ Const.USERS_ROLE+")"+"VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstname());
            prSt.setString(2, user.getLastname());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getCity());
            prSt.setString(6, user.getEmail());
            prSt.setString(7, user.getGender());
            prSt.setString(8, user.getPhone());
            prSt.setString(9, user.getRole());

            prSt.executeUpdate();
            prSt.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public ResultSet getOrders(User user){
        ResultSet resSet=null;
        String select="SELECT * FROM orders JOIN users ON orders.id_user=users.id_user JOIN cars ON orders.id_car=cars.id_car WHERE orders.id_user ="+user.getId_user();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet=prSt.executeQuery();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getUser(User user){
        ResultSet resSet=null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());


            resSet=prSt.executeQuery();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet returnCar(Car car){
        ResultSet resSet=null;
        String select = "SELECT * FROM cars WHERE model"+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, car.getModel());
            resSet=prSt.executeQuery();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getCars(){
        ResultSet resSet=null;


        String select = "SELECT * FROM cars";
        //String select = "SELECT * FROM cars WHERE owner="+"0";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);


            resSet=prSt.executeQuery();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }





}
