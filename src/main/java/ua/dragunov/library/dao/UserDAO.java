package ua.dragunov.library.dao;

import ua.dragunov.library.database.LibraryDataSource;
import ua.dragunov.library.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DatabaseExecutable<User>, UserGettable {
    private static final DataSource dataSource = LibraryDataSource.getLibraryDataSource();
    private static UserDAO userDAO;

    private UserDAO(){};

    public static UserDAO getUserDAOInstance() {
        if(userDAO == null) {
            return userDAO = new UserDAO();
        }

        return userDAO;
    }

    @Override
    public void create(User user) {
        String createSQL = "INSERT INTO users(login, email, password) VALUES(?, ?, ?)";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
        String getSQL = "SELECT * from users where id = ?";
        User user = new User();

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(getSQL);
            preparedStatement.setLong(1, id);
            ResultSet userResult = preparedStatement.executeQuery();
            userResult.next();

            user.setId(userResult.getLong(1));
            user.setLogin(userResult.getString(2));
            user.setEmail(userResult.getString(3));
            user.setPassword(userResult.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void update(User user) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE users SET login = ?, email = ?," +
                            " password = ? WHERE id = ?");

            updateStatement.setString(1, user.getLogin());
            updateStatement.setString(2, user.getEmail());
            updateStatement.setString(3, user.getPassword());
            updateStatement.setLong(4, user.getId());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(User user) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE FROM users WHERE id = ?");
            deleteStatement.setLong(1, user.getId());
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            Statement getAllStatement = connection.createStatement();
            ResultSet resultSet = getAllStatement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return users;
    }

    @Override
    public User getByEmail(String email) {
        String getSQL = "SELECT * from users where email = ?";
        User user = new User();

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(getSQL);
            preparedStatement.setString(1, user.getEmail());
            ResultSet userResult = preparedStatement.executeQuery();
            userResult.next();

            user.setId(userResult.getLong(1));
            user.setLogin(userResult.getString(2));
            user.setEmail(userResult.getString(3));
            user.setPassword(userResult.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getByLogin(String login) {
        String getSQL = "SELECT * from users where login = ?";
        User user = new User();

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(getSQL);
            preparedStatement.setString(1, user.getLogin());
            ResultSet userResult = preparedStatement.executeQuery();
            userResult.next();

            user.setId(userResult.getLong(1));
            user.setLogin(userResult.getString(2));
            user.setEmail(userResult.getString(3));
            user.setPassword(userResult.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
