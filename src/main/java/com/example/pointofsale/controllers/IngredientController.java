package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.entities.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ingredient")
public class IngredientController extends BaseController<Ingredient, IngredientDao> {
}
