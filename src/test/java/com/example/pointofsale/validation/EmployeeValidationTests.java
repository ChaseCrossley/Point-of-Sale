package com.example.pointofsale.validation;

import com.example.pointofsale.daos.EmployeeDao;
import com.example.pointofsale.entities.Employee;
import com.example.pointofsale.entities.User;
import com.example.pointofsale.tasks.EmployeeTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class EmployeeValidationTests {

    @Autowired
    EmployeeTasks employeeTasks;

    @Autowired
    EmployeeDao employeeDao;

    Employee employee;

    @BeforeEach
    public void creatEmployee() {
        employee = employeeTasks.getNewEntity();
    }

    /* @NotNull */
    @Test
    public void testUserValidation() {
        //given
        Employee employee = this.employee;

        //when id is not null so item not in DB
        employee.setUser(new User());

        //then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> employeeDao.create(employee));

        //when
        employee.setUser(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> employeeDao.create(employee));

    }

}
