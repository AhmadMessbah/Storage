package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@SessionScoped
public class Service implements Serializable {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    public Service() {
        System.out.println("Service - Created");
    }

    @Transactional
    public void test(){
        System.out.println("Service - test");
        Group root1 = Group.builder().title("Root1").build();
        entityManager.persist(root1);
        System.out.println(root1);
    }
}
