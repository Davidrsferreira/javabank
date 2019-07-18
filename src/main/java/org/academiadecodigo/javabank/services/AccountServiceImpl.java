package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.jpa.GenericJpaDao;

public class AccountServiceImpl implements AccountService {

    private GenericJpaDao dao;
    private TransactionManager tm;

    public AccountServiceImpl(GenericJpaDao dao, TransactionManager tm){
        this.dao = dao;
        this.tm = tm;
    }

    @Override
    public void deposit(Integer id, double amount) {

    }

    @Override
    public void withdraw(Integer id, double amount) {

    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

    }
}
