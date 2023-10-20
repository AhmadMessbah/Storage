package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Feature;
import com.mftplus.storage.model.entity.FeatureValue;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class FeatureValueService implements ServiceImpl<FeatureValue, Long> {
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
        FeatureValue featureValue = entityManager.find(FeatureValue.class,id);
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
        return entityManager.find(FeatureValue.class,id);
    }

    // TODO: 10/20/2023 findByFeatureName/ID, findByGroupTitle/ID



    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
}

