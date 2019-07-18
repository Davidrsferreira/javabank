package org.academiadecodigo.javabank.persistence;

import javax.persistence.EntityManager;

public interface SessionManager {

    void startSession();

    void stopSession();

    EntityManager getCurrentSession();
<<<<<<< HEAD
=======

>>>>>>> 4d5eea15798a106a317f0b6b3c21f9136b49823f
}
