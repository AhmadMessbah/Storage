package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Stuff;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class StuffService implements ServiceImpl<Stuff, Long>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Stuff save(Stuff stuff) throws Exception {
        entityManager.persist(stuff);
        return stuff;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Stuff edit(Stuff stuff) throws Exception {
        entityManager.merge(stuff);
        return stuff;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Stuff remove(Long id) throws Exception {
        Stuff stuff = entityManager.find(Stuff.class, id);
        stuff.setDeleted(true);
        entityManager.merge(stuff);
        return stuff;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<Stuff> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from stuffEntity oo");
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Stuff findById(Long id) throws Exception {
        return entityManager.find(Stuff.class, id);
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public Stuff findByName(String name) {
        Query query = entityManager.createNamedQuery("Stuff.FindByName");
        query.setParameter("name", name);
        return (Stuff) query.getSingleResult();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public Stuff findByGroupId(int groupId) {
        Query query = entityManager.createNamedQuery("Stuff.FindByGroupId");
        query.setParameter("groupId", groupId);
        return (Stuff) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------

    @Transactional
    public Stuff byGroupTitle(String groupTitle) {
        Query query = entityManager.createNamedQuery("Stuff.FindByGroupTitle");
        query.setParameter("groupTitle", groupTitle);
        return (Stuff) query.getSingleResult();
    }
}
