package sample.models;
import java.io.Serializable;
import java.util.ArrayList;


public class PackageData implements Serializable {
    private String operationType;
    private User user;
    private Car car;
    private ArrayList<Car> carsArray;
    private ArrayList<Order> ordersArray;
    private ArrayList<User> usersArray;
    private ArrayList<Order> orders;

    public PackageData(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public PackageData(String operationType, User user, Car car) {
        this.operationType = operationType;
        this.user = user;
        this.car = car;
    }
    public PackageData(User user) {
        this.user = user;
    }
    public PackageData(Car car) {
        this.car = car;
    }
    public PackageData(String operationType, User user) {
        this.operationType = operationType;
        this.user = user;
    }
    public PackageData(String operationType, Car car) {
        this.operationType = operationType;
        this.car = car;
    }
    public PackageData(String operationType) {  //get information about car or user
        this.operationType = operationType;
    }


    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


}
