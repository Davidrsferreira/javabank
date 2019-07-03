package org.academiadecodigo.javabank.controlers;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.views.View;

import java.util.Set;

public abstract class Controller {

    Bank bank;
    View view;

    public Controller(Bank bank){
        this.bank = bank;
    }

    public void init(){
        view.show();
    }

    public Set<Integer> getCustomerIds() {
        return bank.getCustomerIds();
    }

    public void setView(View view) {
        this.view = view;
    }
}
