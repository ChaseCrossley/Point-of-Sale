package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.IngredientItemDao;
import com.example.pointofsale.entities.IngredientItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ingredientItem")
public class IngredientItemController extends BaseController<IngredientItem, IngredientItemDao> {
}
