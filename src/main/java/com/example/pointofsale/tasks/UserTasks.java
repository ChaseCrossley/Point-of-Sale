package com.example.pointofsale.tasks;

import com.example.pointofsale.entities.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;


@Component
public class UserTasks extends BaseTasks<User> {

    public UserTasks() {
        super("user", User.class);
    }

    @Override
    public User getNewEntity() {
        User user = new User();
        user.setPasswordHash(RandomStringUtils.randomAlphabetic(10));
        user.setUsername(RandomStringUtils.randomAlphabetic(10));
        user.setFirstName(RandomStringUtils.randomAlphabetic(10));
        user.setLastName(RandomStringUtils.randomAlphabetic(10));
        return user;
    }
}
