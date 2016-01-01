package main.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;

@Stateless

public class PropertyManager {

    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;


    public void save(Property p) {
        em.persist(p);

    }

    public List<Property> queryCache() {
        Query query = em.createQuery("FROM Property p");

        List<Property> list = query.getResultList();
        return list;
    }

}
