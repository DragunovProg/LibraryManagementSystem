package ua.dragunov.library.servlets;

import ua.dragunov.library.dao.UserDAO;
import ua.dragunov.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user  = UserDAO.getUserDAOInstance().getById(1);

        req.setAttribute("user", user);
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
