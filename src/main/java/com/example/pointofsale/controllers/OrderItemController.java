package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.OrderItemDao;
import com.example.pointofsale.entities.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/orderItem")
public class OrderItemController extends BaseController<OrderItem, OrderItemDao> {
}
