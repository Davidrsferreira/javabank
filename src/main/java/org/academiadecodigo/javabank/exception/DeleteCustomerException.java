package org.academiadecodigo.javabank.exception;

public class DeleteCustomerException extends JavaBankException {

    public DeleteCustomerException(){
        super("Customer does not exist");
    }

    public DeleteCustomerException(String message){
        super(message);
    }
}
