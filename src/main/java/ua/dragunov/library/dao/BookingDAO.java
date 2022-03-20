package ua.dragunov.library.dao;

import ua.dragunov.library.database.LibraryDataSource;
import ua.dragunov.library.model.Booking;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BookingDAO implements DatabaseExecutable<Booking>{
    private static final DataSource dataSource = LibraryDataSource.getLibraryDataSource();
    private static BookingDAO bookingDAO;
    private static final BookDAO bookDAO = BookDAO.getBookDAOInstance();
    private static final UserDAO userDAO = UserDAO.getUserDAOInstance();

    private BookingDAO(){};

    public static BookingDAO getBookingDAOInstance() {
        if(bookingDAO == null) {
            return bookingDAO = new BookingDAO();
        }

        return bookingDAO;
    }


    @Override
    public void create(Booking booking) {
        String sqlCreate = "INSERT INTO Booking(user_id, book_id, start_date, end_date) VALUES(?, ?, ?, ?)";

        try(Connection createConnection = dataSource.getConnection()) {
            PreparedStatement createStatement = createConnection.prepareStatement(sqlCreate);
            createStatement.setLong(1, booking.getUser().getId());
            createStatement.setLong(2, booking.getBook().getId());
            createStatement.setDate(3, Date.valueOf(booking.getStartBookingDate()));
            createStatement.setDate(4, Date.valueOf(booking.getEndBookingDate()));
            createStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Booking getById(long id) {
        Booking booking = new Booking();
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement getByIdStatement = connection
                    .prepareStatement("SELECT * FROM Booking WHERE id = ?");
            getByIdStatement.setLong(1, id);
            ResultSet resultSet = getByIdStatement.executeQuery();

            booking.setId(resultSet.getLong(1));
            booking.setUser(userDAO.getById(resultSet.getLong(2)));
            booking.setBook(bookDAO.getById(resultSet.getLong(3)));
            booking.setStartBookingDate(resultSet.getDate(4).toLocalDate());
            booking.setEndBookingDate(resultSet.getDate(5).toLocalDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    @Override
    public void update(Booking booking) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE booking SET user_id = ?, book_id = ?, start_date = ?" +
                            ", end_date = ? WHERE id = ?");
            updateStatement.setLong(1, booking.getUser().getId());
            updateStatement.setLong(2, booking.getBook().getId());
            updateStatement.setDate(3, Date.valueOf(booking.getStartBookingDate()));
            updateStatement.setDate(4, Date.valueOf(booking.getEndBookingDate()));
            updateStatement.setLong(5, booking.getId());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Booking booking) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE FROM Booking WHERE id = ?");
            deleteStatement.setLong(1, booking.getId());
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Booking> getAll() {
        return null;
    }
}
