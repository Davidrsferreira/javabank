package org.academiadecodigo.javabank.converters;

import org.academiadecodigo.javabank.exceptions.CustomerNotFoundException;
import org.academiadecodigo.javabank.exceptions.JavaBankException;
import org.academiadecodigo.javabank.exceptions.RecipientNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic converter to be used as a base for concrete converter implementations
 * @param <S> the source type
 * @param <T> the target type
 */
public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    /**
     * Converts the source list of type S to target type T
     *
     * @param listToConvert the list to convert
     * @return the list of converted elements
     */
    public List<T> convert(List<S> listToConvert) throws JavaBankException {

        List<T> conversions = new ArrayList<>(listToConvert.size());

        for (S toConvert : listToConvert) {
            conversions.add(convert(toConvert));
        }

        return conversions;
    }

}
