package com.example.pointofsale.daos;

import com.example.pointofsale.entities.ServingUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServingUnitDao extends BaseDao<ServingUnit>{
    public ServingUnitDao() {
        super(ServingUnit.class);
    }
}