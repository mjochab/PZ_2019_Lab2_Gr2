package modelFX;

import Modele.Grades;
import Modele.Student;
import Modele.Subject;
import javafx.beans.property.*;

import java.util.Date;

public class GradesFx extends Grades {

    private SimpleLongProperty gradeId = new SimpleLongProperty();
    private SimpleIntegerProperty grade= new SimpleIntegerProperty();
    private Date date = new Date();
    private SimpleStringProperty details = new SimpleStringProperty();
    private ObjectProperty<Student> StudentObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<Subject> SubjectObjectProperty = new SimpleObjectProperty<>();

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
    public int getGrade() {
        return grade.get();
    }

    public SimpleIntegerProperty gradeProperty() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade.set(grade);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Subject getSubjectObjectProperty() {
        return SubjectObjectProperty.get();
    }

    public ObjectProperty<Subject> subjectObjectPropertyProperty() {
        return SubjectObjectProperty;
    }

    public void setSubjectObjectProperty(Subject subjectObjectProperty) {
        this.SubjectObjectProperty.set(subjectObjectProperty);
    }

    @Override
    public String toString() {
        return "GradesFx{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", date=" + date +
                ", details=" + details +
                ", StudentObjectProperty=" + StudentObjectProperty +
                ", SubjectObjectProperty=" + SubjectObjectProperty +
                '}';
    }
}


