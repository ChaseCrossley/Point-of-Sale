package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.AddInIngredientDao;
import com.example.pointofsale.entities.AddInIngredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/addInIngredient")
public class AddInIngredientController extends BaseController<AddInIngredient, AddInIngredientDao> {
}