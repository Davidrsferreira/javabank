package org.academiadecodigo.javabank.servlets;

import org.academiadecodigo.javabank.persistence.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher request = getServletContext().getRequestDispatcher("/WEB-INF/customerDetails.jsp");

        Customer customer = new Customer();
        customer.setFirstName("David");
        customer.setEmail("davidrsferreira@gmail.com");

        req.setAttribute("customer", customer);
        request.forward(req, resp);

    }
}
