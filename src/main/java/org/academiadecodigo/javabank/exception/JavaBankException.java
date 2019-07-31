package org.academiadecodigo.javabank.exception;

public class JavaBankException extends Exception{

    public JavaBankException(){
        super("Javabank exception");
    }

    public JavaBankException(String s){
        super(s);
    }
}
