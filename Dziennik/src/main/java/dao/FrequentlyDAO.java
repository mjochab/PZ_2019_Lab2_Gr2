package dao;

import Modele.Frequently;
import sessions.SessionManager;

import java.util.List;

public class FrequentlyDAO extends SessionManager implements DAO<Frequently> {
    @Override
    public Frequently findById(long frequentlyId) {
        Frequently frequently = (Frequently) getCurrentSession().get(Frequently.class, frequentlyId);
        return frequently;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Frequently> findAll() {
        List<Frequently> frequently = (List<Frequently>) getCurrentSession().createQuery("from Frequently").list();
        return frequently;
    }

    public void deleteById(long frequentlyId){
        Frequently frequently = (Frequently) getCurrentSession().get(Frequently.class,frequentlyId);
        getCurrentSession().delete(frequently);
    }

    @Override
    public void delete(Frequently frequently) {
        getCurrentSession().delete(frequently);
    }

    @Override
    public void persist(Frequently entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Frequently entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Frequently> entityList = findAll();
        for (Frequently entity : entityList) {
            delete(entity);
        }
    }
}
