package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.ServingDao;
import com.example.pointofsale.entities.Serving;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/serving")
public class ServingController extends BaseController<Serving, ServingDao> {
}
