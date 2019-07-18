package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.AbstractModel;

import java.util.List;

public interface GenericDao<T extends AbstractModel> {

    /**
     * Gets a list of the model type
     *
     * @return the model list
     */
    List<T> findAll();

    /**
     * Gets the model
     *
     * @param id the model id
     * @return the model
     */
    T findById(Integer id);

    /**
     * Saves the model
     *
     * @param modelObject the model to be saved
     * @return the saved model
     */
    T saveOrUpdate(T modelObject);

    /**
     * Deletes a model
     *
     * @param id the id of the model to be deleted
     */
    void delete(Integer id);

}
