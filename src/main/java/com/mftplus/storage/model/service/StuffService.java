package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Stuff;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class StuffService implements ServiceImpl<Stuff, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public Stuff save(Stuff stuff) throws Exception {
        entityManager.persist(stuff);
        return stuff;
    }

    @Override
    @Transactional
    public Stuff edit(Stuff stuff) throws Exception {
        entityManager.merge(stuff);
        return stuff;
    }

    @Override
    @Transactional
    public Stuff remove(Long id) throws Exception {
        Stuff stuff = entityManager.find(Stuff.class,id);
        stuff.setDeleted(true);
        entityManager.merge(stuff);
        return stuff;
    }

    @Override
    @Transactional
    public List<Stuff> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from stuffEntity oo");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Stuff findById(Long id) throws Exception {
        return entityManager.find(Stuff.class,id);
    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
    public Stuff findByName(String name) throws  Exception{
        Query query = entityManager.createNamedQuery("Stuff.FindByName");
        query.setParameter("name",name);
        return (Stuff) query.getSingleResult();
    }
    public Stuff findByGroupId(Long groupId) throws Exception{
        Query query = entityManager.createNamedQuery("Stuff.FindByGroupId");
        query.setParameter("groupId",groupId);
        return (Stuff) query.getSingleResult();
    }
    public Stuff byGroupTitle(String groupTitle) throws Exception{
        Query query = entityManager.createNamedQuery("Stuff.FindByGroupTitle");
        query.setParameter("groupTitle",groupTitle);
        return (Stuff) query.getSingleResult();
    }
}
