package org.academiadecodigo.javabank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // respond with an http 400
    @ExceptionHandler(value = JavaBankException.class) // user did something wrong
    public ModelAndView handleClientErrors(HttpServletRequest req, JavaBankException ex) {

        ModelAndView model = new ModelAndView();

        model.addObject("error", ex.getMessage());
        model.setViewName("error");

        return model;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // respond with an http 500
    @ExceptionHandler(value = Exception.class) // something is wrong with the server
    public ModelAndView handleServerErrors(HttpServletRequest req, Exception ex) {

        ModelAndView model = new ModelAndView();

        // add error info to the model
        model.setViewName("error");
        return model;
    }
}
