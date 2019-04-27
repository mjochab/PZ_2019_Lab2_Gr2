package Converters;

import Modele.Student;
import modelFX.StudentFx;

public class StudentConverter {
    public static StudentFx convertToStudentFx(Student student){
        StudentFx studentFx = new StudentFx();
        studentFx.setFirstName(student.getFirstName());
        studentFx.setLastName(student.getLastName());
        studentFx.setPesel(student.getPesel());
        studentFx.setStudentId(student.getStudentId());
        studentFx.setLinkedAcc(student.getLinkedAcc());
        return studentFx;
    }
}
