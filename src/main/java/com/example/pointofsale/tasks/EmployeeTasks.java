package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.Employee;
import com.example.pointofsale.entities.User;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeTasks extends BaseTasks<Employee> {
    @Autowired
    UserDao userDao;

    public EmployeeTasks() {
        super("employee", Employee.class);
    }

    @Override
    Employee getNewEntity() {
        final List<User> users = (List<User>) userDao.allObjects();
        User user = users.get(RandomUtils.nextInt(0, users.size() - 1));
        return new Employee(user);
    }
}
