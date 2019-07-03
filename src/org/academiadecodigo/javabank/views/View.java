package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controlers.Controller;

public abstract class View {

    private Controller controller;
    private Prompt prompt;
    int option;

    public abstract void show();

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public Controller getController() {
        return controller;
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public int getOption() {
        return option;
    }
}
