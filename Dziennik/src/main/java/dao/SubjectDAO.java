package dao;

import Modele.Subject;
import hibernate.HibernateUtil;

import java.util.List;

public class SubjectDAO extends HibernateUtil implements DAO<Subject>{

    @Override
    public void persist(Subject entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Subject entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Subject findById(long id) {
        return (Subject) getCurrentSession().get(Subject.class, id);
    }

    @Override
    public void delete(Subject entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subject> findAll() {
        return (List<Subject>) getCurrentSession().createQuery("from Subject").list();
    }

    @Override
    public void deleteAll() {
        List<Subject> subjectList = findAll();
        subjectList.forEach(this::delete);
    }
    public void deleteById(long subjectId){
        Subject subject = (Subject) getCurrentSession().get(Subject.class,subjectId);
        getCurrentSession().delete(subject);
    }
}
