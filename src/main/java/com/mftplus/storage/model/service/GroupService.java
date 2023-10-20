package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class GroupService{
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    public Group save(Group group) throws Exception {
        entityManager.persist(group);
        return group;
    }

    public Group edit(Group group) throws Exception {
        entityManager.merge(group);
        return group;
    }

    public Group remove(Integer id) throws Exception {
        Group group = entityManager.find(Group.class,id);
        group.setDeleted(true);
        entityManager.merge(group);
        return group;
    }

    public List<Group> findAll() {
        Query query = entityManager.createQuery("select oo from groupEntity oo");
        return query.getResultList();
    }

    public Group findById(Integer id)  {
        return entityManager.find(Group.class,id);
    }
}
