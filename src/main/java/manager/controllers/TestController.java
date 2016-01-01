package main.java.manager.controllers;

import main.java.manager.model.entities.Breed;
import main.java.manager.model.entities.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

/**
 * Created by nadeeshaan on 1/1/16.
 */
public class TestController {

    private static final String JBOSS_TM_CLASS_NAME = "javax.transaction.TransactionManager";

    public  void saveContent() throws Exception {
//        TransactionManager tm = getTransactionManager();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mongo-ogm");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Breed collie = new Breed();
        collie.setName("Collie2");
        em.persist(collie);
        Dog dina = new Dog();
        dina.setName("Dina2");
        dina.setBreed(collie);
        em.persist(dina);
        Long dinaId = dina.getId();
        em.getTransaction().commit();
        em.flush();
        em.close();
    }

    public static TransactionManager getTransactionManager() throws Exception {
        Class<?> tmClass = TestController.class.getClassLoader().loadClass(JBOSS_TM_CLASS_NAME);
        return (TransactionManager) tmClass.getMethod("transactionManager").invoke(null);
    }

    public static void main(String[] args) {
        TestController s = new TestController();
        try {
            s.saveContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
