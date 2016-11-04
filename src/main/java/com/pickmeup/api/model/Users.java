package com.pickmeup.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Renz on 11/2/16.
 */

@Entity
@Table(name="users",schema ="public", catalog = "pickmeup")
public class Users implements java.io.Serializable {

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

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    
    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_dame")
    private String lastName;

    @Column(name = "phone_number")
    private int phoneNum;

    @Column(name="email")
    private String email;

    @Column (name="address")
    private String address;

    @Id
    @Column(name="user_id",nullable = false)
    private int userId;

    @Column(name="user_password")
    private String pwd;
    
    @Column(name="date_of_birth")
    private Date dateOfBirth;

    public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Users() {
    }
}
