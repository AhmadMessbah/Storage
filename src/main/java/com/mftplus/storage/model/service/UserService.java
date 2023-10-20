package com.mftplus.storage.model.service;


import com.mftplus.storage.model.entity.User;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class UserService implements ServiceImpl<User,Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    @Override
    @Transactional
    public User save(User user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public User edit(User user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public User remove(Long id) throws Exception {
        return null;
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }

    @Override
    public User findById(Long id) throws Exception {
        return null;
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }

    public User FindByUserName(String userName) throws Exception{
        Query query=entityManager.createNamedQuery("User.FindByUserName");
        query.setParameter("userName",userName);
        return (User) query.getSingleResult();

    }
    public User FindByUserNameAndPassword(String userName , String password) throws Exception{
        Query query=entityManager.createNamedQuery("User.FindByUserNameAndPassword");
        query.setParameter("userName",userName);
        query.setParameter( "password",password);
        return (User) query.getSingleResult();

    }
}
