package modelFX;

import Modele.Student;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentFx extends Student {
    private SimpleLongProperty studentId = new SimpleLongProperty();
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty pesel = new SimpleStringProperty();
    private SimpleStringProperty linkedAcc = new SimpleStringProperty();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();


    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPesel() {
        return pesel.get();
    }

    public SimpleStringProperty peselProperty() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
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

    public long getStudentId() {
        return studentId.get();
    }

    public SimpleLongProperty studentIdProperty() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId.set(studentId);
    }

    public ClassesFx getClassesFxObjectProperty() {
        return classesFxObjectProperty.get();
    }

    public ObjectProperty<ClassesFx> classesFxObjectPropertyProperty() {
        return classesFxObjectProperty;
    }

    public void setClassesFxObjectProperty(ClassesFx classesFxObjectProperty) {
        this.classesFxObjectProperty.set(classesFxObjectProperty);
    }

    @Override
    public String toString() {
        return "StudentFx{" +
                "studentId=" + studentId +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", pesel=" + pesel +
                ", linkedAcc=" + linkedAcc +
                ", classesFxObjectProperty=" + classesFxObjectProperty +
                '}';
    }
}
