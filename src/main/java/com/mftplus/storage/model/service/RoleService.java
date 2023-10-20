package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.entity.Role;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class RoleService implements ServiceImpl<Role, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public Role save(Role role) throws Exception {
        entityManager.persist(role);
        return role;

    }

    @Override
    @Transactional
    public Role edit(Role role) throws Exception {
        entityManager.merge(role);
        return role;
    }

    @Override
    @Transactional
    public Role remove(Long id) throws Exception {
        Role role = entityManager.find(Role.class,id);
        role.setDeleted(true);
        entityManager.merge(role);
        return role;
    }

    @Override
    @Transactional
    public List<Role> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from roleEntity oo");
        return query.getResultList();

    }

    @Override
    @Transactional
    public Role findById(Long id) throws Exception {
//        return entityManager.find(Group.class,id);
        return null;

    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
}
