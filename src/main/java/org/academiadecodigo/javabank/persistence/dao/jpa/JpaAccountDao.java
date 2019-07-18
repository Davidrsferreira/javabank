package org.academiadecodigo.javabank.persistence.dao.jpa;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;

import javax.persistence.RollbackException;

public class JpaAccountDao extends GenericJpaDao<Account> implements AccountDao {

    @Override
    public void deposit(Integer id, double amount) {

        try {

            Account account = sm.getCurrentSession().find(Account.class, id);

            if (account == null) {
                throw new IllegalArgumentException("invalid account id");
            }

            account.credit(amount);

            } catch (RollbackException ex) {

        } finally {

            if (sm != null) {
                sm.stopSession();
            }
        }
    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {

            Account account = sm.getCurrentSession().find(Account.class, id);

            if (account == null) {
                throw new IllegalArgumentException("invalid account");
            }

            account.debit(amount);

        } catch (RollbackException ex) {

        } finally {

            if (sm != null) {
                sm.stopSession();
            }
        }
    }


    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

        try {

            Account srcAccount = sm.getCurrentSession().find(Account.class, srcId);
            Account dstAccount = sm.getCurrentSession().find(Account.class, dstId);

            if (srcAccount == null || dstAccount == null) {
                throw new IllegalArgumentException("invalid account id");
            }

            // make sure transaction can be performed
            if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
                srcAccount.debit(amount);
                dstAccount.credit(amount);
            }

        } catch (RollbackException ex) {

        } finally {

            if (sm != null) {
                sm.stopSession();
            }
        }
    }

=======
public class JpaAccountDao {
>>>>>>> 4d5eea15798a106a317f0b6b3c21f9136b49823f
}
