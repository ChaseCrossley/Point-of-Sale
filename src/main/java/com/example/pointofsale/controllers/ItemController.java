package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.ItemDao;
import com.example.pointofsale.entities.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/item")
public class ItemController extends BaseController<Item, ItemDao> {
}
