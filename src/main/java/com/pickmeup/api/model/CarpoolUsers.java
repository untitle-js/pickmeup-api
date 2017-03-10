package com.pickmeup.api.model;
import javax.persistence.*;
/**
 * Created by selva on 3/6/2017.
 */

@Entity
@Table(name="carpool_users",schema ="public", catalog = "pickmeup")
public class CarpoolUsers implements java.io.Serializable{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarpoolId() {
        return carpoolId;
    }

    public void setCarpoolId(int carpoolId) {
        this.carpoolId = carpoolId;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="id")
    private int id;

    @Id
    @Column(name ="user_id")
    private int userId;

    @Id
    @Column(name ="carpool_id")
    private int carpoolId;

    @Column(name ="is_driver")
    private boolean isDriver;

}
