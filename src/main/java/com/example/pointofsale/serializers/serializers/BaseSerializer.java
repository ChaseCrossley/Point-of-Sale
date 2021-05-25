package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.daos.BaseDao;
import com.example.pointofsale.entities.BaseEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.SneakyThrows;

import java.io.IOException;

public abstract class BaseSerializer<Entity extends BaseEntity> extends StdSerializer<Entity> {

    public BaseSerializer() {
        this(null);
    }

    public BaseSerializer(Class<Entity> t) {
        super(t);
    }

    @Override
    public void serialize(Entity value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeObjectField("id", value.getId());
        serializeHelper(value, jgen);
        jgen.writeEndObject();
        jgen.flush();
    }

    abstract void serializeHelper(Entity value, JsonGenerator jgen) throws IOException;

}