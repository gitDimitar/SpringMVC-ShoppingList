package com.dp.demo.controller;

import com.dp.demo.dto.Item;
import com.dp.demo.dto.ShoppingList;
import com.dp.demo.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/list")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService)
    {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping("/createList")
    public void  createShoppingList(@RequestParam int userId, @RequestParam String listName)
    {
        shoppingListService.createShoppingList(userId, listName);
    }

    @PostMapping("/addItem")
    public void addItemToShoppingList(@RequestParam int listId, @RequestParam int itemId)
    {
        shoppingListService.addItemToShoppingList(listId, itemId);
    }

    @PostMapping("/removeItem")
    public void removeItemFromShoppingList(@RequestParam int listId, @RequestParam int itemId)
    {
        shoppingListService.removeItemFromShoppingList(listId, itemId);
    }

    @GetMapping("/getLists")
    public List<ShoppingList> getAllShoppingListsForUser(@RequestParam int userId)
    {
        return shoppingListService.getAllShoppingLists(userId);
    }

    @GetMapping("/getItems")
    public List<Item> getAllItemsForShoppingList(@RequestParam int listId)
    {
        return shoppingListService.getAllItemsForShoppingList(listId);
    }
}
