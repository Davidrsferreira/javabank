package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthHandler;
import org.academiadecodigo.javabank.services.CustomerHandler;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for wiring the objects dependencies
 */
public class Bootstrap {

    /**
     * Creates a {@code Bank} and populates it with data
     *
     * @return the bank
     */
    public AuthHandler generateTestData() {

        CustomerHandler customerHandler = new CustomerHandler();
        AuthHandler authHandler = new AuthHandler(customerHandler);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        customerHandler.add(c1);
        customerHandler.add(c2);
        customerHandler.add(c3);

        return authHandler;
    }

    /**
     * Wires the necessary object dependencies
     *
     * @param authHandler the bank to wire
     * @return the login controller
     */
    public LoginController wireObjects(AuthHandler authHandler) {

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();

        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);
        loginController.setView(loginView);
        loginController.setService(authHandler);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();

        mainView.setMainController(mainController);
        mainView.setPrompt(prompt);
        mainView.setCustomerHandler(authHandler.getCustomerHandler());
        mainController.setView(mainView);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceController.setView(balanceView);
        //balanceView.setBank(bank);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
        //depositController.setBank(bank);
        depositController.setView(depositView);
        //withdrawalController.setBank(bank);
        withdrawalController.setView(withdrawView);
        //depositView.setBank(bank);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
        //withdrawView.setBank(bank);
        withdrawView.setPrompt(prompt);
        withdrawView.setTransactionController(withdrawalController);

        // setup the controller map
        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOption(), withdrawalController);

        mainController.setControllerMap(controllerMap);

        return loginController;
    }
}
