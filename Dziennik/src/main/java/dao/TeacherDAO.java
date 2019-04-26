package dao;

import Modele.Teacher;
import hibernate.HibernateUtil;

import java.util.List;

public class TeacherDAO extends HibernateUtil implements DAO<Teacher>{
    @Override
    public Teacher findById(long teacherId) {
        Teacher teacher = (Teacher) getCurrentSession().get(Teacher.class, teacherId);
        return teacher;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = (List<Teacher>) getCurrentSession().createQuery("from Teacher").list();
        return teachers;
    }

    public void deleteById(long teacherId){
        Teacher teacher = (Teacher) getCurrentSession().get(Teacher.class,teacherId);
        getCurrentSession().delete(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        getCurrentSession().delete(teacher);
    }

    @Override
    public void persist(Teacher entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Teacher entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Teacher> entityList = findAll();
        for (Teacher entity : entityList) {
            delete(entity);
        }
    }
}
