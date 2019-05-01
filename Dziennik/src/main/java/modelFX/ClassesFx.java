package modelFX;

import Modele.Classes;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassesFx extends Classes {


    private StringProperty name = new SimpleStringProperty();
    private SimpleLongProperty classId = new SimpleLongProperty();



    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public long getClassId() {
        return classId.get();
    }

    public SimpleLongProperty classIdProperty() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId.set(classId);
    }

    @Override
    public String toString() {
        return name.getValue();
    }
}
