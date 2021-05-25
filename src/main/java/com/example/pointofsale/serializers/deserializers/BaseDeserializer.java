package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.BaseEntity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.io.IOException;

@Configurable
public abstract class BaseDeserializer<Entity extends BaseEntity> extends StdDeserializer<Entity> {


    private final Class<Entity> type;
    @Autowired
    UserDao userDao;

    public BaseDeserializer() {
        this(null);
    }

    public BaseDeserializer(Class<Entity> t) {
        super(t);
        type = t;
    }

    @Override
    public Entity deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        Entity deserializedEntity = null;

        DeserializationConfig config = ctxt.getConfig();
        JavaType type = TypeFactory.defaultInstance().constructType(this.type);
        JsonDeserializer<Object> defaultDeserializer = BeanDeserializerFactory.instance.buildBeanDeserializer(ctxt, type, config.introspect(type));

        if (defaultDeserializer instanceof ResolvableDeserializer) {
            ((ResolvableDeserializer) defaultDeserializer).resolve(ctxt);
        }

        JsonParser treeParser = oc.treeAsTokens(node);
        config.initialize(treeParser);

        if (treeParser.getCurrentToken() == null) {
            treeParser.nextToken();
        }

        deserializedEntity = (Entity) defaultDeserializer.deserialize(treeParser, ctxt);

        if (node.get("id").isNull()) {
            deserializedEntity.setId(null);
        }

        return deserializedEntity;
    }

    abstract Entity deserializeHelper(Entity value) throws IOException;


}
