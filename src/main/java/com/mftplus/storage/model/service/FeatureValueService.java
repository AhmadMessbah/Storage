package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.FeatureValue;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.transaction.Transactional;

import java.util.List;

public class FeatureValueService implements ServiceImpl<FeatureValue, Long> {
    @Override
    @Transactional
    public FeatureValue save(FeatureValue user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public FeatureValue edit(FeatureValue user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public FeatureValue remove(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public List<FeatureValue> findAll() throws Exception {
        return null;
    }

    @Override
    @Transactional
    public FeatureValue findById(Long id) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
}

