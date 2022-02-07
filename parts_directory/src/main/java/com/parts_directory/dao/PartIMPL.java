package com.parts_directory.dao;

import com.parts_directory.entity.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PartIMPL implements PartDAO{

    private final EntityManager entityManager;

    @Autowired
    public PartIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Part> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Part> myQuery = currentSession.createQuery("from Part");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Part findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Part.class , theId);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Part thePart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thePart);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Part thePart = currentSession.get(Part.class, theId);
        currentSession.delete(thePart);
    }

}
