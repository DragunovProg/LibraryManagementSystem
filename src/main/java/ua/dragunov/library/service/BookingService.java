package ua.dragunov.library.service;

import ua.dragunov.library.dao.BookDAO;
import ua.dragunov.library.dao.BookingDAO;
import ua.dragunov.library.dao.UserDAO;
import ua.dragunov.library.logic.LibraryController;
import ua.dragunov.library.model.Book;
import ua.dragunov.library.model.Booking;
import ua.dragunov.library.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BookingService implements LibraryService<Booking> {
    private static final BookingDAO bookingDAO = BookingDAO.getBookingDAOInstance();
    private static final BookDAO bookDAO = BookDAO.getBookDAOInstance();


    @Override
    public void create(Booking booking) {

        if (bookExist(booking.getBook())) {
            bookingDAO.create(booking);

            Book book = booking.getBook();
            book.setQuantity(book.getQuantity() - 1);
            bookDAO.update(book);
        }
    }

    private boolean bookExist(Book book) {
        return book.getQuantity() != 0;
    }

    @Override
    public Booking getById(long id) {
        return bookingDAO.getById(id);
    }

    @Override
    public void update(Booking booking) {
        bookingDAO.update(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingDAO.deleteById(booking);
    }

    @Override
    public List<Booking> getAll() {
        return bookingDAO.getAll();
    }

    public List<Booking> getBookingByUser(User user) {
        return bookingDAO.getAll().stream()
                .filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

    }
}
