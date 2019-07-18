package org.academiadecodigo.javabank.persistence;

import javax.persistence.EntityManager;

public interface SessionManager {

    void startSession();

    void stopSession();

    EntityManager getCurrentSession();
}
