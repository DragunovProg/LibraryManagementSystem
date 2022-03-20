package ua.dragunov.library.dao;

import ua.dragunov.library.model.User;

public interface UserGettable {
    User getByEmail(String email);
    User getByLogin(String login);
}
