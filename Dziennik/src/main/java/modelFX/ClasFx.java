package modelFX;

import javafx.beans.property.*;

public class ClasFx {

    private LongProperty classId = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<SubjectFx> subjectFx = new SimpleObjectProperty<>();
    private ObjectProperty<StudentFx> studentFx = new SimpleObjectProperty<>();
    private ObjectProperty<ScheduleFx> scheduleFx = new SimpleObjectProperty<>();

    public long getClassId() {
        return classId.get();
    }

    public LongProperty classIdProperty() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId.set(classId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SubjectFx getSubjectFx() {
        return subjectFx.get();
    }

    public ObjectProperty<SubjectFx> subjectFxProperty() {
        return subjectFx;
    }

    public void setSubjectFx(SubjectFx subjectFx) {
        this.subjectFx.set(subjectFx);
    }

    public StudentFx getStudentFx() {
        return studentFx.get();
    }

    public ObjectProperty<StudentFx> studentFxProperty() {
        return studentFx;
    }

    public void setStudentFx(StudentFx studentFx) {
        this.studentFx.set(studentFx);
    }

    public ScheduleFx getScheduleFx() {
        return scheduleFx.get();
    }

    public ObjectProperty<ScheduleFx> scheduleFxProperty() {
        return scheduleFx;
    }

    public void setScheduleFx(ScheduleFx scheduleFx) {
        this.scheduleFx.set(scheduleFx);
    }

    @Override
    public String toString() {
        return "ClasFx{" +
                "classId=" + classId +
                ", name=" + name +
                ", subjectFx=" + subjectFx +
                ", studentFx=" + studentFx +
                ", scheduleFx=" + scheduleFx +
                '}';
    }
}
