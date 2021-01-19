package com.dp.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "shoppingListItem")
public class Item {

    @Id
    @GeneratedValue
    private int itemID;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "itemQuantity")
    private int itemQuantity;

    public Item(int itemID, String itemName, int itemQuantity)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    public Item()
    {
    }

    public int getItemID()
    {
        return itemID;
    }

    public void setItemID(int itemID)
    {
        this.itemID = itemID;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public int getItemQuantity()
    {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity)
    {
        this.itemQuantity = itemQuantity;
    }
}
