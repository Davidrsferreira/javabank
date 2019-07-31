package org.academiadecodigo.javabank.converters;

import org.academiadecodigo.javabank.exceptions.JavaBankException;

public interface Converter<S, T> {
    T convert(S toConvert) throws JavaBankException;
}
