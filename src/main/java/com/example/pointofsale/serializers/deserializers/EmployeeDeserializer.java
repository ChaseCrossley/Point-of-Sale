package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class EmployeeDeserializer extends BaseDeserializer<Employee> {

    @Autowired
    UserDao userDao;

    public EmployeeDeserializer() {
        super();
    }

    public EmployeeDeserializer(Class<Employee> employeeClass) {
        super(employeeClass);
    }

    @Override
    protected Employee deserializeHelper(Employee employee) {
        employee.setUser(userDao.getById(employee.getUser().getId()));
        return employee;
    }

}
