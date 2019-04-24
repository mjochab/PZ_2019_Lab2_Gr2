package modelFX;

import javafx.beans.property.*;

public class StudentFx {


  private LongProperty studentId = new SimpleLongProperty();
  private StringProperty firstNameS = new SimpleStringProperty();
  private StringProperty lastNameS = new SimpleStringProperty();
  private StringProperty pesel = new SimpleStringProperty();
  private ObjectProperty<ClasFx> clasFx  = new SimpleObjectProperty<>();
  private ObjectProperty<WarnsFx> warnsFx = new SimpleObjectProperty<>();
  private ObjectProperty<GradesFx> gradesFx = new SimpleObjectProperty<>();
  private ObjectProperty<FrequentlyFx> frequentlyFx  = new SimpleObjectProperty<>();
  private ObjectProperty<UserFx> userFx = new SimpleObjectProperty<>();

  public long getStudentId() {
    return studentId.get();
  }

  public LongProperty studentIdProperty() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId.set(studentId);
  }

  public String getFirstNameS() {
    return firstNameS.get();
  }

  public StringProperty firstNameSProperty() {
    return firstNameS;
  }

  public void setFirstNameS(String firstNameS) {
    this.firstNameS.set(firstNameS);
  }

  public String getLastNameS() {
    return lastNameS.get();
  }

  public StringProperty lastNameSProperty() {
    return lastNameS;
  }

  public void setLastNameS(String lastNameS) {
    this.lastNameS.set(lastNameS);
  }

  public String getPesel() {
    return pesel.get();
  }

  public StringProperty peselProperty() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel.set(pesel);
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

  public GradesFx getGradesFx() {
    return gradesFx.get();
  }

  public ObjectProperty<GradesFx> gradesFxProperty() {
    return gradesFx;
  }

  public void setGradesFx(GradesFx gradesFx) {
    this.gradesFx.set(gradesFx);
  }

  public FrequentlyFx getFrequentlyFx() {
    return frequentlyFx.get();
  }

  public ObjectProperty<FrequentlyFx> frequentlyFxProperty() {
    return frequentlyFx;
  }

  public void setFrequentlyFx(FrequentlyFx frequentlyFx) {
    this.frequentlyFx.set(frequentlyFx);
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
    return "StudentFx{" +
            "studentId=" + studentId +
            ", firstNameS=" + firstNameS +
            ", lastNameS=" + lastNameS +
            ", pesel=" + pesel +
            ", clasFx=" + clasFx +
            ", warnsFx=" + warnsFx +
            ", gradesFx=" + gradesFx +
            ", frequentlyFx=" + frequentlyFx +
            ", userFx=" + userFx +
            '}';
  }
}
