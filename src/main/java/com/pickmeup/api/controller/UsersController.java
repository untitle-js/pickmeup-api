package com.pickmeup.api.controller;

import com.pickmeup.api.dao.UserDao;
import com.pickmeup.api.model.Users;
import org.springframework.web.bind.annotation.*;
import com.pickmeup.api.Service.UserService;
import java.util.Map;
/**
 * Created by Renz on 11/2/16.
 */
@RestController
@RequestMapping("/user" )
public class UsersController {

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public Users register(@RequestParam Map<String, String> params) {
//        UserDao dao = new UserDao();
//        int userId = (int) (Math.random() * 1000);
//        params.put("userId", String.valueOf(userId));
//        return dao.registerUser(params);
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Users register(@RequestBody  Users user) {
        UserDao dao = new UserDao();
        return dao.register(user);
    }

    @RequestMapping(value="/login" , method = RequestMethod.GET)
    public Users  login(@RequestParam Map<String,String> params)
    {
        UserService service = new UserService();
        Users flagUser= service.validateUser(params);
        return flagUser;
    }

    @RequestMapping(value="/loginstatus" , method = RequestMethod.GET)
    public Users  loginStatus(@RequestParam Map<String,String> params)
    {
        UserService service = new UserService();
        Users flagUser= service.validateUser(params);
        return flagUser;
    }
}
