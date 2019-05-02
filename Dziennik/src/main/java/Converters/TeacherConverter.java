package Converters;

import Modele.Teacher;
import modelFX.TeacherFx;

public class TeacherConverter {
    public static TeacherFx convertToTeacherFx(Teacher teacher){
        TeacherFx teacherFx = new TeacherFx();
        teacherFx.setFirstNameT(teacher.getFirstName());
        teacherFx.setLastNameT(teacher.getLastName());
        teacherFx.setLinkedAcc(teacher.getLinkedAcc());
        teacherFx.setTeacherId(teacher.getTeacherId());
        teacherFx.setSubjectFxObjectProperty(SubjectConverter.convertToSubjectFx(teacher.getSubject()));
        return teacherFx;
    }

    public static Teacher convertToTeacher(TeacherFx teacherFx){
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherFx.getFirstNameT());
        teacher.setLastName(teacherFx.getLastNameT());
        teacher.setTeacherId(teacherFx.getTeacherId());
        teacher.setLinkedAcc(teacherFx.getLinkedAcc());
        return teacher;
    }
}
