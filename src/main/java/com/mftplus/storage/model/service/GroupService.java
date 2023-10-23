package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class GroupService implements ServiceImpl<Group,Integer> , Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Group save(Group group) throws Exception {
        entityManager.persist(group);
        return group;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Group edit(Group group) throws Exception {
        entityManager.merge(group);
        return group;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Group remove(Integer id) throws Exception {
        Group group = entityManager.find(Group.class, id);
        group.setDeleted(true);
        entityManager.merge(group);
        return group;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<Group> findAll() {
        Query query = entityManager.createQuery("select oo from groupEntity oo");
        return query.getResultList();
    }
    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Group findById(Integer id) {
        return entityManager.find(Group.class, id);
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public  int getCount() throws Exception {
        return 0;
    }
    //    -------------------------------------------------------------------------

    @Transactional
    public Group findByParentId(int id) {
        Query query = entityManager.createNamedQuery("Group.FindByParentId");
        query.setParameter("parentId", id);
        return (Group) query.getSingleResult();

    }
    //    -------------------------------------------------------------------------

    @Transactional
    public List<Group> findByParentTitle(String parentTitle){
        Query query = entityManager.createNamedQuery("Group.FindByParentTitle");
        query.setParameter("parentTitle",parentTitle);
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------


    @Transactional
    public List<Group> findRootParents() {
        Query query = entityManager.createNamedQuery("Group.FindRootParents");
        return query.getResultList();
    }
    //    -------------------------------------------------------------------------

    @Transactional
    public List<Integer> findParentsId(int id) {
        Group group = findById(id);
        List<Integer> parentsId = new ArrayList<>();
        Group parent = group.getParent();
        while (parent!= null){
            parentsId.add(parent.getId());
            parent = parent.getParent();
        }
        return parentsId;
    }
    //    -------------------------------------------------------------------------

}
