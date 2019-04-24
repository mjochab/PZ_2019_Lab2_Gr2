package modelFX;

import javafx.beans.property.*;

import java.time.LocalDate;

public class GradesFx {

    private LongProperty gradeId = new SimpleLongProperty();
    private IntegerProperty grade = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> dateCreated = new SimpleObjectProperty<>();
    private StringProperty details = new SimpleStringProperty();
    private ObjectProperty<StudentFx> studentFx = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFx = new SimpleObjectProperty<>();

    public long getGradeId() {
        return gradeId.get();
    }

    public LongProperty gradeIdProperty() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId.set(gradeId);
    }

    public int getGrade() {
        return grade.get();
    }

    public IntegerProperty gradeProperty() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade.set(grade);
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

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }

    public void setDetails(String details) {
        this.details.set(details);
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

    public SubjectFx getSubjectFx() {
        return subjectFx.get();
    }

    public ObjectProperty<SubjectFx> subjectFxProperty() {
        return subjectFx;
    }

    public void setSubjectFx(SubjectFx subjectFx) {
        this.subjectFx.set(subjectFx);
    }

    @Override
    public String toString() {
        return "GradesFx{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", dateCreated=" + dateCreated +
                ", details=" + details +
                ", studentFx=" + studentFx +
                ", subjectFx=" + subjectFx +
                '}';
    }
}
