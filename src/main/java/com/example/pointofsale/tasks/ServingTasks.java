//package com.example.pointofsale.tasks;
//
//import com.example.pointofsale.daos.ServingUnitDao;
//import com.example.pointofsale.entities.Serving;
//import com.example.pointofsale.entities.ServingUnit;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//
//@Component
//public class ServingTasks extends BaseTasks<Serving> {
//
//    @Autowired
//    ServingUnitDao servingUnitDao;
//
//    public ServingTasks() {
//        super("serving", Serving.class);
//    }
//
//    @Override
//    public Serving getNewEntity() {
//        //TODO: confirm that I don't need id here
//        int endValue = RandomUtils.nextInt(0, 100);
//        float amount = RandomUtils.nextFloat(0, endValue);
//
//        List<ServingUnit> servingUnits = (List<ServingUnit>) servingUnitDao.allObjects();
//        ServingUnit servingUnit = servingUnits.get(RandomUtils.nextInt(0, servingUnits.size() - 1));
//
//        Serving serving = new Serving();
//        serving.setServingUnit(servingUnit);
//        serving.setAmount(amount);
//
//        return serving;
//    }
//}
