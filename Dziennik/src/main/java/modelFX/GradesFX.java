package modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class GradesFx {
    private SimpleLongProperty gradeID = new SimpleLongProperty();
    private SimpleStringProperty dateCreated = new SimpleStringProperty();
    private SimpleStringProperty otherDetails = new SimpleStringProperty();
    private SimpleStringProperty grade = new SimpleStringProperty();
    private SimpleStringProperty linkedAcc = new SimpleStringProperty();


    public String getData() {
        return dateCreated.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return dateCreated;
    }

    public void setData(String firstName) {
        this.dateCreated.set(firstName);
    }

    public String getDetails() {
        return otherDetails.get();
    }

    public SimpleStringProperty otherDetailsProperty() {
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

    public String getLinkedAcc() {
        return linkedAcc.get();
    }

    public SimpleStringProperty linkedAccProperty() {
        return linkedAcc;
    }

    public void setLinkedAcc(String linkedAcc) {
        this.linkedAcc.set(linkedAcc);
    }

    public long getGradeID() {
        return gradeID.get();
    }

    public SimpleLongProperty gradeIDProperty() {
        return gradeID;
    }

    public void setGradeID(long gradeID) {
        this.gradeID.set(gradeID);
    }
}