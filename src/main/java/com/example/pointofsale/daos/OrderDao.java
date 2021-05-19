package com.example.pointofsale.daos;

import com.example.pointofsale.entities.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDao extends BaseDao<Order>{
    public OrderDao() {
        super(Order.class);
    }
}