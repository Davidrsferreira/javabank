package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.services.AuthHandler;
import org.academiadecodigo.javabank.services.CustomerHandler;
import org.academiadecodigo.javabank.services.CustomerService;

public class App {

    private AuthHandler authHandler;

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        authHandler = bootstrap.generateTestData();

        LoginController loginController = bootstrap.wireObjects(authHandler);

        // start application
        loginController.init();
    }
}
