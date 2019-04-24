package modelFX;

import javafx.beans.property.*;

public class ScheduleFx {
    private LongProperty scheduleId = new SimpleLongProperty();
    private StringProperty day = new SimpleStringProperty();
    private StringProperty time = new SimpleStringProperty();
    private StringProperty room = new SimpleStringProperty();
    private ObjectProperty<ClasFx> clasFx = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFx = new SimpleObjectProperty<>();

    public long getScheduleId() {
        return scheduleId.get();
    }

    public LongProperty scheduleIdProperty() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId.set(scheduleId);
    }

    public String getDay() {
        return day.get();
    }

    public StringProperty dayProperty() {
        return day;
    }

    public void setDay(String day) {
        this.day.set(day);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getRoom() {
        return room.get();
    }

    public StringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public ClasFx getClasFx() {
        return clasFx.get();
    }

    public ObjectProperty<ClasFx> clasFxProperty() {
        return clasFx;
    }

    public void setClasFx(ClasFx clasFx) {
        this.clasFx.set(clasFx);
    }

    public SubjectFx getSubjectFx() {
        return subjectFx.get();
    }

    public ObjectProperty<SubjectFx> subjectFxProperty() {
        return subjectFx;
    }

    public void setSubjectFx(SubjectFx subjectFx) {
        this.subjectFx.set(subjectFx);
    }

    @Override
    public String toString() {
        return "ScheduleFx{" +
                "scheduleId=" + scheduleId +
                ", day=" + day +
                ", time=" + time +
                ", room=" + room +
                ", clasFx=" + clasFx +
                ", subjectFx=" + subjectFx +
                '}';
    }
}
