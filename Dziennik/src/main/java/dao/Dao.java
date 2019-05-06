package dao;

import java.util.List;

public interface Dao <T> {
    void persist(T entity);

    void update(T entity);

    T findById(long id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
