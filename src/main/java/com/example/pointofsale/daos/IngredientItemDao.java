package com.example.pointofsale.daos;

import com.example.pointofsale.entities.IngredientItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository
@Transactional
public class IngredientItemDao extends BaseDao<IngredientItem> {

    public IngredientItemDao() {
        super(IngredientItem.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Collection<IngredientItem> getByItemId(int id) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<IngredientItem> cq = cb.createQuery(IngredientItem.class);
        Root<IngredientItem> rootEntry = cq.from(IngredientItem.class);
        CriteriaQuery<IngredientItem> orderItemWithFK = cq.select(rootEntry).where(cb.equal(rootEntry.get("item"), id));
        TypedQuery<IngredientItem> allQuery = entityManager.createQuery(orderItemWithFK);
        return allQuery.getResultList();
    }
}