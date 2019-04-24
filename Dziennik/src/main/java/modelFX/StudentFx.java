package modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleObjectProperty;

public class StudentFx {

  private StringProperty firstNameS = new SimpleStringProperty();
  private StringProperty lastNameS = new SimpleStringProperty();
  private StringProperty pesel = new SimpleStringProperty();
  private ObjectProperty<ClasFx> clasFx  = new SimpleObjectProperty<>();
}
