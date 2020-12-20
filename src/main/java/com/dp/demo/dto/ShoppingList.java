package com.dp.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


public class ShoppingList {


    private int id;
    private String listName;
    @Autowired
    private List<Item> itemList;

    public ShoppingList()
    {
    }

    public ShoppingList(int id, String listName)
    {
        this.id = id;
        this.listName = listName;
    }

    public ShoppingList(int id, String listName, List<Item> itemList)
    {
        this.id = id;
        this.listName = listName;
        this.itemList = itemList;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getListName()
    {
        return listName;
    }

    public void setListName(String listName)
    {
        this.listName = listName;
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    public void setItemList(List<Item> itemList)
    {
        this.itemList = itemList;
    }

    public void addItem(Item item)
    {
        this.itemList.add(item);
    }

    public void removeItem(Item item)
    {
        this.itemList.remove(item);
    }
}
