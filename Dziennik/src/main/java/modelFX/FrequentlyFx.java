package modelFX;

import javafx.beans.property.*;

import java.time.LocalDate;

public class FrequentlyFx {

    private LongProperty frequentlyId = new SimpleLongProperty();
    private IntegerProperty absence = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> absenceDate = new SimpleObjectProperty<>();
    private ObjectProperty<StudentFx> studentFx = new SimpleObjectProperty<>();

    public long getFrequentlyId() {
        return frequentlyId.get();
    }

    public LongProperty frequentlyIdProperty() {
        return frequentlyId;
    }

    public void setFrequentlyId(long frequentlyId) {
        this.frequentlyId.set(frequentlyId);
    }

    public int getAbsence() {
        return absence.get();
    }

    public IntegerProperty absenceProperty() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence.set(absence);
    }

    public LocalDate getAbsenceDate() {
        return absenceDate.get();
    }

    public ObjectProperty<LocalDate> absenceDateProperty() {
        return absenceDate;
    }

    public void setAbsenceDate(LocalDate absenceDate) {
        this.absenceDate.set(absenceDate);
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

    @Override
    public String toString() {
        return "FrequentlyFx{" +
                "frequentlyId=" + frequentlyId +
                ", absence=" + absence +
                ", absenceDate=" + absenceDate +
                ", studentFx=" + studentFx +
                '}';
    }
}
