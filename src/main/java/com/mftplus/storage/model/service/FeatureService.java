package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Feature;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class FeatureService implements ServiceImpl<Feature, Long>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
//    -------------------------------------------------------------------------


    @Transactional
    @Override
    public Feature save(Feature feature) throws Exception {
        entityManager.persist(feature);
        return feature;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Feature edit(Feature feature) throws Exception {
        entityManager.merge(feature);
        return feature;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Feature remove(Long id) throws Exception {
        Feature feature = entityManager.find(Feature.class, id);
        feature.setDeleted(true);
        entityManager.merge(feature);
        return feature;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<Feature> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from featureEntity oo");
        return query.getResultList();
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Feature findById(Long id) throws Exception {
        return entityManager.find(Feature.class, id);
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
//    -------------------------------------------------------------------------

    @Transactional
    public Feature findByName(String featureName) {
        Query query = entityManager.createNamedQuery("Feature.FindByName");
        query.setParameter("featureName", featureName);
        return (Feature) query.getSingleResult();
    }
//    -------------------------------------------------------------------------

    @Transactional
    public Feature findByGroupId(int id) {
        Query query = entityManager.createNamedQuery("Feature.FindByGroupId");
        query.setParameter("groupId", id);
        return (Feature) query.getSingleResult();
    }
//    -------------------------------------------------------------------------

    @Transactional
    public Feature FindByGroupTitle(String groupTitle) {
        Query query = entityManager.createNamedQuery("Feature.FindByGroupTitle");
        query.setParameter("groupTitle", groupTitle);
        return (Feature) query.getSingleResult();
    }
//    -------------------------------------------------------------------------


}
