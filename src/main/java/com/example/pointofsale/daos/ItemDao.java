package com.example.pointofsale.daos;

import com.example.pointofsale.entities.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ItemDao extends BaseDao<Item>{
    public ItemDao() {
        super(Item.class);
    }
}