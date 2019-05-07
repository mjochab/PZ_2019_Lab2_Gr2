package modelFX;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class WarnsFx {
    private SimpleLongProperty warns_id = new SimpleLongProperty();
    private SimpleStringProperty content = new SimpleStringProperty();
    private SimpleStringProperty date_created = new SimpleStringProperty();
    private SimpleLongProperty student_id = new SimpleLongProperty();
    private SimpleLongProperty teacher_id = new SimpleLongProperty();

    public long getWarns_id() {
        return warns_id.get();
    }

    public SimpleLongProperty warns_idProperty() {
        return warns_id;
    }

    public void setWarns_id(long warns_id) {
        this.warns_id.set(warns_id);
    }

    public String getContent() {
        return content.get();
    }

    public SimpleStringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public String getDate_created() {
        return date_created.get();
    }

    public SimpleStringProperty date_createdProperty() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created.set(date_created);
    }

    public long getStudentId() {
        return student_id.get();
    }

    public SimpleLongProperty student_idProperty() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id.set(student_id);
    }

    public long getTeacher_id() {
        return teacher_id.get();
    }

    public SimpleLongProperty teacher_idProperty() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id.set(teacher_id);
    }

    @Override
    public String toString() {
        return "WarnsFx{" +
                "warns_id=" + warns_id +
                ", content=" + content +
                ", date_created=" + date_created +
                ", student_id=" + student_id +
                ", teacher_id=" + teacher_id +
                '}';
    }


}
