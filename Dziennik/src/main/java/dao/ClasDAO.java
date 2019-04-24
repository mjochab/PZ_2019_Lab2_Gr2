package dao;

import Modele.Classes;
import sessions.SessionManager;

import java.util.List;

public class ClasDAO extends SessionManager implements DAO<Classes>{
    @Override
    public Classes findById(long classId) {
        Classes classes = (Classes) getCurrentSession().get(Classes.class, classId);
        return classes;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Classes> findAll() {
        List<Classes> classes = (List<Classes>) getCurrentSession().createQuery("from Classes").list();
        return classes;
    }

    public void deleteById(long clasId){
        Classes classes = (Classes) getCurrentSession().get(Classes.class,clasId);
        getCurrentSession().delete(classes);
    }

    @Override
    public void delete(Classes classes) {
        getCurrentSession().delete(classes);
    }

    @Override
    public void persist(Classes entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Classes entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Classes> entityList = findAll();
        for (Classes entity : entityList) {
            delete(entity);
        }
    }
}
