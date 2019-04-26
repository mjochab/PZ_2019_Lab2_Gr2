package services;

import Modele.Student;
import dao.StudentDAO;

import java.util.List;

public class StudentService {

    private static StudentDAO studentDAO;

    public StudentService(){
        studentDAO = new StudentDAO();
    }

    public List<Student> findAllStudentByClass(long classId){
        studentDAO.openCurrentSession();
        List<Student> students = studentDAO.findAllStudentsInClass(classId);
        studentDAO.closeCurrentSession();

        return students;
    }

    public List<Student> findAllStudents(){
        studentDAO.openCurrentSession();
        List<Student> students = studentDAO.findAll();
        studentDAO.closeCurrentSession();

        return students;
    }

    public Student findById(long id){
        studentDAO.openCurrentSession();
        Student student = studentDAO.findById(id);
        studentDAO.closeCurrentSession();

        return student;
    }

    public void persist(Student entity){
        studentDAO.openCurrentSessionWithTransaction();
        studentDAO.persist(entity);
        studentDAO.closeCurrentSessionWithTransaction();
    }


    public StudentDAO studentDao(){
        return studentDAO;
    }
}
