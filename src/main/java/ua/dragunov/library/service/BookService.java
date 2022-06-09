package ua.dragunov.library.service;

import ua.dragunov.library.dao.BookDAO;
import ua.dragunov.library.model.Book;
import ua.dragunov.library.model.Booking;
import ua.dragunov.library.model.User;

import java.util.List;
import java.util.stream.Collectors;

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

    private static final BookingService bookingService = new BookingService();

    private static List<Booking> getBookingOfCurrentUser(User user) {
        return bookingService.getAll().stream()
                .filter(booking -> booking.getUser().getId() == user.getId())
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        User user = new UserService().getById(1);
        System.out.println(BookService.getBookingOfCurrentUser(user));
    }
}
