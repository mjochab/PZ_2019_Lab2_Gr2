package modelFX;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SubjectFx {

    private StringProperty subjectName = new SimpleStringProperty();
    private SimpleLongProperty subjectId = new SimpleLongProperty();

    public String getSubjectName() {
        return subjectName.get();
    }

    public StringProperty subjectNameProperty() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName.set(subjectName);
    }

    public long getSubjectId() {
        return subjectId.get();
    }

    public SimpleLongProperty subjectIdProperty() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId.set(subjectId);
    }

    @Override
    public String toString() {
        return subjectName.getValue();
    }
}
