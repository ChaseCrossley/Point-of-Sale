package com.example.pointofsale.daos;

import com.example.pointofsale.entities.AddInIngredient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AddInIngredientDao extends BaseDao<AddInIngredient> {
    public AddInIngredientDao() {
        super(AddInIngredient.class);
    }
}