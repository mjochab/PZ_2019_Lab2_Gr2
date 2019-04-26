package services;

import Modele.Teacher;
import dao.TeacherDAO;

import java.util.List;

public class TeacherService {
    private static TeacherDAO teacherDAO;

    public TeacherService(){
        teacherDAO = new TeacherDAO();
    }
/*
    public List<Teacher> findAllStudentByClass(long classId){
        studentDAO.openCurrentSession();
        List<Student> students = studentDAO.findAllStudentsInClass(classId);
        studentDAO.closeCurrentSession();

        return students;
    }
*/
    public List<Teacher> findAll(){
        teacherDAO.openCurrentSession();
        List<Teacher> teachers = teacherDAO.findAll();
        teacherDAO.closeCurrentSession();

        return teachers;
    }

    public Teacher findById(long teacherId){
        teacherDAO.openCurrentSession();
        Teacher teacher = teacherDAO.findById(teacherId);
        teacherDAO.closeCurrentSession();

        return teacher;
    }

    public TeacherDAO teacherDao(){
        return teacherDAO;
    }
}
