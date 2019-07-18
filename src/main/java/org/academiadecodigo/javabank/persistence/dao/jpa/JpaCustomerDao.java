package org.academiadecodigo.javabank.persistence.dao.jpa;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    @Override
    public double getBalance(Integer id) {

        try {

            Customer customer = sm.getCurrentSession().find(Customer.class, id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            double balance = 0;
            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;

        } finally {
            if (sm != null) {
                sm.stopSession();
            }
        }
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        try {

            Set<Integer> accountIds = new HashSet<>();

            Customer customer = sm.getCurrentSession().find(Customer.class, id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            return accountIds;

        } finally {
            if (sm != null) {
                sm.stopSession();
            }
        }
    }

=======
public class JpaCustomerDao {
>>>>>>> 4d5eea15798a106a317f0b6b3c21f9136b49823f
}
