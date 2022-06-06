package ua.dragunov.library.service;

import ua.dragunov.library.dao.BookDAO;
import ua.dragunov.library.model.Book;

import java.util.List;

public class BookService implements LibraryService<Book>{
    private static final BookDAO bookDAO = BookDAO.getBookDAOInstance();

    @Override
    public void create(Book book) {
        bookDAO.create(book);
    }

    @Override
    public Book getById(long id) {
        return bookDAO.getById(id);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public void delete(Book book) {
        bookDAO.deleteById(book);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    public static void main(String[] args) {
        new BookService().delete(BookDAO.getBookDAOInstance().getById(3));
    }
}
