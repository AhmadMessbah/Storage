package com.mftplus.storage.model.service;


import com.mftplus.storage.model.entity.User;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped

public class UserService implements ServiceImpl<User, Integer>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public User save(User user) throws Exception {
        entityManager.persist(user);
        return user;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public User edit(User user) throws Exception {
        entityManager.merge(user);
        return user;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public User remove(Integer id) throws Exception {
        User user = entityManager.find(User.class, id);
        user.setDeleted(true);
        entityManager.merge(user);
        return user;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<User> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from userEntity oo");
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public User findById(Integer id) throws Exception {
        return entityManager.find(User.class, id);
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public User FindByUserName(String userName) {
        Query query = entityManager.createNamedQuery("User.FindByUserName");
        query.setParameter("userName", userName);
        return (User) query.getSingleResult();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public User FindByUserNameAndPassword(String userName, String password) {
        Query query = entityManager.createNamedQuery("User.FindByUserNameAndPassword");
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------

}
