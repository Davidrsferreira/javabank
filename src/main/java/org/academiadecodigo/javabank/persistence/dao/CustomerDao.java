package org.academiadecodigo.javabank.persistence.dao;

import java.util.Set;

public interface CustomerDao {

    double getBalance(Integer id);

    Set<Integer> listCustomerAccountIds(Integer id);

}
