package ua.dragunov.library.service;

import ua.dragunov.library.dao.BookingDAO;
import ua.dragunov.library.model.Booking;

import java.util.List;

public class BookingService implements LibraryService<Booking> {
    private static final BookingDAO bookingDAO = BookingDAO.getBookingDAOInstance();

    @Override
    public void create(Booking booking) {
        bookingDAO.create(booking);
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
}
