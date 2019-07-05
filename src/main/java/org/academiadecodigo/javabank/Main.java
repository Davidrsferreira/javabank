package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();

        loginView.setLoginController(loginController);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);
        loginController.setView(loginView);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();

        mainView.setPrompt(prompt);
        mainView.setMainController(mainController);
        mainController.setView(mainView);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceController.setView(balanceView);
        balanceView.setBank(bank);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();

        //newAccountController.setAccountHandler(a);
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

        // start application
        loginController.init();
    }
}
