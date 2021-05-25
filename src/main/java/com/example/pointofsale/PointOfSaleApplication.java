package com.example.pointofsale;

import com.example.pointofsale.entities.*;
import com.example.pointofsale.serializers.deserializers.*;
import com.example.pointofsale.serializers.serializers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

//@EnableScheduling
@SpringBootApplication
public class PointOfSaleApplication {

    @Autowired
    private ObjectMapper objectMapper;


    public static void main(String[] args) {
        SpringApplication.run(PointOfSaleApplication.class, args);
    }

    @PostConstruct
    public void setUp() {
        SimpleModule module = new SimpleModule();

        module.addSerializer(AddInIngredient.class, new AddInIngredientSerializer(AddInIngredient.class));
        module.addDeserializer(AddInIngredient.class, new AddInIngredientDeserializer(AddInIngredient.class));

        module.addSerializer(Employee.class, new EmployeeSerializer(Employee.class));
        module.addDeserializer(Employee.class, new EmployeeDeserializer(Employee.class));

        module.addSerializer(Ingredient.class, new IngredientSerializer(Ingredient.class));
        module.addDeserializer(Ingredient.class, new IngredientDeserializer(Ingredient.class));

        module.addSerializer(IngredientItem.class, new IngredientItemSerializer(IngredientItem.class));
        module.addDeserializer(IngredientItem.class, new IngredientItemDeserializer(IngredientItem.class));

        module.addSerializer(Item.class, new ItemSerializer(Item.class));
        module.addDeserializer(Item.class, new ItemDeserializer(Item.class));

        module.addSerializer(Order.class, new OrderSerializer(Order.class));
        module.addDeserializer(Order.class, new OrderDeserializer(Order.class));

        module.addSerializer(OrderItem.class, new OrderItemSerializer(OrderItem.class));
        module.addDeserializer(OrderItem.class, new OrderItemDeserializer(OrderItem.class));

        module.addSerializer(Serving.class, new ServingSerializer(Serving.class));
        module.addDeserializer(Serving.class, new ServingDeserializer(Serving.class));

        module.addSerializer(ServingUnit.class, new ServingUnitSerializer(ServingUnit.class));
        module.addDeserializer(ServingUnit.class, new ServingUnitDeserializer(ServingUnit.class));

        module.addSerializer(User.class, new UserSerializer(User.class));
        module.addDeserializer(User.class, new UserDeserializer(User.class));

        objectMapper.registerModule(module);
        objectMapper.registerModule(new JavaTimeModule());
    }

}

