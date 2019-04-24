package modelFX;

import javafx.beans.property.*;

public class UserFx {
    private LongProperty userId = new SimpleLongProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty passwrd = new SimpleStringProperty();
    private StringProperty linkedAcc = new SimpleStringProperty();
    private ObjectProperty<TeacherFx> teacherFx = new SimpleObjectProperty<>();
    private ObjectProperty<StudentFx> studentFx = new SimpleObjectProperty<>();

    public long getUserId() {
        return userId.get();
    }

    public LongProperty userIdProperty() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId.set(userId);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPasswrd() {
        return passwrd.get();
    }

    public StringProperty passwrdProperty() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd.set(passwrd);
    }

    public String getLinkedAcc() {
        return linkedAcc.get();
    }

    public StringProperty linkedAccProperty() {
        return linkedAcc;
    }

    public void setLinkedAcc(String linkedAcc) {
        this.linkedAcc.set(linkedAcc);
    }

    public TeacherFx getTeacherFx() {
        return teacherFx.get();
    }

    public ObjectProperty<TeacherFx> teacherFxProperty() {
        return teacherFx;
    }

    public void setTeacherFx(TeacherFx teacherFx) {
        this.teacherFx.set(teacherFx);
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
        return "UserFx{" +
                "userId=" + userId +
                ", username=" + username +
                ", passwrd=" + passwrd +
                ", linkedAcc=" + linkedAcc +
                ", teacherFx=" + teacherFx +
                ", studentFx=" + studentFx +
                '}';
    }
}
