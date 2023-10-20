package com.mftplus.storage.model.service;

import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.transaction.Transactional;

import java.util.List;

public class FeatureValueService implements ServiceImpl<FeatureValueService, Long> {
    @Override
    @Transactional
    public FeatureValueService save(FeatureValueService user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public FeatureValueService edit(FeatureValueService user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public FeatureValueService remove(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public List<FeatureValueService> findAll() throws Exception {
        return null;
    }

    @Override
    @Transactional
    public FeatureValueService findById(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
}

