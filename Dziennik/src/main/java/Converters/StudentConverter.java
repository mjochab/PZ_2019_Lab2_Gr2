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
        studentFx.setClassesFxObjectProperty(ClassConverter.convertToClassFx(student.getClasses()));
        return studentFx;
    }

    public static Student convertToStudent(StudentFx studentFx){
        Student student = new Student();
        student.setFirstName(studentFx.getFirstName());
        student.setLastName(studentFx.getLastName());
        student.setPesel(studentFx.getPesel());
        student.setStudentId(studentFx.getStudentId());
        student.setLinkedAcc(studentFx.getLinkedAcc());
        return student;
    }
}
