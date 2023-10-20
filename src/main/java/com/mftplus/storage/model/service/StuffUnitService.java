package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.entity.StuffUnit;
import com.mftplus.storage.model.entity.User;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class StuffUnitService implements ServiceImpl<StuffUnit, Integer> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public StuffUnit save(StuffUnit stuffUnit) throws Exception {
        entityManager.persist(stuffUnit);
        return stuffUnit;
    }

    @Override
    @Transactional
    public StuffUnit edit(StuffUnit stuffUnit) throws Exception {
        entityManager.merge(stuffUnit);
        return stuffUnit;
    }

    @Override
    @Transactional
    public StuffUnit remove(Integer id) throws Exception {
        StuffUnit stuffUnit = entityManager.find(StuffUnit.class,id);
        stuffUnit.setDeleted(true);
        entityManager.merge(stuffUnit);
        return stuffUnit;
    }

    @Override
    @Transactional
    public List<StuffUnit> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from groupEntity oo");
        return query.getResultList();
    }

    @Override
    @Transactional
    public StuffUnit findById(Integer id) throws Exception {
        return entityManager.find(StuffUnit.class,id);
    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
}
