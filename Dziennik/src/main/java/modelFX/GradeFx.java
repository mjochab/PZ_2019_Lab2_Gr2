package modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class GradeFx {
    private SimpleLongProperty gradeId = new SimpleLongProperty();
    private SimpleStringProperty dateCreated = new SimpleStringProperty();
    private SimpleStringProperty otherDetails = new SimpleStringProperty();
    private SimpleStringProperty grade = new SimpleStringProperty();
    private SimpleLongProperty studentId = new SimpleLongProperty();
    private SimpleLongProperty subjectId = new SimpleLongProperty();


    public String getDateCreated() {
        return dateCreated.get();
    }

    public SimpleStringProperty dateCreatedProperty() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getDetails() {
        return otherDetails.get();
    }

    public SimpleStringProperty lastDetails() {
        return otherDetails;
    }

    public void setDetails(String otherDetails) {
        this.otherDetails.set(otherDetails);
    }

    public String getGrade() {
        return grade.get();
    }

    public SimpleStringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public long getGradeId() {
        return gradeId.get();
    }

    public SimpleLongProperty gradeIdProperty() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId.set(gradeId);
    }

    public long getStudent() {
        return studentId.get();
    }

    public SimpleLongProperty studentProperty() {
        return studentId;
    }

    public void setStudent(long studentId) {
        this.studentId.set(studentId);
    }

    public long getSubject() {
        return subjectId.get();
    }

    public SimpleLongProperty subjectProperty() {
        return subjectId;
    }

    public void setSubject(long subjectId) {
        this.subjectId.set(subjectId);
    }
    @Override
    public String toString() {
        return "GradeFx{" +
                "gradeId=" + gradeId +
                ", dateCreated=" + dateCreated +
                ", otherDetails=" + otherDetails +
                ", grade=" + grade +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                '}';
    }
}
