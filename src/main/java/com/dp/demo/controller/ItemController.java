package com.dp.demo.controller;

import com.dp.demo.dto.Item;
import com.dp.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {


    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody Item item)
    {
        itemService.addItem(item);
    }

    @GetMapping("/getItem/{id}")
    public Item getItem(@PathVariable int id)
    {
       return itemService.returnItemById(id).get();
    }

    @DeleteMapping("/deleteMapping/{id}")
    public void removeItem(@PathVariable int id)
    {
        itemService.removeItem(id);
    }
}
