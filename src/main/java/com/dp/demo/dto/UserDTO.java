package com.dp.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDTO {

    private int userId;
    private String userName;
    private String userPass;
    @Autowired
    private ShoppingList shoppingList;

    public UserDTO()
    {
    }

    public UserDTO(int userId, @JsonProperty("userName") String userName, @JsonProperty("userPass") String userPass, ShoppingList shoppingList)
    {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.shoppingList = shoppingList;
    }

    @JsonCreator
    public UserDTO(@JsonProperty(value="userName")String userName, @JsonProperty(value="userPass") String userPass)
    {
        this.userName = userName;
        this.userPass = userPass;
    }

    public UserDTO(int userId, String userName, String userPass)
    {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setUserPass(String userPass)
    {
        this.userPass = userPass;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getUserPass()
    {
        return userPass;
    }

    public ShoppingList getShoppingList()
    {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList)
    {
        this.shoppingList = shoppingList;
    }
}
