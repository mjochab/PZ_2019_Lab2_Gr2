package modelFX;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassesFx {


    private StringProperty name = new SimpleStringProperty();


    public ClassesFx(String name,Long classId) {
        this.name.set(name);

    }

    public ClassesFx(StringProperty name, SimpleLongProperty classId) {
        this.name = name;

    }

    public ClassesFx() {

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
