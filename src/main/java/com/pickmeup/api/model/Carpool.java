package com.pickmeup.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * Created by Renz on 3/4/17.
 */
@Entity
@Table(name="carpool",schema ="public", catalog = "pickmeup")

public class Carpool implements java.io.Serializable{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public Timestamp getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Timestamp startingTime) {
        this.startingTime = startingTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="user_id")
    private int userId;

    @Column(name="starting_location")
    private String startingLocation;

    @Column(name="starting_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp startingTime;

    @Column(name="destination")
    private String destination;

}
