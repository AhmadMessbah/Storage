package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.StuffUnit;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped

public class StuffUnitService implements ServiceImpl<StuffUnit, Integer>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public StuffUnit save(StuffUnit stuffUnit) throws Exception {
        entityManager.persist(stuffUnit);
        return stuffUnit;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public StuffUnit edit(StuffUnit stuffUnit) throws Exception {
        entityManager.merge(stuffUnit);
        return stuffUnit;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public StuffUnit remove(Integer id) throws Exception {
        StuffUnit stuffUnit = entityManager.find(StuffUnit.class, id);
        stuffUnit.setDeleted(true);
        entityManager.merge(stuffUnit);
        return stuffUnit;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<StuffUnit> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from stuffUnitEntity oo");
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public StuffUnit findById(Integer id) throws Exception {
        return entityManager.find(StuffUnit.class, id);
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public StuffUnit FindByName(String unitName) {
        Query query = entityManager.createNamedQuery("StuffUnit.FindByName");
        query.setParameter("unitName", unitName);
        return (StuffUnit) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------

}
