package services;

import Converters.ClassConverter;
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

import java.util.List;

public class WarnService {
    ClassDao classDao;
    StudentDao studentDao = new StudentDao();
    WarnsDao warnsDao;

    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>(new StudentFx());

    public void init(){
        warnsDao = new WarnsDao();

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
}
