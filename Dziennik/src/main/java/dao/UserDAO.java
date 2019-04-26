package dao;

import Modele.User;
import hibernate.HibernateUtil;

import java.util.List;

public class UserDAO extends HibernateUtil implements DAO<User>{
    @Override
    public User findById(long userId) {
        User user = (User) getCurrentSession().get(User.class, userId);
        return user;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) getCurrentSession().createQuery("from User").list();
        return users;
    }

    public void deleteById(long userId){
        User user = (User) getCurrentSession().get(User.class,userId);
        getCurrentSession().delete(user);
    }

    @Override
    public void delete(User user) {
        getCurrentSession().delete(user);
    }

    @Override
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<User> entityList = findAll();
        for (User entity : entityList) {
            delete(entity);
        }
    }
}
