package Converters;

import Modele.Grades;
import modelFX.GradesFx;

public class GradesConventer {
    public static GradesFx convertToGradesFx(Grades grades){
        GradesFx gradesFx = new GradesFx();
        gradesFx.setGradeId(grades.getGradeId());
        gradesFx.setGrade(grades.getGrade());
        gradesFx.setDate(grades.getDateCreated());
        gradesFx.setDetails(grades.getDetails());
        gradesFx.setStudentObjectProperty(grades.getStudent());
        gradesFx.setSubjectObjectProperty(grades.getSubject());

        return gradesFx;
    }

    public static Grades convertToGrades(GradesFx gradesFx){
        Grades grades = new Grades();
        grades.setGradeId(gradesFx.getGradeId());
        grades.setGrade(gradesFx.getGrade());
        grades.setDateCreated(gradesFx.getDate());
        grades.setDetails(gradesFx.getDetails());
        grades.setStudent(gradesFx.getStudentObjectProperty());
        grades.setSubject(gradesFx.getSubjectObjectProperty());
        return grades;
    }
}
