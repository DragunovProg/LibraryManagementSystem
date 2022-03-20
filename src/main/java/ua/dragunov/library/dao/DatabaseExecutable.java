package ua.dragunov.library.dao;

import java.util.List;

public interface DatabaseExecutable<Entity>{
    void create(Entity entity);
    Entity getById(long id);
    void update(Entity entity);
    void deleteById(Entity entity);
    List<Entity> getAll();
}
