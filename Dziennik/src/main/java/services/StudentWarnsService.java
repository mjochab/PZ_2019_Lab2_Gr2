package services;

import Converters.WarnsConverter;
import Modele.Warns;
import dao.WarnsDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.TeacherFx;
import modelFX.WarnsFx;
import sessions.UserSession;

import java.util.ArrayList;
import java.util.List;

public class StudentWarnsService {
    private ObservableList<WarnsFx> warnsFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<WarnsFx> warnsFxObjectProperty = new SimpleObjectProperty<>(new WarnsFx());
    private ObservableList<TeacherFx> teacherFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<TeacherFx> teacherFxObjectProperty = new SimpleObjectProperty<>();
    private List<WarnsFx> warnsFxList = new ArrayList<>();



    WarnsDao warnsDao;

    public void init(){
        warnsDao = new WarnsDao();
        List<Warns> warns = findAllWarns();
        warnsFxList.clear();
        warns.forEach(warns1 -> this.warnsFxList.add(WarnsConverter.convertToWarnsFx(warns1)));
        this.warnsFxObservableList.setAll(warnsFxList);


    }

    public List<Warns> findAllWarns(){
        warnsDao.openCurrentSession();
        List<Warns> warns = warnsDao.findAllWarnssForStudent(UserSession.getInstance().currentUser().getStudent().getStudentId());
        warnsDao.closeCurrentSession();

        return warns;
    }


    public ObservableList<WarnsFx> getWarnsFxObservableList() {
        return warnsFxObservableList;
    }

    public void setWarnsFxObservableList(ObservableList<WarnsFx> warnsFxObservableList) {
        this.warnsFxObservableList = warnsFxObservableList;
    }

    public WarnsFx getWarnsFxObjectProperty() {
        return warnsFxObjectProperty.get();
    }

    public ObjectProperty<WarnsFx> warnsFxObjectPropertyProperty() {
        return warnsFxObjectProperty;
    }

    public void setWarnsFxObjectProperty(WarnsFx warnsFxObjectProperty) {
        this.warnsFxObjectProperty.set(warnsFxObjectProperty);
    }

    public ObservableList<TeacherFx> getTeacherFxObservableList() {
        return teacherFxObservableList;
    }

    public void setTeacherFxObservableList(ObservableList<TeacherFx> teacherFxObservableList) {
        this.teacherFxObservableList = teacherFxObservableList;
    }

    public TeacherFx getTeacherFxObjectProperty() {
        return teacherFxObjectProperty.get();
    }

    public ObjectProperty<TeacherFx> teacherFxObjectPropertyProperty() {
        return teacherFxObjectProperty;
    }

    public void setTeacherFxObjectProperty(TeacherFx teacherFxObjectProperty) {
        this.teacherFxObjectProperty.set(teacherFxObjectProperty);
    }

    public List<WarnsFx> getWarnsFxList() {
        return warnsFxList;
    }

    public void setWarnsFxList(List<WarnsFx> warnsFxList) {
        this.warnsFxList = warnsFxList;
    }
}
