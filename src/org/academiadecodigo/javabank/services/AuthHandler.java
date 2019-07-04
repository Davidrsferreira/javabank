package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthHandler implements AuthService{

    CustomerHandler customerHandler;
    Customer accessingCustomer;

    public AuthHandler(CustomerHandler customerHandler){
        this.customerHandler = customerHandler;
    }

    @Override
    public boolean authenticate(Integer id) {

        accessingCustomer = customerHandler.get(id);

        if (accessingCustomer!= null){
            return true;
        }

        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return accessingCustomer;
    }
}
