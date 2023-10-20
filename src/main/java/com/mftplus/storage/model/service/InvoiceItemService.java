package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.InvoiceItem;
import com.mftplus.storage.model.entity.User;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class InvoiceItemService implements ServiceImpl<InvoiceItem,Long>  {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
    @Override
    @Transactional
    public InvoiceItem save(InvoiceItem invoiceItem) throws Exception {
        entityManager.persist(invoiceItem);
        return invoiceItem;
    }

    @Override
    @Transactional
    public InvoiceItem edit(InvoiceItem invoiceItem) throws Exception {
        entityManager.merge(invoiceItem);
        return invoiceItem;
    }

    @Override
    @Transactional
    public InvoiceItem remove(Long id) throws Exception {
        InvoiceItem invoiceItem=entityManager.find(InvoiceItem.class,id);
        invoiceItem.setDeleted(true);
        entityManager.merge(invoiceItem);
        return invoiceItem;
    }

    @Override
    public List<InvoiceItem> findAll() throws Exception {
        // todo:entity name
        Query query = entityManager.createQuery("select oo from invoiceItemEntity oo");
        return query.getResultList();
    }

    @Override
    public InvoiceItem findById(Long id) throws Exception {
        return entityManager.find(InvoiceItem.class,id);

    }
    public InvoiceItem findByStuffId(Long id){
        Query query = entityManager.createNamedQuery("InvoiceItem.FindByStuffId");
        query.setParameter("StuffId",id);
        return (InvoiceItem) query.getSingleResult();
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }
}
