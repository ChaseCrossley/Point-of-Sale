package com.example.pointofsale.validation;

import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.User;
import com.example.pointofsale.tasks.UserTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class UserValidationTests {

    @Autowired
    UserTasks userTasks;

    @Autowired
    UserDao userDao;

    User user;

    @BeforeEach
    public void creatUser() {
        user = userTasks.getNewEntity();
    }

    /* @Size(min = 10) */
    @Test
    public void testSaltValidation() {
        //given
        User user = this.user;

        //when
        user.setSalt("abcd");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> userDao.create(user));
    }

    /* @Size(min = 5) */
    @Test
    public void testUsernameValidation() {
        //given
        User user = this.user;

        //when
        user.setUsername("abcd");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> userDao.create(user));
    }

    /* @NotBlank */
    @Test
    public void testPasswordHashValidation() {
        //given
        User user = new User();

        //when
        //No Password Set

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> userDao.create(user));
    }


    /* @NotBlank */
    @Test
    public void testFirstNameValidation() {
        //given
        User user = new User();

        //when
        user.setFirstName("");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> userDao.create(user));
    }

    /* @NotBlank */
    @Test
    public void testLastNameValidation() {
        //given
        User user = new User();

        //when
        user.setLastName("");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> userDao.create(user));
    }
}
