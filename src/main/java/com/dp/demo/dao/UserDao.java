package com.dp.demo.dao;

import com.dp.demo.dto.UserDTO;


public interface UserDao {

    public void createUser(String userName, String userPass);

    public UserDTO getUserByCredentials(String userName, String userPass);

    public void deleteUser(int userId);
}
