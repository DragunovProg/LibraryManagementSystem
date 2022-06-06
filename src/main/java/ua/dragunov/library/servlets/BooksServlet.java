package ua.dragunov.library.servlets;

import ua.dragunov.library.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/books"})
public class BooksServlet extends HttpServlet {
    private static final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.getAll());
        req.getRequestDispatcher("books.jsp").forward(req, resp);
    }
}
