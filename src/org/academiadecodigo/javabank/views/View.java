package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controlers.Controller;

public abstract class View {

    private Controller controller;
    Prompt prompt;
    int userChoice;

    public abstract void show();

    public void setController(Controller controller){
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setPrompt(Prompt prompt){
        this.prompt = prompt;
    }
}
