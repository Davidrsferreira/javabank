package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.dao.GenericDao;
import org.academiadecodigo.javabank.services.CRUDService;

import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends AbstractModel>  implements GenericDao<T> {

    SessionManager sm;
    private Class<T> modelType;

    /**
     * @see CRUDService#list()
     */
    @Override
    public List<T> findAll() {

        try {

            CriteriaQuery<T> criteriaQuery = sm.getCurrentSession().getCriteriaBuilder().createQuery(modelType);
            Root<T> root = criteriaQuery.from(modelType);
            return sm.getCurrentSession().createQuery(criteriaQuery).getResultList();

        } finally {
            if (sm != null) {
                sm.stopSession();
            }
        }
    }

    /**
     * @see CRUDService#get(Integer)
     */
    @Override
    public T findById(Integer id) {

        try {

            return sm.getCurrentSession().find(modelType, id);

        } finally {
            if (sm != null) {
                sm.stopSession();
            }
        }
    }

    /**
     * @see CRUDService#save(AbstractModel)
     */
    @Override
    public T saveOrUpdate(T modelObject) {

        try {

            return sm.getCurrentSession().merge(modelObject);

        } catch (RollbackException ex) {

            sm.getCurrentSession().getTransaction().rollback();
            return null;

        } finally {
            if (sm != null) {
                sm.stopSession();
            }
        }
    }

    /**
     * @see CRUDService#delete(Integer)
     */
    @Override
    public void delete(Integer id) {

        try {

            sm.getCurrentSession().remove(sm.getCurrentSession().find(modelType, id));

        } catch (RollbackException ex) {

            sm.getCurrentSession().getTransaction().rollback();

        } finally {
            if (sm != null) {
                sm.stopSession();
            }
        }
    }

    public void setSm(SessionManager sm) {
        this.sm = sm;
    }
}
