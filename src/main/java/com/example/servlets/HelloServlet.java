package com.example.servlets;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Hello Servlet");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>Hello from Servlet!</h1>");


    }
}
