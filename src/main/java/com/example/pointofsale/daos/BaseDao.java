package com.example.pointofsale.daos;

import com.example.pointofsale.entities.BaseEntity;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;

@Repository
@Transactional
public abstract class BaseDao<E extends BaseEntity> {

    private final Class<E> type;
    @PersistenceContext
    private EntityManager entityManager;

    public BaseDao(Class<E> type) {
        this.type = type;
    }

    public E create(E object) {
        return persistOrMerge(object);
    }

    //Return the greeting with the passed-in id.
    public E getById(int id) {
        return entityManager.find(type, id);
    }

    public E upDate(E updatedObject) {
        return persistOrMerge(updatedObject);
    }

    public E deleteObjectById(int id) {
        return deleteObject(getById(id));
    }

    public E deleteObject(E objectToDelete) {
//        entityManager.remove(entityManager.contains(objectToDelete) ? objectToDelete : entityManager.merge(objectToDelete));
        objectToDelete.setDeleted(true);
        return upDate(objectToDelete);
    }

    public Collection<E> allObjects() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(type);
        Root<E> rootEntry = cq.from(type);
        CriteriaQuery<E> all = cq.select(rootEntry).where(cb.isFalse(rootEntry.get("deleted")));
        TypedQuery<E> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    private E persistOrMerge(E entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }
}