package modelFX;

import javafx.beans.property.*;

public class SubjectFx {
    private LongProperty subjectId = new SimpleLongProperty();
    private StringProperty subjectName = new SimpleStringProperty();
    private ObjectProperty<ClasFx> clasFx = new SimpleObjectProperty<>();
    private ObjectProperty<GradesFx> gradeFx = new SimpleObjectProperty<>();

    public long getSubjectId() {
        return subjectId.get();
    }

    public LongProperty subjectIdProperty() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId.set(subjectId);
    }

    public String getSubjectName() {
        return subjectName.get();
    }

    public StringProperty subjectNameProperty() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName.set(subjectName);
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

    public GradesFx getGradeFx() {
        return gradeFx.get();
    }

    public ObjectProperty<GradesFx> gradeFxProperty() {
        return gradeFx;
    }

    public void setGradeFx(GradesFx gradeFx) {
        this.gradeFx.set(gradeFx);
    }

    @Override
    public String toString() {
        return "SubjectFx{" +
                "subjectId=" + subjectId +
                ", subjectName=" + subjectName +
                ", clasFx=" + clasFx +
                ", gradeFx=" + gradeFx +
                '}';
    }
}
