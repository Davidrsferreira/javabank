package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.TransactionException;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.hibernate.HibernateException;

import javax.transaction.Transactional;
import java.util.List;

/**
 * A JPA {@link CustomerDao} implementation
 */
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaCustomerDao() {
        super(Customer.class);
    }

    /**
     * @see CustomerDao#getCustomerIds()
     */
    @Transactional
    public List<Integer> getCustomerIds() {
        try {

            return em.createQuery("select id from Customer", Integer.class)
                    .getResultList();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
