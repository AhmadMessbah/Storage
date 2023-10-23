package com.mftplus.storage.model.service;

import com.mftplus.storage.model.entity.Person;
import com.mftplus.storage.model.service.impl.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


import java.io.Serializable;
import java.util.List;

@ApplicationScoped

public class PersonService implements ServiceImpl<Person, Long>, Serializable {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Person save(Person person) throws Exception {
        entityManager.persist(person);
        return person;
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Person edit(Person person) throws Exception {
        entityManager.persist(person);
        return person;

    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Person remove(Long id) throws Exception {
        Person person = entityManager.find(Person.class, id);
        person.setDeleted(true);
        entityManager.merge(person);
        return person;

    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public List<Person> findAll() throws Exception {
        Query query = entityManager.createQuery("select oo from personEntity oo");
        return query.getResultList();
    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public Person findById(Long id) throws Exception {

        return entityManager.find(Person.class, id);

    }
//    -------------------------------------------------------------------------

    @Transactional
    @Override
    public int getCount() throws Exception {
        return 0;
    }
//    -------------------------------------------------------------------------

    @Transactional
    public Person findByNameFamily(String name, String family) {
        Query query = entityManager.createNamedQuery("Person.FindByNameFamily");
        query.setParameter("name", name);
        query.setParameter("family", family);
        return (Person) query.getSingleResult();
    }
}
