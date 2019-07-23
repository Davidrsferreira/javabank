package org.academiadecodigo.javabank.servlets;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerDetails{

    @RequestMapping(method = RequestMethod.GET, value = "/customerdetails")
    public String sayHello(Model model) {

        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setEmail("davidrsferreira@gmail.com");

       model.addAttribute("customer", customer);

       return "customerDetails";

    }
}
