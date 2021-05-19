package com.example.pointofsale.tasks;

import com.example.pointofsale.entities.BaseEntity;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public abstract class BaseTasks<Entity extends BaseEntity> {
    private final String PATH = "http://localhost:8080";
    private final RestTemplate restTemplate = new RestTemplate();
    private final List<Integer> idSet = new ArrayList<>();
    private String directive;
    private Class<Entity> entityClass;

    public BaseTasks(String directive, Class<Entity> entityClass) {
        this.directive = directive;
        this.entityClass = entityClass;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void addEntity() {
        Entity entity = getNewEntity();
        entity = restTemplate.postForObject(PATH + directive + "/create", entity, entityClass);
        idSet.add(entity.getId());
    }

    abstract Entity getNewEntity();

    @Scheduled(cron = "*/10 * * * * *")
    public void deleteEntity() {
        int idToDelete = idSet.remove(RandomUtils.nextInt(0, idSet.size() - 1));
        restTemplate.delete(PATH + directive + "/delete/" + idToDelete);
    }

    @Scheduled(cron = "*/7 * * * * *")
    public void updateEntity() {
        int indexToUpdate = idSet.get(RandomUtils.nextInt(0, idSet.size() - 1));
        Entity newEntity = restTemplate.getForObject(PATH + directive + "/retrieve/" + indexToUpdate, entityClass);
        restTemplate.put(PATH + directive + "/update", newEntity);
        Entity checkUpdate = restTemplate.getForObject(PATH + directive + "/retrieve/" + indexToUpdate, entityClass);
        if (!newEntity.equals(checkUpdate)) {
            throw new NoSuchElementException();
        }
    }

}
