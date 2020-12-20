package com.dp.demo.service;

import com.dp.demo.dao.ShoppingListDao;
import com.dp.demo.dto.Item;
import com.dp.demo.dto.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    private final ShoppingListDao shoppingListDao;

    @Autowired
    public ShoppingListService(@Qualifier("mysqlShoppingList") ShoppingListDao shoppingListDao)
    {
        this.shoppingListDao = shoppingListDao;
    }

    public void createShoppingList(int userId, String listName)
    {
        shoppingListDao.createShoppingList(userId,listName);
    }

    public void addItemToShoppingList(int listId, int itemId)
    {
        shoppingListDao.addItemToShoppingList(listId, itemId);
    }

    public void removeItemFromShoppingList(int listId, int itemId)
    {
        shoppingListDao.removeItemFromShoppingList(listId, itemId);
    }

    public List<ShoppingList> getAllShoppingLists(int userId)
    {
        return shoppingListDao.getAllShoppingLists(userId);
    }

    public List<Item> getAllItemsForShoppingList(int listId)
    {
        return shoppingListDao.getShoppingListItems(listId);
    }

}
