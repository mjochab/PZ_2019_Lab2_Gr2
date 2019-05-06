package modelFX;

import Modele.Teacher;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TeacherFx extends Teacher {
    private SimpleLongProperty teacherId = new SimpleLongProperty();
    private SimpleStringProperty firstNameT = new SimpleStringProperty();
    private SimpleStringProperty lastNameT = new SimpleStringProperty();
    private SimpleStringProperty linkedAcc = new SimpleStringProperty();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();


    public long getTeacherId() {
        return teacherId.get();
    }

    public SimpleLongProperty teacherIdProperty() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId.set(teacherId);
    }

    public String getFirstNameT() {
        return firstNameT.get();
    }

    public SimpleStringProperty firstNameTProperty() {
        return firstNameT;
    }

    public void setFirstNameT(String firstNameT) {
        this.firstNameT.set(firstNameT);
    }

    public String getLastNameT() {
        return lastNameT.get();
    }

    public SimpleStringProperty lastNameTProperty() {
        return lastNameT;
    }

    public void setLastNameT(String lastNameT) {
        this.lastNameT.set(lastNameT);
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
        return "TeacherFx{" +
                "teacherId=" + teacherId +
                ", firstNameT=" + firstNameT +
                ", lastNameT=" + lastNameT +
                ", linkedAcc=" + linkedAcc +
                ", subjectFxObjectProperty=" + subjectFxObjectProperty +
                '}';
    }
}
