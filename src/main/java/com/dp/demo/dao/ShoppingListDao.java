package com.dp.demo.dao;

import com.dp.demo.dto.Item;
import com.dp.demo.dto.ShoppingList;

import java.util.List;

public interface ShoppingListDao {

    public void createShoppingList(int userId, String listName);

    public void addItemToShoppingList(int listId, int itemId);

    public void removeItemFromShoppingList(int listId, int itemId);

    public List<ShoppingList> getAllShoppingLists(int userId);

    public List<Item> getShoppingListItems(int listId);

}
