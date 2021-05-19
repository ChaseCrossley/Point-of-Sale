package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController<User, UserDao> {
}