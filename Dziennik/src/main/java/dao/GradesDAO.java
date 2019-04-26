package dao;

import Modele.Grades;
import hibernate.HibernateUtil;

import java.util.List;

public class GradesDAO extends HibernateUtil implements DAO<Grades>{
    @Override
    public Grades findById(long gradeId) {
        Grades grades = (Grades) getCurrentSession().get(Grades.class, gradeId);
        return grades;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Grades> findAll() {
        List<Grades> grades = (List<Grades>) getCurrentSession().createQuery("from Grades").list();
        return grades;
    }

    public void deleteById(long gradeId){
        Grades grades = (Grades) getCurrentSession().get(Grades.class,gradeId);
        getCurrentSession().delete(grades);
    }

    @Override
    public void delete(Grades grades) {
        getCurrentSession().delete(grades);
    }

    @Override
    public void persist(Grades entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Grades entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Grades> entityList = findAll();
        for (Grades entity : entityList) {
            delete(entity);
        }
    }
}
