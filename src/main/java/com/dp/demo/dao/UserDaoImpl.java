package com.dp.demo.dao;

import com.dp.demo.dto.ShoppingList;
import com.dp.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Optional;

@Repository("mysqlUser")
public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_CREATE = "INSERT INTO userInfo(userName,userPass) VALUES(?,?);";
    private static final String SQL_GET_USER = "SELECT * FROM userInfo WHERE userName = ? AND userPass = ?;";
    private static final String SQL_DELETE_USER = "DELETE * FROM userInfo where userId = ?";
    @Override
    public void createUser(String userName, String userPass)
    {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setString(1,userName);
            ps.setString(2,userPass);
            return ps;
        });
    }

    @Override
    public UserDTO getUserByCredentials(String userName, String userPass)
    {
        return jdbcTemplate.queryForObject(SQL_GET_USER,
                ((rs, rowNum) -> new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3))),
                new Object[] {userName,userPass});
    }

    @Override
    public void deleteUser(int userId)
    {
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(SQL_DELETE_USER);
            ps.setInt(1, userId);
            return ps;
        });
    }
}
