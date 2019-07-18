package org.academiadecodigo.javabank.persistence.dao;

public interface AccountDao {

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);
}
