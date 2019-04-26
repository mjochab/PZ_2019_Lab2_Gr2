package dao;

import Modele.Warns;
import hibernate.HibernateUtil;

import java.util.List;

public class WarnsDAO extends HibernateUtil implements DAO<Warns>{
    @Override
    public Warns findById(long warnId) {
        Warns warns = (Warns) getCurrentSession().get(Warns.class, warnId);
        return warns;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Warns> findAll() {
        List<Warns> warns = (List<Warns>) getCurrentSession().createQuery("from Warns").list();
        return warns;
    }

    public void deleteById(long warnId){
        Warns warns = (Warns) getCurrentSession().get(Warns.class,warnId);
        getCurrentSession().delete(warns);
    }

    @Override
    public void delete(Warns warns) {
        getCurrentSession().delete(warns);
    }

    @Override
    public void persist(Warns entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Warns entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Warns> entityList = findAll();
        for (Warns entity : entityList) {
            delete(entity);
        }
    }
}
