package org.academiadecodigo.javabank.menu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Menu {

    private final Prompt prompt;

    public Menu(){
        prompt = new Prompt(System.in, System.out);
    }

    public void start(){

      while(!login()){
          continue;
      }

    }

    private boolean login() {

        StringInputScanner customer = new StringInputScanner();
        customer.setMessage("Please, enter the customer id: ");

        String response = prompt.getUserInput(customer);

        return false;
    }
}
