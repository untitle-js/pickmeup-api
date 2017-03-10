package com.pickmeup.api.model;

import javax.persistence.*;


/**
 * Created by Govind on 12/22/2016.
 */
@Entity
@Table(name="cars",schema ="public", catalog = "pickmeup")
public class Cars implements java.io.Serializable {

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public int getCarID() {
        return carId;
    }

    public void setCarID(int carId) {this.carId = carId;}

    public int getUserId() { return userId;}

    public void setUserId(int userId) { this.userId = userId;}

    public String getColor() { return color;}

    public void setColor(String color) {this.color = color;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}


    @Column(name ="make")
    private String carMake;

    @Column(name ="occupancy")
    private int occupancy;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="car_id")
    private int carId;

    @Id
    @Column(name ="user_id")
    private int userId;


    @Column(name="color")
    private String color;

    @Column(name="model")
    private String model;
}