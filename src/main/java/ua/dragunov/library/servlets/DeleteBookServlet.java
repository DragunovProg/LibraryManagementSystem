package ua.dragunov.library.servlets;


import ua.dragunov.library.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteBook"})
public class DeleteBookServlet extends HttpServlet {
    private static final BookService bookService = new BookService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookService.delete(bookService.getById(Long.parseLong(req.getParameter("id"))));
        resp.sendRedirect(req.getContextPath() + "/books");
    }
}
