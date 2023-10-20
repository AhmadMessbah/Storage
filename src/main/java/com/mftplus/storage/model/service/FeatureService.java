package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Feature;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@ApplicationScoped
public class FeatureService implements ServiceImpl<Feature , Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Override
    public Feature save(Feature feature) throws Exception {
        return null;
    }

    @Override
    public Feature edit(Feature feature) throws Exception {
        return null;
    }

    @Override
    public Feature remove(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Feature> findAll() throws Exception {
        return null;
    }

    @Override
    public Feature findById(Long id) throws Exception {
        return null;
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }
}
