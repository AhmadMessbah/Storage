package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.StorageTransaction;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped

public class StorageTransactionService implements ServiceImpl<StorageTransaction, Long>, Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public StorageTransaction save(StorageTransaction storageTransaction) throws Exception {
        entityManager.persist(storageTransaction);
        return storageTransaction;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public StorageTransaction edit(StorageTransaction storageTransaction) throws Exception {
        entityManager.merge(storageTransaction);
        return storageTransaction;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public StorageTransaction remove(Long id) throws Exception {
        StorageTransaction storageTransaction = entityManager.find(StorageTransaction.class, id);
        storageTransaction.setDeleted(true);
        entityManager.merge(storageTransaction);
        return storageTransaction;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public List<StorageTransaction> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from storageTransactionEntity oo");
        return query.getResultList();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public StorageTransaction findById(Long id) throws Exception {
        return entityManager.find(StorageTransaction.class, id);
    }
    //    -------------------------------------------------------------------------


    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public StorageTransaction findByStock(String stuffName) {
        Query query = entityManager.createNamedQuery("Storage.FindByStock");
        query.setParameter("stuffName", stuffName);
        return (StorageTransaction) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public StorageTransaction findByEntrance(Long entrance) {
        Query query = entityManager.createNamedQuery("Storage.FindByEntrance");
        query.setParameter("entrance", entrance);
        return (StorageTransaction) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public StorageTransaction findByExit(Long exit) {
        Query query = entityManager.createNamedQuery("Storage.FindByExit");
        query.setParameter("exit", exit);
        return (StorageTransaction) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public StorageTransaction findByTransactionDate(LocalDateTime transactionDate) {
        Query query = entityManager.createNamedQuery("Storage.FindByTransactionDate");
        query.setParameter("transactionDate", transactionDate);
        return (StorageTransaction) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public StorageTransaction findByUserId(int userId) {
        Query query = entityManager.createNamedQuery("Storage.FindByUserId");
        query.setParameter("userId", userId);
        return (StorageTransaction) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------


    @Transactional
    public StorageTransaction findByStuffName(String stuffName) {
        Query query = entityManager.createNamedQuery("Storage.FindByStuffName");
        query.setParameter("stuffName", stuffName);
        return (StorageTransaction) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------

}
