package dao;

import Modele.User;
import hibernate.SessionCreator;

import java.util.List;

public class UserDao extends SessionCreator implements Dao<User>{
    @Override
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public User findById(long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void deleteAll() {
        List<User> users = findAll();
        users.forEach(this::delete);
    }
}
