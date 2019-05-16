package dao;

import Modele.Frequently;
import hibernate.SessionCreator;

import java.util.List;

public class FrequentlyDao extends SessionCreator implements Dao<Frequently>{

    @Override
    public void persist(Frequently entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Frequently entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Frequently findById(long id) {
        return (Frequently) getCurrentSession().get(Frequently.class, id);
    }

    @Override
    public void delete(Frequently entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Frequently> findAll() {
        return (List<Frequently>) getCurrentSession().createQuery("from Frequently").list();
    }

    @Override
    public void deleteAll() {
        List<Frequently> students = findAll();
        students.forEach(this::delete);
    }

    @SuppressWarnings("unchecked")
    public List<Frequently> findAllFrequentlyForStudent(long studentId){
        List<Frequently> frequently = (List<Frequently>) getCurrentSession().createQuery("from Frequently where student_id = "+studentId).list();
        return frequently;
    }

    @SuppressWarnings("unchecked")
    public long countAbsence(long studentId){
       Long result = (Long) getCurrentSession().createQuery( "SELECT SUM(absence) FROM Frequently where student_id ="+studentId).uniqueResult();
       return result;
    }
}