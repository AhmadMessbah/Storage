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

    @Override
    @Transactional
    public FeatureValue save(FeatureValue user) throws Exception {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public FeatureValue edit(FeatureValue user) throws Exception {
        entityManager.merge(user);
        return user;
    }

    @Override
    @Transactional
    public FeatureValue remove(Long id) throws Exception {
        FeatureValue featureValue = entityManager.find(FeatureValue.class, id);
        featureValue.setDeleted(true);
        entityManager.merge(featureValue);
        return featureValue;
    }

    @Override
    @Transactional
    public List<FeatureValue> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from featureValueEntity oo");
        return query.getResultList();
    }

    @Override
    @Transactional
    public FeatureValue findById(Long id) throws Exception {
        return entityManager.find(FeatureValue.class, id);
    }

    public FeatureValue findByName(String value) {
        Query query = entityManager.createNamedQuery("FeatureValue.FindByName");
        query.setParameter("value", value);
        return (FeatureValue) query.getSingleResult();
    }

    public FeatureValue findByGroupId(Long id) {
        Query query = entityManager.createNamedQuery("FeatureValue.FindByGroupId");
        query.setParameter("groupId", id);
        return (FeatureValue) query.getSingleResult();
    }

    public FeatureValue FindByPrentTitle(String groupTitle) {
        Query query = entityManager.createNamedQuery("FeatureValue.FindByGroupTitle");
        query.setParameter("groupTitle", groupTitle);
        return (FeatureValue) query.getSingleResult();
    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
}

