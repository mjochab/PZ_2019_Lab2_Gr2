package dao;

import Modele.Student;
import hibernate.SessionCreator;

import java.util.List;

public class StudentDao  extends SessionCreator implements Dao<Student>{
    @Override
    public void persist(Student entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Student entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Student findById(long id) {
        return (Student) getCurrentSession().get(Student.class, id);
    }

    @Override
    public void delete(Student entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        return (List<Student>) getCurrentSession().createQuery("from Student").list();
    }

    @Override
    public void deleteAll() {
        List<Student> students = findAll();
        students.forEach(this::delete);
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAllStudentsInClass(long classId){
        List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student where class_id = "+classId).list();
        return students;
    }

}
