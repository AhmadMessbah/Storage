package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Payment;
import com.mftplus.storage.model.entity.enums.PaymentType;
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


public class PaymentService implements ServiceImpl<Payment, Long>, Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Payment save(Payment payment) throws Exception {
        entityManager.persist(payment);
        return payment;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Payment edit(Payment payment) throws Exception {
        entityManager.merge(payment);
        return payment;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Payment remove(Long id) throws Exception {
        Payment payment = entityManager.find(Payment.class, id);
        payment.setDeleted(true);
        entityManager.merge(payment);
        return payment;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<Payment> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from paymentEntity oo");
        return query.getResultList();
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Payment findById(Long id) throws Exception {
        return entityManager.find(Payment.class, id);

    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }

    //    -------------------------------------------------------------------------
    @Transactional
    public Payment findByUserId(int id) {
        Query query = entityManager.createNamedQuery("Payment.FindByUserId");
        query.setParameter("userId", id);
        return (Payment) query.getSingleResult();
    }
//    -------------------------------------------------------------------------

    @Transactional
    public Payment findByUserName(String userName) {
        Query query = entityManager.createNamedQuery("Payment.FindByUserName");
        query.setParameter("userName", userName);
        return (Payment) query.getSingleResult();}

    //    -------------------------------------------------------------------------

    @Transactional
    public List<Payment> findByPaymentType(PaymentType paymentType){
        Query query = entityManager.createNamedQuery("Payment.FindByPaymentType");
        query.setParameter("paymentType",paymentType);
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public List<Payment> SumAmount(LocalDateTime startTimeStamp,LocalDateTime endTimeStamp){
        Query query = entityManager.createNamedQuery("Payment.SumAmount");
        query .setParameter("startTimeStamp",startTimeStamp);
        query .setParameter("endTimeStamp",endTimeStamp);
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------

    @Transactional
    public List<Payment> findByDateRange(LocalDateTime startTimeStamp, LocalDateTime endTimeStamp){
        Query query = entityManager.createNamedQuery("Payment.FindByDateRange");
        query.setParameter("startTimeStamp", startTimeStamp);
        query.setParameter("endTimeStamp", endTimeStamp);
        return query.getResultList();
    }

    //    -------------------------------------------------------------------------


    @Transactional
    public Payment findByInvoiceNumber(Long id){
        Query query = entityManager.createNamedQuery("Payment.FindByInvoiceNumber");
        query.setParameter("invoiceId",id);
        return (Payment) query.getSingleResult();
    }
    //    -------------------------------------------------------------------------
}
