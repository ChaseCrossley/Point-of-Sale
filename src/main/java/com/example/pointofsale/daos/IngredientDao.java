package com.example.pointofsale.daos;

import com.example.pointofsale.entities.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IngredientDao extends BaseDao<Ingredient>{
    public IngredientDao() {
        super(Ingredient.class);
    }
}