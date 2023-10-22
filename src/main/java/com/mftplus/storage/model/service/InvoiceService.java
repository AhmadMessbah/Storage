package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Invoice;
import com.mftplus.storage.model.entity.enums.InvoiceType;
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

public class InvoiceService implements ServiceImpl<Invoice, Long>, Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public Invoice save(Invoice invoice) throws Exception {
        if (invoice.getInvoiceType().equals(InvoiceType.sell)) {
            entityManager.persist(invoice);
        } else {
            entityManager.persist(invoice);
        }
        return invoice;
    }

    @Override
    @Transactional
    public Invoice edit(Invoice invoice) throws Exception {
        entityManager.merge(invoice);
        return invoice;
    }

    @Override
    @Transactional
    public Invoice remove(Long id) throws Exception {
        Invoice invoice = entityManager.find(Invoice.class, id);
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
        return entityManager.find(Invoice.class, id);
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }

    public Invoice findByUserId(Long userId) {
        Query query = entityManager.createNamedQuery("Invoice.FindByUserId");
        query.setParameter("userId", userId);
        return (Invoice) query.getSingleResult();
    }

    public Invoice findByUserName(String userName) {
        Query query = entityManager.createNamedQuery("Invoice.FindByUserName");
        query.setParameter("userName", userName);
        return (Invoice) query.getSingleResult();
    }

    public List<Invoice> findByDataRange(LocalDateTime startTimeStamp, LocalDateTime endTimeStamp) {
        Query query = entityManager.createNamedQuery("Invoice.FindByDateRange");
        query.setParameter("startTimeStamp", startTimeStamp);
        query.setParameter("endTimeStamp", endTimeStamp);
        return query.getResultList();
    }

    public Invoice findByInvoiceId(Long invoiceNumber) {
        Query query = entityManager.createNamedQuery("Invoice.FindByInvoiceNumber");
        query.setParameter("invoiceNumber", invoiceNumber);
        return (Invoice) query.getSingleResult();
    }
}
