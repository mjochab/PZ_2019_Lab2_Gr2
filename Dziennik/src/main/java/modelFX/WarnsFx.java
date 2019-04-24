package modelFX;

import javafx.beans.property.*;

import java.time.LocalDate;

public class WarnsFx {
    private LongProperty warnId = new SimpleLongProperty();
    private ObjectProperty<LocalDate> dateCreated = new SimpleObjectProperty<>();
    private StringProperty content = new SimpleStringProperty();
    private ObjectProperty<StudentFx> studentFx = new SimpleObjectProperty<>();
    private ObjectProperty<TeacherFx> teacherFx = new SimpleObjectProperty<>();

    public long getWarnId() {
        return warnId.get();
    }

    public LongProperty warnIdProperty() {
        return warnId;
    }

    public void setWarnId(long warnId) {
        this.warnId.set(warnId);
    }

    public LocalDate getDateCreated() {
        return dateCreated.get();
    }

    public ObjectProperty<LocalDate> dateCreatedProperty() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getContent() {
        return content.get();
    }

    public StringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
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

    public TeacherFx getTeacherFx() {
        return teacherFx.get();
    }

    public ObjectProperty<TeacherFx> teacherFxProperty() {
        return teacherFx;
    }

    public void setTeacherFx(TeacherFx teacherFx) {
        this.teacherFx.set(teacherFx);
    }

    @Override
    public String toString() {
        return "WarnsFx{" +
                "warnId=" + warnId +
                ", dateCreated=" + dateCreated +
                ", content=" + content +
                ", studentFx=" + studentFx +
                ", teacherFx=" + teacherFx +
                '}';
    }
}
