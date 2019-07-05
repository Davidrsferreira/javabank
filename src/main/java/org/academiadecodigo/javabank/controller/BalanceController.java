package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountHandler;
import org.academiadecodigo.javabank.view.BalanceView;

/**
 * The {@link BalanceView} controller
 */
public class BalanceController extends AbstractController {

    private AccountHandler accountHandler;

    public Customer getLoginCustomer() {
        return accountHandler.getLoginCustomer();
    }

    public void setAccountHandler(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }
}
