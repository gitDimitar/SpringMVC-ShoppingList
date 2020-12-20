package com.dp.demo.dao;

import com.dp.demo.dto.Item;
import com.dp.demo.dto.ShoppingList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository("mysqlShoppingList")
public class ShoppingListDaoImpl implements ShoppingListDao {

    JdbcTemplate jdbcTemplate;

    private final String SQL_CREATE_SHOPPING_LIST = "INSERT INTO userShoppingListInfo(userID, listName) VALUES (?,?);";
    private final String SQL_ADD_ITEM_TO_SHOPPING_LIST = "INSERT INTO shoppingListItemMatch(listID,itemID) VALUES (?,?);";
    private final String SQL_REMOVE_ITEM_FROM_SHOPPING_LIST = "DELETE * FROM shoppingListItemMatch WHERE itemID = ? AND listID = ?";
    private final String SQL_GET_ALL_SHOPPING_LISTS_FOR_USER = "SELECT listID, listName FROM userShoppingListInfo WHERE userID = ?;";
    private final String SQL_GET_SHOPPING_LIST_ITEMS = "SELECT itemid, item_name, item_quantity FROM shopping_list_item " +
                                                        "INNER JOIN shoppingListItemMatch " +
                                                        "ON shoppingListItemMatch.itemID = shopping_list_item.itemid" +
                                                        "WHERE shoppingListItemMatch.listID = ?;";

    public ShoppingListDaoImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createShoppingList(int userId, String listName)
    {
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(SQL_CREATE_SHOPPING_LIST);
            ps.setInt(1,userId);
            ps.setString(2,listName);
            return ps;
        });

    }

    @Override
    public void addItemToShoppingList(int listId, int itemId)
    {
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(SQL_ADD_ITEM_TO_SHOPPING_LIST);
            ps.setInt(1, listId);
            ps.setInt(2,itemId);
            return ps;
        });
    }

    @Override
    public void removeItemFromShoppingList(int listId, int itemId)
    {
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(SQL_REMOVE_ITEM_FROM_SHOPPING_LIST);
            ps.setInt(1,itemId);
            ps.setInt(2,listId);
            return ps;
        });
    }

    @Override
    public List<ShoppingList> getAllShoppingLists(int userId)
    {
        return jdbcTemplate.query(SQL_GET_ALL_SHOPPING_LISTS_FOR_USER,
                (rs, rowNum) -> {
                return new ShoppingList(rs.getInt("listID"),rs.getString("listName"));
        }, new Object[]{userId});
    }

    @Override
    public List<Item> getShoppingListItems(int listId)
    {
        return jdbcTemplate.query(SQL_GET_SHOPPING_LIST_ITEMS,
                (rs, rowNum) -> {
                return new Item(rs.getInt("itemID"), rs.getString("itemName"),rs.getInt("itemQuantity"));
        }, new Object[]{listId});
    }
}
