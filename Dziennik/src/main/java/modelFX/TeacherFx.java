package modelFX;

import javafx.beans.property.*;

public class TeacherFx {
    private LongProperty teacherId = new SimpleLongProperty();
    private StringProperty firstNameT = new SimpleStringProperty();
    private StringProperty lastnNameT = new SimpleStringProperty();
    private ObjectProperty<ClasFx> clasFx = new SimpleObjectProperty<>();
    private ObjectProperty<WarnsFx> warnsFx = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFx = new SimpleObjectProperty<>();
    private ObjectProperty<UserFx> userFx = new SimpleObjectProperty<>();

    public long getTeacherId() {
        return teacherId.get();
    }

    public LongProperty teacherIdProperty() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId.set(teacherId);
    }

    public String getFirstNameT() {
        return firstNameT.get();
    }

    public StringProperty firstNameTProperty() {
        return firstNameT;
    }

    public void setFirstNameT(String firstNameT) {
        this.firstNameT.set(firstNameT);
    }

    public String getLastnNameT() {
        return lastnNameT.get();
    }

    public StringProperty lastnNameTProperty() {
        return lastnNameT;
    }

    public void setLastnNameT(String lastnNameT) {
        this.lastnNameT.set(lastnNameT);
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

    public WarnsFx getWarnsFx() {
        return warnsFx.get();
    }

    public ObjectProperty<WarnsFx> warnsFxProperty() {
        return warnsFx;
    }

    public void setWarnsFx(WarnsFx warnsFx) {
        this.warnsFx.set(warnsFx);
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

    public UserFx getUserFx() {
        return userFx.get();
    }

    public ObjectProperty<UserFx> userFxProperty() {
        return userFx;
    }

    public void setUserFx(UserFx userFx) {
        this.userFx.set(userFx);
    }

    @Override
    public String toString() {
        return "TeacherFx{" +
                "teacherId=" + teacherId +
                ", firstNameT=" + firstNameT +
                ", lastnNameT=" + lastnNameT +
                ", clasFx=" + clasFx +
                ", warnsFx=" + warnsFx +
                ", subjectFx=" + subjectFx +
                ", userFx=" + userFx +
                '}';
    }
}
