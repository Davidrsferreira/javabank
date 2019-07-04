package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

import java.util.*;

public class CustomerHandler implements CustomerService{

    private Map<Integer, Customer> customers;

    int accessingCustomer;

    public CustomerHandler(){
        customers = new HashMap<>();
    }

    @Override
    public Customer get(Integer id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> list() {

        ArrayList<Customer> customerList = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++){

            customerList.add(customers.get(i));
        }

        return customerList;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return customers.get(id).getAccountIds();
    }

    @Override
    public double getBalance(int customerId) {
        return customers.get(customerId).getBalance();
    }

    @Override
    public void add(Customer customer) {
        customers.put(customers.size() + 1, customer);
    }

    public Customer getLoginCustomer() {
        return customers.get(accessingCustomer);
    }

    public void setLoginCustomer(int id) {
        this.accessingCustomer = id;
    }
}
