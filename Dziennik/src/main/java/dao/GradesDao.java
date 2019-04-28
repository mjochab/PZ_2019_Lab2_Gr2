package dao;

import Modele.Grades;
import hibernate.SessionCreator;

import java.util.List;

public class StudentDao  extends SessionCreator implements Dao<Grades>{
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
        List<Grades> grades = findAll();
        grades.forEach(this::delete);
    }

/*
    @SuppressWarnings("unchecked")
    public void deleteById(Student entity, Integer id){
        getCurrentSession().delete(entity,id);
    }
*/
}