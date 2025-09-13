package com.example.servlets;



import com.example.dao.Userdao;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private Userdao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new Userdao(); // servlet init
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDao.getAllUsers();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Users</h1>");
        out.println("<ul>");
        for(User u : users) {
            out.println("<li>" + u.getName() + " (" + u.getEmail() + ")</li>");
        }
        out.println("</ul>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if(name != null && email != null) {
            userDao.addUser(new User(0, name, email));
        }
        response.sendRedirect("users");
    }

    @Override
    public void destroy() {
        // cleanup if needed
    }
}

