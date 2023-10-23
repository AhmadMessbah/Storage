package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.FeatureValue;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped

public class FeatureValueService implements ServiceImpl<FeatureValue, Long>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public FeatureValue save(FeatureValue user) throws Exception {
        entityManager.persist(user);
        return user;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public FeatureValue edit(FeatureValue user) throws Exception {
        entityManager.merge(user);
        return user;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public FeatureValue remove(Long id) throws Exception {
        FeatureValue featureValue = entityManager.find(FeatureValue.class, id);
        featureValue.setDeleted(true);
        entityManager.merge(featureValue);
        return featureValue;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<FeatureValue> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from featureValueEntity oo");
        return query.getResultList();
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public FeatureValue findById(Long id) throws Exception {
        return entityManager.find(FeatureValue.class, id);
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
//    -------------------------------------------------------------------------

    @Transactional
    public FeatureValue findByName(String value) {
        Query query = entityManager.createNamedQuery("FeatureValue.FindByName");
        query.setParameter("value", value);
        return (FeatureValue) query.getSingleResult();
    }
//    -------------------------------------------------------------------------

    @Transactional
    public FeatureValue findByGroupId(int id) {
        Query query = entityManager.createNamedQuery("FeatureValue.FindByGroupId");
        query.setParameter("groupId", id);
        return (FeatureValue) query.getSingleResult();
    }
//    -------------------------------------------------------------------------

    @Transactional
    public FeatureValue FindByPrentTitle(String groupTitle) {
        Query query = entityManager.createNamedQuery("FeatureValue.FindByGroupTitle");
        query.setParameter("groupTitle", groupTitle);
        return (FeatureValue) query.getSingleResult();
    }
//    -------------------------------------------------------------------------


}

