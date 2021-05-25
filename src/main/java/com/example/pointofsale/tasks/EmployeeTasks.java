package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeTasks extends BaseTasks<Employee> {
    @Autowired
    UserDao userDao;

    public EmployeeTasks() {
        super("employee", Employee.class);
    }

    @Override
    public Employee getNewEntity() {
        Employee employee = new Employee();
        employee.setUser(new UserTasks().getNewEntity());

        return employee;
    }
}
