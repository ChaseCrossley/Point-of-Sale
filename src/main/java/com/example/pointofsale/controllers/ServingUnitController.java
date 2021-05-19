package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.ServingUnitDao;
import com.example.pointofsale.entities.ServingUnit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/servingUnit")
public class ServingUnitController extends BaseController<ServingUnit, ServingUnitDao> {
}
