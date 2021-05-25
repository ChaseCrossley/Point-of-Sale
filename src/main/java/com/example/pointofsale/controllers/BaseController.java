package com.example.pointofsale.controllers;

import com.example.pointofsale.daos.BaseDao;
import com.example.pointofsale.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin
public abstract class BaseController<Entity extends BaseEntity, Dao extends BaseDao<Entity>> {

    @Autowired
    private Dao dao;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Entity create(@RequestBody Entity newEntity) throws IOException {
        dao.create(newEntity);
        return newEntity;
    }

    @RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET)
    public Entity retrieve(@PathVariable("id") int id) throws IOException {
        return dao.getById(id);
    }

    @RequestMapping(value = "/retrieveAll", method = RequestMethod.GET)
    public Collection<Entity> retrieveAll() throws IOException {
        return dao.allObjects();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Entity update(@RequestBody Entity newEntity) throws IOException {
        return dao.upDate(newEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEntity(@PathVariable("id") int id) throws IOException {
        HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
        if (dao.getById(id) != null) {
                dao.deleteObjectById(id);
            responseStatus = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<>(responseStatus);
    }
}