package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.controlers.Controller;
import org.academiadecodigo.javabank.controlers.LoginController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.LoginView;
import org.academiadecodigo.javabank.views.View;

public class App {

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

        Controller loginController = new LoginController(bank);
        View loginView = new LoginView();
        Prompt prompt = new Prompt(System.in, System.out);

        loginController.setView(loginView);
        loginView.setController(loginController);
        loginView.setPrompt(prompt);

        loginController.init();




        BankApplication bankApplication = new BankApplication(bank);
        bankApplication.start();
    }
}
