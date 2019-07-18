package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.TransactionManager;

public class JpaTransactionManager implements TransactionManager {

    private JpaSessionManager sm;

    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }
        sm.stopSession();
    }

    @Override
    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }
        sm.stopSession();
    }
<<<<<<< HEAD

    public void setSm(JpaSessionManager sm) {
        this.sm = sm;
    }
=======
>>>>>>> 4d5eea15798a106a317f0b6b3c21f9136b49823f
}
