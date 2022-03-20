package ua.dragunov.library.dao;

import org.apache.log4j.Logger;
import ua.dragunov.library.database.LibraryDataSource;
import ua.dragunov.library.model.Book;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for operation with database date from pgsql
 * using PGSimpleDataSource {@link LibraryDataSource} and
 * implements {@link DatabaseExecutable} interface
 * */

public class BookDAO implements DatabaseExecutable<Book> {
    private static final DataSource dataSource = LibraryDataSource.getLibraryDataSource();
    private static BookDAO bookDAOInstance;
    private static final Logger BOOK_DAO_LOGGER = Logger.getLogger(BookDAO.class);

    private BookDAO() {}

    /**
     * Singleton method to using the BookDao object once
     * */
    public static BookDAO getBookDAOInstance() {
        if(bookDAOInstance == null) {
            return bookDAOInstance = new BookDAO();
        }

        return bookDAOInstance;
    }

    /**
     * INSERT operation from sql , which will create record in database
     *
     * @param book
     * */
    @Override
    public void create(Book book) {
        String sqlCreate = "INSERT INTO Book(title, year, quantity, authors) VALUES(?, ?, ?, ?)";

        try(Connection createConnection = dataSource.getConnection()) {
            PreparedStatement createStatement = createConnection.prepareStatement(sqlCreate);
            createStatement.setString(1, book.getTitle());
            createStatement.setInt(2, book.getYear());
            createStatement.setInt(3, book.getQuantity());
            createStatement.setString(4, book.getAuthors());
            createStatement.executeUpdate();
        } catch (SQLException e) {
            //BOOK_DAO_LOGGER.info("BookDAO::create : ", e);
            e.printStackTrace();

        }
    }

    /**
     * SELECT operation to get record from database by his id
     *
     * @param id
     * @return
     * */
    @Override
    public Book getById(long id) {
        Book book = new Book();
        String selectSql = "SELECT * FROM Book WHERE id = ?";

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            book.setId(resultSet.getLong(1));
            book.setTitle(resultSet.getString(2));
            book.setYear(resultSet.getInt(3));
            book.setQuantity(resultSet.getInt(4));
            book.setAuthors(resultSet.getString(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public void update(Book book) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE book SET title = ?, year = ?, quantity = ?, authors = ?" +
                            "WHERE id = ?");
            updateStatement.setString(1, book.getTitle());
            updateStatement.setInt(2, book.getYear());
            updateStatement.setInt(3, book.getQuantity());
            updateStatement.setString(4, book.getAuthors());
            updateStatement.setLong(5, book.getId());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Book book) {
         try(Connection connection = dataSource.getConnection()) {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE FROM Book WHERE id = ?");
            deleteStatement.setLong(1, book.getId());
            deleteStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            Statement getAllStatement = connection.createStatement();
            ResultSet resultSet = getAllStatement.executeQuery("SELECT * FROM Book");

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong(1));
                book.setTitle(resultSet.getString(2));
                book.setYear(resultSet.getInt(3));
                book.setQuantity(resultSet.getInt(4));
                book.setAuthors(resultSet.getString(5));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return books;
    }

    public static void main(String[] args) {

    }
}
