package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.InvoiceItem;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped

public class InvoiceItemService implements ServiceImpl<InvoiceItem, Long>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public InvoiceItem save(InvoiceItem invoiceItem) throws Exception {
        entityManager.persist(invoiceItem);
        return invoiceItem;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public InvoiceItem edit(InvoiceItem invoiceItem) throws Exception {
        entityManager.merge(invoiceItem);
        return invoiceItem;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public InvoiceItem remove(Long id) throws Exception {
        InvoiceItem invoiceItem = entityManager.find(InvoiceItem.class, id);
        invoiceItem.setDeleted(true);
        entityManager.merge(invoiceItem);
        return invoiceItem;
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<InvoiceItem> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from invoiceItemEntity oo");
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public InvoiceItem findById(Long id) throws Exception {
        return entityManager.find(InvoiceItem.class, id);

    }

    //    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
    //    -------------------------------------------------------------------------
    @Transactional
    public InvoiceItem findByInvoiceId(Long invoiceId) {
        Query query = entityManager.createNamedQuery("InvoiceItem.FindByInvoiceId");
        query.setParameter("invoiceId", invoiceId);
        return (InvoiceItem) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------

    @Transactional
    public InvoiceItem findByStuffId(Long stuffId) {
        Query query = entityManager.createNamedQuery("InvoiceItem.FindByStuffId");
        query.setParameter("stuffId", stuffId);
        return (InvoiceItem) query.getSingleResult();
    }


}
