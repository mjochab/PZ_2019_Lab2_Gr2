package dao;


import Modele.Teacher;
import hibernate.SessionCreator;

import java.util.List;

public class TeacherDao  extends SessionCreator implements Dao<Teacher>{
    @Override
    public void persist(Teacher entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Teacher entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Teacher findById(long id) {
        return (Teacher) getCurrentSession().get(Teacher.class, id);
    }

    @Override
    public void delete(Teacher entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Teacher> findAll() {
        return (List<Teacher>) getCurrentSession().createQuery("from Teacher").list();
    }

    @Override
    public void deleteAll() {
        List<Teacher> teachers = findAll();
        teachers.forEach(this::delete);
    }

    @SuppressWarnings("unchecked")
    public List<Teacher> findAllStudentsInClass(long subjectId){
        List<Teacher> teachers = (List<Teacher>) getCurrentSession().createQuery("from Teacher where subject_id = "+subjectId).list();
        return teachers;
    }

}
