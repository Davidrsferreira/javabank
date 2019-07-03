package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Messages;

public class LoginView extends View{

    @Override
    public void show() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(super.getController().getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        userChoice = prompt.getUserInput(scanner);
        getController().setAccessingCustomerId(userChoice);

    }

}
