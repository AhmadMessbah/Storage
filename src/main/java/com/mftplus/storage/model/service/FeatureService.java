package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Feature;
import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class FeatureService implements ServiceImpl<Feature , Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Override
    @Transactional
    public Feature save(Feature feature) throws Exception {
        entityManager.persist(feature);
        return feature;
    }

    @Override
    @Transactional
    public Feature edit(Feature feature) throws Exception {
        entityManager.merge(feature);
        return feature;
    }

    @Override
    @Transactional
    public Feature remove(Long id) throws Exception {
        Feature feature = entityManager.find(Feature.class,id);
        feature.setDeleted(true);
        entityManager.merge(feature);
        return feature;
    }

    @Override

    public List<Feature> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from featureEntity oo");
        return query.getResultList();
    }

    @Override

    public Feature findById(Long id) throws Exception {
        return entityManager.find(Feature.class,id);
    }

    @Override

    public int getCount() throws Exception {
        return 0;
    }
}
