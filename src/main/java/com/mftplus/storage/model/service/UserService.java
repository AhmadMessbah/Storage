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

public class UserService implements ServiceImpl<User, Long>, Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) throws Exception {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User edit(User user) throws Exception {
        entityManager.merge(user);
        return user;
    }

    @Override
    @Transactional
    public User remove(Long id) throws Exception {
        User user = entityManager.find(User.class, id);
        user.setDeleted(true);
        entityManager.merge(user);
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from userEntity oo");
        return query.getResultList();
    }

    @Override
    public User findById(Long id) throws Exception {
        return entityManager.find(User.class, id);
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }

    public User FindByUserName(String userName) {
        Query query = entityManager.createNamedQuery("User.FindByUserName");
        query.setParameter("userName", userName);
        return (User) query.getSingleResult();
    }

    public User FindByUserNameAndPassword(String userName, String password) {
        Query query = entityManager.createNamedQuery("User.FindByUserNameAndPassword");
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }
}
