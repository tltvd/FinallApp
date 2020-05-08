package sample.models;

import java.io.Serializable;

public class Order implements Serializable {
    private String order_id;
    private String id_user;
    private String id_car;
    private String status;
    private String date;
    private Car car;
    private User user;

/*
SELECT
users.username AS "USERNAME",
cars.model AS "MoDEL"
FROM orders
JOIN users ON orders.id_user=users.id_user
JOIN cars ON orders.id_car=cars.id_car
WHERE books.author='Dan Brown';
 */




    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_car() {
        return id_car;
    }

    public void setId_car(String id_car) {
        this.id_car = id_car;
    }
}
