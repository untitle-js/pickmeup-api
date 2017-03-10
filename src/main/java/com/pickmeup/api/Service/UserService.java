package com.pickmeup.api.Service;

import com.pickmeup.api.dao.UserDao;
import com.pickmeup.api.model.Users;

import java.util.Map;
import java.util.List;
/**
 * Created by Govind on 12/22/2016.
 */
public class UserService
{
    public Users validateUser( Map<String, String> allRequest)
    {
        UserDao dao = new UserDao();
        Users user = dao.validateUser(allRequest);
        return user;
    }

    public Users register(Users user)
    {
        UserDao dao = new UserDao();
        Users registeredUser = dao.register(user);
        return registeredUser;
    }
}
