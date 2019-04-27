package Converters;

import Modele.Subject;
import modelFX.SubjectFx;

public class SubjectConventor {
    public static SubjectFx convertToSubjectFx(Subject subject){
        SubjectFx subjectFx = new SubjectFx();
        subjectFx.setSubjectId(subject.getSubjectId());
        subjectFx.setSubjectName(subject.getSubjectName());
        return subjectFx;
    }
}
