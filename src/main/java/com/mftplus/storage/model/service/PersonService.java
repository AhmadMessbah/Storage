package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.entity.Person;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jdk.jshell.PersistentSnippet;

import java.util.List;

public class PersonService implements ServiceImpl<Person, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Override
    @Transactional
    public Person save(Person person) throws Exception {
        entityManager.persist(person);
        return person;
    }

    @Override
    public Person edit(Person person) throws Exception {
        entityManager.persist(person);
        return person;

    }

    @Override

    public Person remove(Long id) throws Exception {
//        entityManager.persist(Person);
        return null;

    }

    @Override
    public List<Person> findAll() throws Exception {
        return null;
    }

    @Override
    public Person findById(Long id) throws Exception {
        return null;
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }
}
