package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.entity.Invoice;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class InvoiceService implements ServiceImpl<Invoice,Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    public Invoice save(Invoice invoice) throws Exception {
        entityManager.persist(invoice);
        return invoice;
    }

    @Override
    public Invoice edit(Invoice invoice) throws Exception {
        entityManager.merge(invoice);
        return invoice;
    }

    @Override
    public Invoice remove(Long id) throws Exception {
        Invoice invoice = entityManager.find(Invoice.class,id);
        invoice.setDeleted(true);
        entityManager.merge(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from invoiceEntity oo");
        return query.getResultList();
    }

    @Override
    public Invoice findById(Long id) throws Exception {
        return entityManager.find(Invoice.class,id);
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }
}
