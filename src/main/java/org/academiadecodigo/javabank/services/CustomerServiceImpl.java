package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.jpa.GenericJpaDao;

import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private GenericJpaDao dao;
    private TransactionManager tm;

    public CustomerServiceImpl(GenericJpaDao dao, TransactionManager tm){
        this.dao = dao;
        this.tm = tm;
    }

    @Override
    public double getBalance(Integer id) {

        tm.beginRead();
        dao.findById(id);
        return 0.0;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }
}
