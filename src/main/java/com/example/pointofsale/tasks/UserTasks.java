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
    User getNewEntity() {
        return new User(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10));
    }
}
