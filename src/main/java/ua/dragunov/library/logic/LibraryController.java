package ua.dragunov.library.logic;

import ua.dragunov.library.dao.BookDAO;
import ua.dragunov.library.dao.BookingDAO;
import ua.dragunov.library.model.Book;
import ua.dragunov.library.model.Booking;

import java.time.LocalDate;
import java.util.List;


public class LibraryController {
    private static final BookDAO bookDAO = BookDAO.getBookDAOInstance();
    private static final BookingDAO bookingDAO = BookingDAO.getBookingDAOInstance();


    public void bookQuantityActualization() {
        List<Booking> bookings = bookingDAO.getAll();

        for (Booking booking: bookings) {
            if (booking.getEndBookingDate().isBefore(LocalDate.now())) {
                Book book = booking.getBook();
                book.setQuantity(book.getQuantity() + 1);

                bookDAO.update(book);
            }
        }

    }


}
