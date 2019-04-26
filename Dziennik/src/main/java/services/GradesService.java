package services;

import Modele.Grades;
import dao.GradesDAO;

import java.util.List;

public class GradesService {

    private static GradesDAO gradesDAO;

    public GradesService(){
        gradesDAO = new GradesDAO();
    }

    public GradesDAO gradesDAO(){
        return gradesDAO;
    }

    public List<Grades> findAllStudentGrades(long studentId){
        gradesDAO.openCurrentSession();
        List<Grades> gradesList = gradesDAO.findAll();
        gradesDAO.closeCurrentSession();
        return gradesList;
    }

    public void addGrade(Grades grade){
        gradesDAO.openCurrentSessionWithTransaction();
        gradesDAO.persist(grade);
        gradesDAO.closeCurrentSessionWithTransaction();
    }

    /*
    public List<Grades> findSpecificGrades(long studentId, long subjectId, String otherDetails){
        gradesDAO.openCurrentSession();
       List<Grades> gradesList = gradesDAO.findSpecificGrade(studentId, subjectId, otherDetails);
        gradesDAO.closeCurrentSession();
        return gradesList;
    }

    public List<Grades> findSpecificGrades(long studentId, long subjectId){
        gradesDAO.openCurrentSession();
        List<Grades> gradesList = gradesDAO.findSpecificGrade(studentId, subjectId);
        gradesDAO.closeCurrentSession();
        return gradesList;
    }
    */

/*    public double averageStudentSubjectGrade(long studentId, long subjectId){
        gradesDAO.openCurrentSession();
        double avgGrade = gradesDAO.averageStudentSubjectGrade(studentId, subjectId);
        gradesDAO.closeCurrentSession();
        return avgGrade;
    }*/
}
