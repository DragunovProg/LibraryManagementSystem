package ua.dragunov.library.servlets;


import ua.dragunov.library.model.Booking;
import ua.dragunov.library.model.User;
import ua.dragunov.library.service.BookingService;
import ua.dragunov.library.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/"})
public class StartServlet extends HttpServlet {
    private static final UserService userService =  new UserService();

    private static boolean loginCheck(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        for (User user : userService.getAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("start_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (StartServlet.loginCheck(req)) {
            HttpSession userSession = req.getSession();
            userSession.setAttribute("user", userService.getByEmail(req.getParameter("email")));
            resp.sendRedirect("/profile");
        } else {
            req.setAttribute("error", "No found user");
            doGet(req, resp);
        }

    }
}
