package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.entity.StorageTransaction;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class StorageTransactionService implements ServiceImpl<StorageTransaction, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public StorageTransaction save(StorageTransaction storageTransaction) throws Exception {
        entityManager.persist(storageTransaction);
        return storageTransaction;
    }

    @Override
    @Transactional
    public StorageTransaction edit(StorageTransaction storageTransaction) throws Exception {
        entityManager.merge(storageTransaction);
        return storageTransaction;
    }

    @Override
    @Transactional
    public StorageTransaction remove(Long id) throws Exception {
        StorageTransaction storageTransaction = entityManager.find(StorageTransaction.class,id);
        storageTransaction.setDeleted(true);
        entityManager.merge(storageTransaction);
        return storageTransaction;
    }

    @Override
    @Transactional
    public List<StorageTransaction> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from storageTransactionEntity oo");
        return query.getResultList();
    }

    @Override
    @Transactional
    public StorageTransaction findById(Long id) throws Exception {
        return entityManager.find(StorageTransaction.class,id);
    }

    @Override
    @Transactional
    public int getCount() throws Exception {
        return 0;
    }
    public StorageTransaction findByStock(String stuffName){
        Query query=entityManager.createNamedQuery("Storage.FindByStock");
        query.setParameter("stuffName",stuffName);
        return (StorageTransaction) query.getSingleResult();
    }
    public StorageTransaction findByEntrance(LocalDateTime entrance){
        Query query=entityManager.createNamedQuery("Storage.FindByEntrance");
        query.setParameter("entrance",entrance);
        return (StorageTransaction) query.getSingleResult();
    }
    public StorageTransaction findByExit(LocalDateTime exit){
        Query query=entityManager.createNamedQuery("Storage.FindByExit");
        query.setParameter("exit",exit);
        return (StorageTransaction) query.getSingleResult();
    }
    public StorageTransaction findByTransactionDate(LocalDateTime transactionDate){
        Query query=entityManager.createNamedQuery("Storage.FindByTransactionDate");
        query.setParameter("transactionDate",transactionDate);
        return (StorageTransaction) query.getSingleResult();
    }
    public StorageTransaction findByUserId(String userId){
        Query query=entityManager.createNamedQuery("Storage.FindByUserId");
        query.setParameter("userId",userId);
        return (StorageTransaction) query.getSingleResult();
    }
    public StorageTransaction findByStuffName(String stuffName){
        Query query=entityManager.createNamedQuery("Storage.FindByStuffName");
        query.setParameter("stuffName",stuffName);
        return (StorageTransaction) query.getSingleResult();
    }
}
