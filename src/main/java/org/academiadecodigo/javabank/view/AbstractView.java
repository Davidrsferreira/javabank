package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.services.CustomerHandler;

/**
 * A generic view to be used as a base for concrete view implementations
 * @see View
 */
public abstract class AbstractView implements View {

    protected Prompt prompt;
    protected CustomerHandler customerHandler;

    /**
     * Sets the prompt used for the UI
     *
     * @param prompt the prompt to set
     */
    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    /**
     * Sets the bank
     *
     * @param customerHandler the bank to set
     */
    public void setCustomerHandler(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }
}
