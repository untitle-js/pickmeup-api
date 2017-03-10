package com.pickmeup.api.model;
import javax.persistence.*;

/**
 * Created by selva on 3/6/2017.
 */

@Entity
public class CarpoolUsersDetails implements java.io.Serializable{

    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;
    private boolean isDriver;

    public CarpoolUsersDetails(String firstName, String lastName, String phoneNum, String email, boolean isDriver)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.isDriver = isDriver;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }



}
