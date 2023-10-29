package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Financial;
import jakarta.enterprise.context.ApplicationScoped;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class FinancialService implements ServiceImpl<Financial,Long> , Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public Financial save(Financial financial) throws Exception {
        entityManager.persist(financial);
        return financial;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public Financial edit(Financial financial) throws Exception {
        entityManager.merge(financial);
        return financial;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public Financial remove(Long id) throws Exception {
        Financial financial = entityManager.find(Financial.class, id);
        financial.setDeleted(true);
        entityManager.merge(financial);
        return financial;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public List<Financial> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from financialEntity oo");
        return query.getResultList();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public Financial findById(Long id) throws Exception {
        return entityManager.find(Financial.class, id);
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
}
