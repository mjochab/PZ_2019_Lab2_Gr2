package modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ScheduleFx {

    private SimpleLongProperty sheduleId = new SimpleLongProperty();
    private SimpleStringProperty day = new SimpleStringProperty();
    private SimpleStringProperty time = new SimpleStringProperty();
    private SimpleStringProperty room = new SimpleStringProperty();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();


    public long getSheduleId() {
        return sheduleId.get();
    }

    public SimpleLongProperty sheduleIdProperty() {
        return sheduleId;
    }

    public void setSheduleId(long sheduleId) {
        this.sheduleId.set(sheduleId);
    }

    public String getDay() {
        return day.get();
    }

    public SimpleStringProperty dayProperty() {
        return day;
    }

    public void setDay(String day) {
        this.day.set(day);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getRoom() {
        return room.get();
    }

    public SimpleStringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
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
        return "ScheduleFx{" +
                "sheduleId=" + sheduleId +
                ", day=" + day +
                ", time=" + time +
                ", room=" + room +
                ", classesFxObjectProperty=" + classesFxObjectProperty +
                ", subjectFxObjectProperty=" + subjectFxObjectProperty +
                '}';
    }
}
