package com.example.pointofsale.daos;

import com.example.pointofsale.entities.Serving;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServingDao extends BaseDao<Serving> {

    public ServingDao() {
        super(Serving.class);
    }
}