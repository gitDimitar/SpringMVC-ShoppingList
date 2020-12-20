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

    public int solution(int[] A)
    {
        int ret = 0;
        Arrays.sort(A);
        String s = "asdassd";
        s.lastIndexOf(s.charAt(ret));
        Arrays.stream(A).sorted().filter(a -> {
            int res = 1;
            if(a == res)
            {
                res = a+1;
            }
            else if(a < res)
            {

            }
            else
            {
                return res;
            }

            return res;
        }).findFirst();

        return ret;
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
