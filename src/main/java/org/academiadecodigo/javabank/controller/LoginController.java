package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthHandler;
import org.academiadecodigo.javabank.view.LoginView;

/**
 * The {@link LoginView} controller
 */
public class LoginController extends AbstractController {

    private Controller nextController;

    private AuthHandler authHandler;

    /**
     * Sets the next controller
     *
     * @param nextController the next controller to be set
     */
    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    /**
     * Sets the service
     *
     * @param authHandler the authHandler to be set
     */
    public void setService(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    /**
     * Identifies the logged in customer
     *
     * @param id the customer id
     */
    public void onLogin(int id) {
        authHandler.setLoginCustomer(id);
        nextController.init();
    }

}
