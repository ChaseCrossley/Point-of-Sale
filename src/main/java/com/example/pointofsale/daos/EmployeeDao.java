package com.example.pointofsale.daos;

import com.example.pointofsale.entities.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDao extends BaseDao<Employee>{
    public EmployeeDao() {
        super(Employee.class);
    }
}