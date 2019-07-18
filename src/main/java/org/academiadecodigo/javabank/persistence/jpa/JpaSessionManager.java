package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaSessionManager implements SessionManager {

    private EntityManagerFactory emf; // the persistence unit
    private EntityManager em; // the persistence context

<<<<<<< HEAD
=======
    public JpaSessionManager(EntityManagerFactory emf){
        this.emf = emf;
    }

>>>>>>> 4d5eea15798a106a317f0b6b3c21f9136b49823f
    @Override
    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    @Override
    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}
