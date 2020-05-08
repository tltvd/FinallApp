package sample.models;

import java.io.Serializable;
import java.sql.Blob;

public class Car implements Serializable {
    private String id_car;
    private String brand;
    private String model;
    private String body_type;
    private int year;
    private String drive_type;
    private int hp;
    private String fuel_type;
    private String fuel;
    private String time;
    private int price;
    private String volume;
    private Blob image;

    public Car() {}
    public Car(String id_car, String brand, String model, String body_type, int year, String drive_type, int hp, String fuel_type, String fuel, String time, int price, String volume, Blob image) {
        this.id_car = id_car;
        this.brand = brand;
        this.model = model;
        this.body_type = body_type;
        this.year = year;
        this.drive_type = drive_type;
        this.hp = hp;
        this.fuel_type = fuel_type;
        this.fuel = fuel;
        this.time = time;
        this.price = price;
        this.volume = volume;
        this.image=image;
    }


    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getId_car() {
        return id_car;
    }

    public void setId_car(String id_car) {
        this.id_car = id_car;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDrive_type() {
        return drive_type;
    }

    public void setDrive_type(String drive_type) {
        this.drive_type = drive_type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
