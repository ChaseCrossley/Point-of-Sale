package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.entities.User;

public class UserDeserializer extends BaseDeserializer<User> {

    public UserDeserializer(Class<User> userClass) {
        super(userClass);
    }

    @Override
    protected User deserializeHelper(User user) {
        return user;
    }

}
