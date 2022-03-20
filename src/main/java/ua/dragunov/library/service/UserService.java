package ua.dragunov.library.service;

import ua.dragunov.library.dao.UserDAO;
import ua.dragunov.library.model.User;

import java.util.List;

public class UserService implements LibraryService<User> {
    private static final UserDAO userDAO = UserDAO.getUserDAOInstance();

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        userDAO.deleteById(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }
}
