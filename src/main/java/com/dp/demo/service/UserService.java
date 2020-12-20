package com.dp.demo.service;

import com.dp.demo.dao.UserDao;
import com.dp.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("mysqlUser") UserDao uDao)
    {
        this.userDao = uDao;
    }

    public void createUser(String userName, String userPass)
    {
        userDao.createUser(userName,userPass);
    }

    public void deleteUser(String userName, String userPass)
    {
        userDao.deleteUser(userDao.getUserByCredentials(userName, userPass).getUserId());
    }

    public UserDTO loginUser(String userName, String userPass)
    {
        return userDao.getUserByCredentials(userName, userPass);
    }

}
