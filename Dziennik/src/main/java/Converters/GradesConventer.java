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
        gradesFx.setStudentObjectProperty(StudentConverter.convertToStudentFx(grades.getStudent()));
        gradesFx.setSubjectFxObjectProperty(SubjectConverter.convertToSubjectFx(grades.getSubject()));

        return gradesFx;
    }

    public static Grades convertToGrades(GradesFx gradesFx){
        Grades grades = new Grades();
        grades.setGradeId(gradesFx.getGradeId());
        grades.setGrade(gradesFx.getGrade());
        grades.setDateCreated(gradesFx.getDate());
        grades.setDetails(gradesFx.getDetails());
        grades.setStudent(gradesFx.getStudentObjectProperty());
        grades.setSubject(gradesFx.getSubjectFxObjectProperty());
        return grades;
    }
}
