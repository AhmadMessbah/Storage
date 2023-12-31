package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Role;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped

public class RoleService implements ServiceImpl<Role, Long>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Role save(Role role) throws Exception {
        entityManager.persist(role);
        return role;

    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Role edit(Role role) throws Exception {
        entityManager.merge(role);
        return role;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Role remove(Long id) throws Exception {
        Role role = entityManager.find(Role.class, id);
        role.setDeleted(true);
        entityManager.merge(role);
        return role;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<Role> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from roleEntity oo");
        return query.getResultList();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public Role findById(Long id) throws Exception {
        return entityManager.find(Role.class, id);
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
    //    -------------------------------------------------------------------------

}
