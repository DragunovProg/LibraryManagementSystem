package ua.dragunov.library.service;

import java.util.List;

public interface LibraryService<T> {

    void create(T entity);

    T getById(long id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();
}
