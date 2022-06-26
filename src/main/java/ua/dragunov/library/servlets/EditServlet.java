package ua.dragunov.library.servlets;

import ua.dragunov.library.model.Booking;
import ua.dragunov.library.service.BookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {
    private static final BookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Booking booking = bookingService.getById(Long.parseLong(req.getParameter("id")));

        req.setAttribute("booking", booking);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Booking booking = bookingService.getById(Long.parseLong(req.getParameter("id")));


    }
}
