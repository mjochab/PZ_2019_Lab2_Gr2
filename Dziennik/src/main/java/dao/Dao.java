package dao;

import java.io.Serializable;
import java.util.Set;

public interface Dao <T extends Serializable> {
    void persist(T entity);

    void update(T entity);

    T findById(long id);

    void delete(T entity);

    Set<T> findAll();

    void deleteAll();
}
