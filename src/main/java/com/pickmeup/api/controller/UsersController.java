package com.pickmeup.api.controller;

import com.pickmeup.api.dao.UserDao;
import com.pickmeup.api.model.Users;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Renz on 11/2/16.
 */
@RestController
@RequestMapping("/user" )
public class UsersController {
	
    @RequestMapping(value="/register" , method = RequestMethod.GET)
    public Users  register(@RequestParam Map<String,String> params)
    {
        UserDao dao = new UserDao();
        int userId = (int)(Math.random() * 1000);
        params.put("userId", String.valueOf(userId));
    	return dao.registerUser(params);
    }
    
    @RequestMapping(value="/login" , method = RequestMethod.GET)
    public Users  login(@RequestParam Map<String,String> allRequest)
    {
        UserDao dao = new UserDao();
    	return dao.registerUser(allRequest);
    }
}
