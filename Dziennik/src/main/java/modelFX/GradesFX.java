package modelFX;

import Modele.Grades;
import Modele.Student;
import javafx.beans.property.*;

import java.util.Date;

public class GradesFx extends Grades {

    private SimpleLongProperty gradeId = new SimpleLongProperty();
    private SimpleDoubleProperty grade = new SimpleDoubleProperty();
    private SimpleObjectProperty<Date> date = new SimpleObjectProperty<>();
    private SimpleStringProperty details = new SimpleStringProperty();
    private ObjectProperty<Student> StudentObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();

    public GradesFx() {
        super();
    }


    @Override
    public long getGradeId() {
        return gradeId.get();
    }

    public SimpleLongProperty gradeIdProperty() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId.set(gradeId);
    }

    @Override
    public double getGrade() {
        return grade.get();
    }

    public SimpleDoubleProperty gradeProperty() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade.set(grade);
    }

    public Date getDate() {
        return date.get();
    }

    public SimpleObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    @Override
    public String getDetails() {
        return details.get();
    }

    public SimpleStringProperty detailsProperty() {
        return details;
    }

    public void setDetails(String details) {
        this.details.set(details);
    }

    public Student getStudentObjectProperty() {
        return StudentObjectProperty.get();
    }

    public ObjectProperty<Student> studentObjectPropertyProperty() {
        return StudentObjectProperty;
    }

    public void setStudentObjectProperty(Student studentObjectProperty) {
        this.StudentObjectProperty.set(studentObjectProperty);
    }

    public SubjectFx getSubjectFxObjectProperty() {
        return subjectFxObjectProperty.get();
    }

    public ObjectProperty<SubjectFx> subjectFxObjectPropertyProperty() {
        return subjectFxObjectProperty;
    }

    public void setSubjectFxObjectProperty(SubjectFx subjectFxObjectProperty) {
        this.subjectFxObjectProperty.set(subjectFxObjectProperty);
    }

    @Override
    public String toString() {
        return "GradesFx{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", date=" + date +
                ", details=" + details +
                ", StudentObjectProperty=" + StudentObjectProperty +
                ", SubjectObjectProperty=" + subjectFxObjectProperty +
                '}';
    }
}


