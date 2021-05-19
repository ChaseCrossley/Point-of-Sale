package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.EmployeeDao;
import com.example.pointofsale.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends BaseController<Employee, EmployeeDao> {
}
