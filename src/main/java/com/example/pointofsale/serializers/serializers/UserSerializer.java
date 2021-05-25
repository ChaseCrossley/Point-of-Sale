package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.User;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class UserSerializer extends BaseSerializer<User> {
    public UserSerializer(Class<User> userClass) {
        super(userClass);
    }

    @Override
    protected void serializeHelper(User value, JsonGenerator jgen) throws IOException {
        jgen.writeStringField("username", value.getUsername() + "wack");
        jgen.writeStringField("firstName", value.getFirstName());
        jgen.writeStringField("lastName", value.getLastName());
    }
}