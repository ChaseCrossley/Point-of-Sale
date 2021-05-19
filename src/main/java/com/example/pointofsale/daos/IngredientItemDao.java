package com.example.pointofsale.daos;

import com.example.pointofsale.entities.IngredientItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IngredientItemDao extends BaseDao<IngredientItem> {

    public IngredientItemDao() {
        super(IngredientItem.class);
    }
}