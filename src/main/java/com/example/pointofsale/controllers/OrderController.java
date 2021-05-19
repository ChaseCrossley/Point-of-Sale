package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.OrderDao;
import com.example.pointofsale.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController<Order, OrderDao> {
}
