package Converters;

import Modele.Grades;
import modelFX.GradesFx;

public class GradaConverter {
    public static GradesFx convertToGradesFx(Grades grades){
        GradesFx gradesFx = new GradesFx();
        gradesFx.setData(grades.getData());
        gradesFx.setDetails(grades.getDetails());
        gradesFx.setGrade(grades.getGrade());
        gradesFx.setGradeID(grades.getGradeID());
        return gradesFx;
    }
}