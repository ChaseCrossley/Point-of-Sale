package com.example.pointofsale.daos;

import com.example.pointofsale.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao extends BaseDao<User> {

    public UserDao() {
        super(User.class);
    }
}