package modelFX;

import Modele.Frequently;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class FrequentlyFX extends Frequently {

        private SimpleLongProperty frequentlyID = new SimpleLongProperty();
        private SimpleIntegerProperty absense= new SimpleIntegerProperty();
        private Date date = new Date();
        private ObjectProperty<StudentFx> StudentFxObjectProperty = new SimpleObjectProperty<>();

    public long getFrequentlyID() {
        return frequentlyID.get();
    }

    public SimpleLongProperty frequentlyIDProperty() {
        return frequentlyID;
    }

    public void setFrequentlyID(long frequentlyID) {
        this.frequentlyID.set(frequentlyID);
    }

    public int getAbsense() {
        return absense.get();
    }

    public SimpleIntegerProperty absenseProperty() {
        return absense;
    }

    public void setAbsense(int absense) {
        this.absense.set(absense);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StudentFx getStudentFxObjectProperty() {
        return StudentFxObjectProperty.get();
    }
    

    public ObjectProperty<StudentFx> studentFxObjectPropertyProperty() {
        return StudentFxObjectProperty;
    }

    public void setStudentFxObjectProperty(StudentFx studentFxObjectProperty) {
        this.StudentFxObjectProperty.set(studentFxObjectProperty);
    }

    @Override
    public String toString() {
        return "FrequentlyFX{" +
                "frequentlyID=" + frequentlyID +
                ", absense=" + absense +
                ", date=" + date +
                ", StudentFxObjectProperty=" + StudentFxObjectProperty +
                '}';
    }
}
