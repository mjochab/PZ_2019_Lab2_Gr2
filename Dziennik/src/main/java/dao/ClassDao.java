package dao;

import Modele.Classes;
import hibernate.SessionCreator;

import java.util.List;

public class ClassDao extends SessionCreator implements Dao<Classes> {

    @Override
    public void persist(Classes entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Classes entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Classes findById(long id) {
        return (Classes) getCurrentSession().get(Classes.class, id);
    }

    @Override
    public void delete(Classes entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Classes> findAll() {
        return (List<Classes>) getCurrentSession().createQuery("from Classes").list();
    }

    @Override
    public void deleteAll() {
        List<Classes> classesList = findAll();
        classesList.forEach(this::delete);
    }
}
