package ua.dragunov.library.servlets;

import org.apache.log4j.Logger;
import ua.dragunov.library.model.Booking;
import ua.dragunov.library.model.User;
import ua.dragunov.library.service.BookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/profile"})
public class MainServlet extends HttpServlet {
    private static final BookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Booking> bookings = bookingService.getBookingByUser(user);
        req.setAttribute("user", user);
        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("user_page.jsp").forward(req, resp);
    }
}
