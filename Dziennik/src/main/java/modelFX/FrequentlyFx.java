package modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class FrequentlyFx   {

        private SimpleLongProperty frequentlyId = new SimpleLongProperty();
        private SimpleIntegerProperty absense= new SimpleIntegerProperty();
        private SimpleObjectProperty<Date> date = new SimpleObjectProperty<>();
        private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>();



    public long getFrequentlyId() {
        return frequentlyId.get();
    }

    public SimpleLongProperty frequentlyIdProperty() {
        return frequentlyId;
    }

    public void setFrequentlyId(long frequentlyId) {
        this.frequentlyId.set(frequentlyId);
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
        return date.get();
    }

    public SimpleObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public StudentFx getStudentFxObjectProperty() {
        return studentFxObjectProperty.get();
    }

    public ObjectProperty<StudentFx> studentFxObjectPropertyProperty() {
        return studentFxObjectProperty;
    }

    public void setStudentFxObjectProperty(StudentFx studentFxObjectProperty) {
        this.studentFxObjectProperty.set(studentFxObjectProperty);
    }

    @Override
    public String toString() {
        return "FrequentlyFx{" +
                "frequentlyID=" + frequentlyId +
                ", absense=" + absense +
                ", date=" + date +
                '}';
    }
}
