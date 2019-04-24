package dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {

    void persist(T entity);


    void update(T entity);

    T findById(long id);

    void deleteById(long id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
