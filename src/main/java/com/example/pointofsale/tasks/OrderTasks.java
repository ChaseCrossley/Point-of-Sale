package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.daos.ItemDao;
import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.*;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class OrderTasks extends BaseTasks<Order> {

    private static final int MAX_LIST_SIZE = 10;

    @Autowired
    UserDao customerDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    IngredientDao ingredientDao;

    @Autowired
    ItemTasks itemTasks;

    public OrderTasks() {
        super("order", Order.class);
    }

    @Override
    public Order getNewEntity() {
        final List<User> customers = (List<User>) customerDao.allObjects();
        User customer = customers.get(RandomUtils.nextInt(0, customers.size() - 1));

        Set<OrderItem> itemSet = new HashSet<>();
        for (int i = 0; i < MAX_LIST_SIZE; i++) {
            itemSet.add(getOrderItem());
        }

        Order order = new Order();
        order.setItems(itemSet);
        order.setCustomer(customer);

        return order;
    }

    public OrderItem getOrderItem() {
        final List<Item> items = (List<Item>) itemDao.allObjects();
        Item item = items.remove(RandomUtils.nextInt(0, items.size()));

        OrderItem orderItem = new OrderItem();

        orderItem.setItem(item);

        if (RandomUtils.nextBoolean()) {
            orderItem.setAddInIngredient(getAddInIngredientSet());
        }

        return orderItem;
    }

    private Set<AddInIngredient> getAddInIngredientSet() {
        Set<AddInIngredient> addInIngredients = new HashSet<>();
        for (int i = 0; i < MAX_LIST_SIZE; i++) {
            addInIngredients.add(getNewAddInIngredient());
        }
        return addInIngredients;
    }

    public AddInIngredient getNewAddInIngredient() {
        final List<Ingredient> ingredients = (List<Ingredient>) ingredientDao.allObjects();
        AddInIngredient addInIngredient = new AddInIngredient();
        addInIngredient.setIngredient(ingredients.remove(RandomUtils.nextInt(0, ingredients.size() - 1)));
        addInIngredient.setServing(itemTasks.getNewServing());
        return addInIngredient;
    }

}
