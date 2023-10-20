package com.mftplus.storage.model.service.impl;

import java.util.List;

public interface ServiceImpl<T, I> {
    T save(T t) throws Exception;

    T edit(T t) throws Exception;

    T remove(I id) throws Exception;

    List<T> findAll() throws Exception;

    T findById(I id) throws Exception;

    int getCount() throws Exception;
}
