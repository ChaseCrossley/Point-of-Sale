//package com.example.pointofsale.tasks;
//
//import com.example.pointofsale.daos.IngredientDao;
//import com.example.pointofsale.daos.OrderItemDao;
//import com.example.pointofsale.daos.ServingDao;
//import com.example.pointofsale.entities.AddInIngredient;
//import com.example.pointofsale.entities.Ingredient;
//import com.example.pointofsale.entities.OrderItem;
//import com.example.pointofsale.entities.Serving;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//
//@Component
//public class AddInIngredientTasks extends BaseTasks<AddInIngredient> {
//
//    @Autowired
//    IngredientDao ingredientDao;
//    @Autowired
//    OrderItemDao orderItemDao;
//    @Autowired
//    ServingDao servingDao;
//
//    public AddInIngredientTasks() {
//        super("addInIngredient", AddInIngredient.class);
//    }
//
//    @Override
//    public AddInIngredient getNewEntity() {
//        final List<Ingredient> ingredientList = (List<Ingredient>) ingredientDao.allObjects();
//        Ingredient ingredient = ingredientList.get(RandomUtils.nextInt(0, ingredientList.size() - 1));
//
//        final List<OrderItem> orderItemList = (List<OrderItem>) orderItemDao.allObjects();
//        OrderItem orderItem = orderItemList.get(RandomUtils.nextInt(0, orderItemList.size() - 1));
//
//        final List<Serving> servingList = (List<Serving>) servingDao.allObjects();
//        Serving serving = servingList.get(RandomUtils.nextInt(0, servingList.size() - 1));
//
//       AddInIngredient addInIngredient = new AddInIngredient();
//       addInIngredient.setIngredient(ingredient);
//       addInIngredient.setOrderItem(orderItem);
//       addInIngredient.setServing(serving);
//       return addInIngredient;
//    }
//}
