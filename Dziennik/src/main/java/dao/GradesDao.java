package dao;

import Modele.Grades;
import hibernate.SessionCreator;

import java.util.List;

public class GradesDao extends SessionCreator implements Dao<Grades>{

    @Override
    public void persist(Grades entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Grades entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Grades findById(long id) {
        return (Grades) getCurrentSession().get(Grades.class, id);
    }

    @Override
    public void delete(Grades entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Grades> findAll() {
        return (List<Grades>) getCurrentSession().createQuery("from Grades").list();
    }

    @Override
    public void deleteAll() {
        List<Grades> students = findAll();
        students.forEach(this::delete);
    }

    @SuppressWarnings("unchecked")
    public List<Grades> findAllGradesForClass(long classId){
        List<Grades> grades = (List<Grades>) getCurrentSession().createQuery("from Grades where class_id = "+classId).list();
        return grades;
    }
}

