package dao;

import Modele.Warns;
import hibernate.SessionCreator;

import java.util.List;

public class WarnsDao  extends SessionCreator implements Dao<Warns>{
    
    @Override
    public void persist(Warns entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Warns entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Warns findById(long id) {
        return (Warns) getCurrentSession().get(Warns.class, id);
    }

    @Override
    public void delete(Warns entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Warns> findAll() {
        return (List<Warns>) getCurrentSession().createQuery("from Warns").list();
    }

    @Override
    public void deleteAll() {
        List<Warns> Warnss = findAll();
        Warnss.forEach(this::delete);
    }

    @SuppressWarnings("unchecked")
    public List<Warns> findAllWarnssForStudent(long studentId){
        List<Warns> Warnss = (List<Warns>) getCurrentSession().createQuery("from Warns where student_id = "+studentId).list();
        return Warnss;
    }



}
