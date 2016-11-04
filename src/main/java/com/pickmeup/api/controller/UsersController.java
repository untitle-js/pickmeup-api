package com.pickmeup.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickmeup.api.dao.UserDao;
import com.pickmeup.api.model.Users;

import java.util.List;

/**
 * Created by Renz on 11/2/16.
 */
@RestController
@RequestMapping("/users" )
public class UsersController {

    @RequestMapping("/register")
    public Users  register(){
    	UserDao dao = new UserDao();    
    	return dao.registerUser();
    }
}
