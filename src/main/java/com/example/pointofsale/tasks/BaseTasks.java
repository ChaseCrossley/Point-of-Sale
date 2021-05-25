package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.BaseDao;
import com.example.pointofsale.entities.BaseEntity;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public abstract class BaseTasks<Entity extends BaseEntity> {
    private final String PATH = "http://0.0.0.0:3724/api/";
    private final RestTemplate restTemplate = new RestTemplate();
    private final List<Integer> idSet = new ArrayList<>();
    private final String directive;
    private final Class<Entity> entityClass;

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

    abstract public Entity getNewEntity();

    private Entity getUpdateEntity(Entity entity) {
        Entity updated = getNewEntity();
        updated.setId(entity.getId());
        return updated;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void deleteEntity() {
        int idToDelete = idSet.remove(RandomUtils.nextInt(0, idSet.size() - 1));
        restTemplate.delete(PATH + directive + "/delete/" + idToDelete);
    }

    @Scheduled(cron = "*/7 * * * * *")
    public void updateEntity() {
        int indexToUpdate = idSet.get(RandomUtils.nextInt(0, idSet.size() - 1));
        Entity oldEntity = restTemplate.getForObject(PATH + directive + "/retrieve/" + indexToUpdate, entityClass);
        restTemplate.put(PATH + directive + "/update", getUpdateEntity(oldEntity));
        Entity checkUpdate = restTemplate.getForObject(PATH + directive + "/retrieve/" + indexToUpdate, entityClass);
        if (!oldEntity.equals(checkUpdate)) {
            throw new NoSuchElementException();
        }
    }

}
