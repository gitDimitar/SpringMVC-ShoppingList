package com.dp.demo.dao;

import com.dp.demo.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item,Integer> {


}
