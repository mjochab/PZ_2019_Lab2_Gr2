package dao;

import Modele.Classes;
import hibernate.HibernateUtil;

import java.util.Set;

public class ClassDao extends HibernateUtil implements Dao<Classes> {

    protected HibernateUtil hibernateUtil;



    public ClassDao() {

    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Classes> findAll() {
        Set<Classes>  classes = (Set<Classes>) getCurrentSession().createQuery("from Classes").list();
        return classes;
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
    public Classes findById(long id) {
        Classes classes =(Classes) getCurrentSession().get(Classes.class, id);
        return classes;
    }

    @Override
    public void deleteAll() {
        Set<Classes> entityList = findAll();
        for (Classes entity : entityList) {
            delete(entity);
        }
    }
}
