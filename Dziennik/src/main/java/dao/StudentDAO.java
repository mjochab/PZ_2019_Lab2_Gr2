package dao;

import Modele.Student;
import hibernate.HibernateUtil;

import java.util.List;

public class StudentDAO extends HibernateUtil implements DAO<Student>{
    HibernateUtil hibernateUtil;
    public StudentDAO() {
    }

    @Override
    public Student findById(long studentId) {
        Student student = (Student) getCurrentSession().get(Student.class, studentId);
        return student;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findAll() {
        List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
        return students;
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAllStudentsInClass(long classId){
        List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student where class_id = "+classId).list();
        return students;
    }

    public void deleteById(long studentId){
        Student student = (Student) getCurrentSession().get(Student.class,studentId);
        getCurrentSession().delete(student);
    }
/*
    public void deleteByColumnName(String columName, int id) {
        CriteriaBuilder cb =
                CriteriaDelete
        DeleteBuilder<Student, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columName, id);
        dao.delete(deleteBuilder.prepare());
    }
*/
    @Override
    public void delete(Student student) {
        getCurrentSession().delete(student);
    }

    @Override
    public void persist(Student entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Student entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Student> entityList = findAll();
        for (Student entity : entityList) {
            delete(entity);
        }
    }
}
