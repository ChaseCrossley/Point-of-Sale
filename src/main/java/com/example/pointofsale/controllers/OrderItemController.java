package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.IngredientItemDao;
import com.example.pointofsale.daos.OrderItemDao;
import com.example.pointofsale.entities.IngredientItem;
import com.example.pointofsale.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping(value = "/orderItem")
public class OrderItemController extends BaseController<OrderItem, OrderItemDao> {
    @Autowired
    IngredientItemDao ingredientItemDao;

    @RequestMapping(value = "/retrieveIngredientItems/{fkItemId}", method = RequestMethod.GET)
    public Collection<IngredientItem> retrieveIngredientItems(@PathVariable int fkItemId) {
        return ingredientItemDao.getByItemId(fkItemId);
    }
}
