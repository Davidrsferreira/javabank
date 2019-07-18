package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.persistence.JpaBootstrap;
import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.jpa.GenericJpaDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;

public class App {

    public static void main(String[] args) {

        JpaBootstrap jpa = new JpaBootstrap();

        App app = new App();
        app.bootStrap();

        jpa.stop();

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();

        GenericJpaDao accountDao = new JpaAccountDao();
        GenericJpaDao customerDao = new JpaCustomerDao();
        TransactionManager tm = new JpaTransactionManager();
        SessionManager sm = new JpaSessionManager();

        accountDao.setSm(sm);
        customerDao.setSm(sm);

        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl(accountDao, tm));
        bootstrap.setCustomerService(new CustomerServiceImpl(customerDao, tm));

        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();
    }
}
