package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.controlers.Controller;
import org.academiadecodigo.javabank.domain.Customer;

/**
 * A generic bank operation to be used as a base for concrete types of bank operations
 * @see Operation
 */
public abstract class AbstractBankOperation implements Operation {

    protected Controller controller;
    protected Customer customer;

    /**
     * Initializes a new {@code AbstractBankOperation} given a bank application
     *
     * @param controller the bank application
     */
    public AbstractBankOperation(Controller controller) {
        this.controller = controller;
        customer = controller.getBank().getCustomer(controller.getAccessingCustomerId());
    }
}
