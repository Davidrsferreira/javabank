package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.controlers.Controller;
import org.academiadecodigo.javabank.controlers.LoginController;
import org.academiadecodigo.javabank.controlers.MainMenuController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.LoginView;
import org.academiadecodigo.javabank.views.MainMenuView;
import org.academiadecodigo.javabank.views.View;

public class App {

    public static void main(String[] args) {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);
        Prompt prompt = new Prompt(System.in, System.out);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        int customer = login(bank, prompt);

        int userChoise = 0;

        while (userChoise != UserOptions.QUIT.getOption()){
            userChoise = mainMenu(bank, prompt, customer);
        }

        //BankApplication bankApplication = new BankApplication(bank);
        //bankApplication.start();
    }

    private static int mainMenu(Bank bank, Prompt prompt, int customer) {

        Controller mainMenuController = new MainMenuController(bank, customer);
        View mainMenuView = new MainMenuView();

        mainMenuController.setView(mainMenuView);
        mainMenuController.setAccessingCustomerId(customer);
        mainMenuView.setController(mainMenuController);
        mainMenuView.setPrompt(prompt);

        mainMenuController.init();

        return mainMenuView.getUserChoice();

    }

    private static int login(Bank bank, Prompt prompt){

        Controller loginController = new LoginController(bank);
        View loginView = new LoginView();

        loginController.setView(loginView);
        loginView.setController(loginController);
        loginView.setPrompt(prompt);

        loginController.init();

        return loginController.getAccessingCustomerId();

    }
}
