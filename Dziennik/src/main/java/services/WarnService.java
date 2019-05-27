package services;

import Converters.ClassConverter;
import Converters.WarnsConverter;
import Modele.Classes;
import Modele.Student;
import Modele.Warns;
import dao.ClassDao;
import dao.StudentDao;
import dao.WarnsDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.ClassesFx;
import modelFX.StudentFx;
import modelFX.WarnsFx;
import sessions.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WarnService {
    ClassDao classDao;
    StudentDao studentDao = new StudentDao();
    WarnsDao warnsDao;

    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>(new StudentFx());
    private ObjectProperty<WarnsFx> warnsFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<WarnsFx> warnsFxObservableList = FXCollections.observableArrayList();
    private List<WarnsFx> warnsFxList = new ArrayList<>();

    public void init(){
        warnsDao = new WarnsDao();

        List<Warns> warns = findAllWarnsOfTeacher();
        warnsFxList.clear();
        warns.forEach(warns1 -> this.warnsFxList.add(WarnsConverter.convertToWarnsFx(warns1)));
        this.warnsFxObservableList.setAll(warnsFxList);

        initCbClass();



    }

    private void initCbClass(){
        classDao = new ClassDao();
        List<Classes> classesList = findAllClasses();
        classesFxObservableList.clear();
        classesList.forEach(classes -> {
            ClassesFx classesFx = ClassConverter.convertToClassFx(classes);
            this.classesFxObservableList.add(classesFx);
        });
    }


    public void persist(Warns entity) {
        warnsDao.openCurrentSessionWithTransaction();
        warnsDao.persist(entity);
        warnsDao.closeCurrentSessionWithTransaction();
    }

    public List<Classes> findAllClasses() {
        classDao.openCurrentSession();
        List<Classes> classes = classDao.findAll();
        classDao.closeCurrentSession();

        return classes;
    }

    public List<Student> findAllStudentByClass(long classId){
        studentDao.openCurrentSessionWithTransaction();
        List<Student> students = studentDao.findAllStudentsInClass(classId);
        studentDao.closeCurrentSessionWithTransaction();

        return students;
    }

    public void filterWarnsList(){
        if(getStudentFxObjectProperty() != null){
            filterPredicate(predicateStudent());
        }else{
            this.warnsFxObservableList.setAll(this.warnsFxList);
        }
    }

    private void filterPredicate(Predicate<WarnsFx> predicate) {
        List<WarnsFx> newList = warnsFxObservableList.stream().filter(predicate).collect(Collectors.toList());
        this.warnsFxObservableList.setAll(newList);
    }
    private Predicate<WarnsFx> predicateStudent() {
        return warnsFx -> warnsFx.getStudentFxObjectProperty().getStudentId() == getStudentFxObjectProperty().getStudentId();
    }

    public List<Warns> findAllWarnsOfTeacher() {
        warnsDao.openCurrentSession();
        List<Warns> warns = warnsDao.findAllWarnsOfTeacher(UserSession.getInstance().currentUser().getTeacher().getTeacherId());
        warnsDao.closeCurrentSession();

        return warns;
    }


    public ObservableList<ClassesFx> getClassesFxObservableList() {
        return classesFxObservableList;
    }

    public void setClassesFxObservableList(ObservableList<ClassesFx> classesFxObservableList) {
        this.classesFxObservableList = classesFxObservableList;
    }

    public ClassesFx getClassesFxObjectProperty() {
        return classesFxObjectProperty.get();
    }

    public ObjectProperty<ClassesFx> classesFxObjectPropertyProperty() {
        return classesFxObjectProperty;
    }

    public void setClassesFxObjectProperty(ClassesFx classesFxObjectProperty) {
        this.classesFxObjectProperty.set(classesFxObjectProperty);
    }

    public ObservableList<StudentFx> getStudentFxObservableList() {
        return studentFxObservableList;
    }

    public void setStudentFxObservableList(ObservableList<StudentFx> studentFxObservableList) {
        this.studentFxObservableList = studentFxObservableList;
    }

    public StudentFx getStudentFxObjectProperty() {
        return studentFxObjectProperty.get();
    }

    public ObjectProperty<StudentFx> studentFxObjectPropertyProperty() {
        return studentFxObjectProperty;
    }

    public void setStudentFxObjectProperty(StudentFx studentFxObjectProperty) {
        this.studentFxObjectProperty.set(studentFxObjectProperty);
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

    public ObservableList<WarnsFx> getWarnsFxObservableList() {
        return warnsFxObservableList;
    }

    public void setWarnsFxObservableList(ObservableList<WarnsFx> warnsFxObservableList) {
        this.warnsFxObservableList = warnsFxObservableList;
    }

    public List<WarnsFx> getWarnsFxList() {
        return warnsFxList;
    }

    public void setWarnsFxList(List<WarnsFx> warnsFxList) {
        this.warnsFxList = warnsFxList;
    }
}
