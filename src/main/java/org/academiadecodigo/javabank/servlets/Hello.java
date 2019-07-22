package org.academiadecodigo.javabank.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Hello World Page</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Hello World</h1>");
        pw.println("</body>");
        pw.println("</html>");

    }

}
