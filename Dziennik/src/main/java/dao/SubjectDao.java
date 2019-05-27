package dao;

import Modele.Subject;
import hibernate.SessionCreator;

import java.util.List;

public class SubjectDao  extends SessionCreator implements Dao<Subject>{
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
        List<Subject> subjects = findAll();
        subjects.forEach(this::delete);
    }
    public long countSubject() {
        Long result = (Long) getCurrentSession().createQuery("SELECT count(*) FROM Subject").uniqueResult();
        if (result != null) {
            return result;
        } else {
            return 0;
        }
    }

}
