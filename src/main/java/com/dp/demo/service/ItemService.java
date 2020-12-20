package com.dp.demo.service;

import com.dp.demo.dao.ItemDao;
import com.dp.demo.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {


    private final ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao)
    {
        this.itemDao = itemDao;
    }

    public Optional<Item> returnItemById(int id)
    {
        return itemDao.findById(id);
    }

    public void addItem(Item item)
    {
        itemDao.save(item);
    }

    public void removeItem(int id)
    {
        itemDao.deleteById(id);
    }
}
