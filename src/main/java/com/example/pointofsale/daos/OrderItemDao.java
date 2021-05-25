package com.example.pointofsale.daos;

import com.example.pointofsale.entities.IngredientItem;
import com.example.pointofsale.entities.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository
@Transactional
public class OrderItemDao extends BaseDao<OrderItem> {
    public OrderItemDao() {
        super(OrderItem.class);
    }
}