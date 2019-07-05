package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountHandler;
import org.academiadecodigo.javabank.view.NewAccountView;

/**
 * The {@link NewAccountView} controller
 */
public class NewAccountController extends AbstractController {

    private AccountHandler accountHandler;
    private Integer newAccountId;

    public NewAccountController(){
        accountHandler = new AccountHandler();
    }

    /**
     * Sets the accountHandler
     *
     * @param accountHandler the bank to set
     */
    public void setAccountHandler(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    /**
     * Gets the new account id
     *
     * @return the new account id
     */
    public Integer getNewAccountId() {
        return newAccountId;
    }

    /**
     * Creates a new {@link Account}
     *
     * @see Controller#init()
     * @see AccountManager#openAccount(AccountType)
     */
    @Override
    public void init() {

        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {
        return accountHandler.createAccount(AccountType.CHECKING);
    }
}
