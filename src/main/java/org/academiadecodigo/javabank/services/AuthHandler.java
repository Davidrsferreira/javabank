package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthHandler implements AuthService{

    CustomerHandler customerHandler;

    public AuthHandler(CustomerHandler customerHandler){
        this.customerHandler = customerHandler;
    }

    @Override
    public boolean authenticate(Integer id) {

        Customer customer = customerHandler.get(id);

        if (customer!= null){
            customerHandler.setLoginCustomer(id);
            return true;
        }

        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return customerHandler.getLoginCustomer();
    }

    public void setLoginCustomer(int id) {
        customerHandler.setLoginCustomer(id);
    }
}
