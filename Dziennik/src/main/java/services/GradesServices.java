package services;

import Converters.ClassConverter;
import Converters.StudentConverter;
import Modele.Classes;
import Modele.Grades;
import Modele.Student;
import dao.ClassDao;
import dao.GradesDao;
import dao.StudentDao;
import dao.SubjectDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import modelFX.ClassesFx;
import modelFX.GradesFx;
import modelFX.StudentFx;
import modelFX.SubjectFx;

import java.util.ArrayList;
import java.util.List;

public class GradesServices {

    private ClassDao classDao;
    private GradesDao gradesDao;
    private SubjectDao subjectDao;
    private StudentDao studentDao = new StudentDao();
    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObservableList<GradesFx> gradesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<GradesFx> gradesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>();

    private TreeItem<String> root = new TreeItem<>();
    private List<StudentFx> studentFxList = new ArrayList<>();
    private TreeItem<String> listOfGrades = new TreeItem<>();
    private GradesFx gradesFxList;


    public GradesServices() {
        gradesDao = new GradesDao();
    }

    public void init(){
        gradesDao = new GradesDao();
        initCbClass();

    }

    private void initCbStudent(){
        studentDao= new StudentDao();
        List<Student> studentList= findAllStudents();
        studentFxObservableList.clear();
        studentList.forEach(student -> {
            StudentFx studentFx = StudentConverter.convertToStudentFx(student);
            this.studentFxObservableList.add(studentFx);
        });
    }

    public List<Student> findAllStudents() {
        studentDao.openCurrentSession();
        List<Student> students= studentDao.findAll();
        studentDao.closeCurrentSession();

        return students;
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

    public GradesFx getGradesFxObjectProperty() {
        return gradesFxObjectProperty.get();
    }

    public ObjectProperty<GradesFx> gradesFxObjectPropertyProperty() {
        return gradesFxObjectProperty;
    }

    public void setGradesFxObjectProperty(GradesFx gradesFxObjectProperty) {
        this.gradesFxObjectProperty.set(gradesFxObjectProperty);
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

    public List<Grades> findAllGrades() {
        gradesDao.openCurrentSession();
        List<Grades> grades = gradesDao.findAll();
        gradesDao.closeCurrentSession();

        return grades;
    }





    public void persist(Grades entity) {
        gradesDao.openCurrentSessionWithTransaction();
        gradesDao.persist(entity);
        gradesDao.closeCurrentSessionWithTransaction();
    }


    public void update(Grades entity) {
        gradesDao.openCurrentSessionWithTransaction();
        gradesDao.update(entity);
        gradesDao.closeCurrentSessionWithTransaction();
    }


    public Grades findById(long id) {
        gradesDao.openCurrentSession();
        Grades grades = gradesDao.findById(id);
        gradesDao.closeCurrentSession();
        return grades;
    }


    public void delete(long id) {
        gradesDao.openCurrentSessionWithTransaction();
        Grades grades = gradesDao.findById(id);
        gradesDao.delete(grades);
        gradesDao.closeCurrentSessionWithTransaction();
    }


    public void deleteAll() {
        gradesDao.openCurrentSessionWithTransaction();
        gradesDao.deleteAll();
        gradesDao.closeCurrentSessionWithTransaction();
    }

    public ClassDao getClassDao() {
        return classDao;
    }

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
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

    public SubjectFx getSubjectFxObjectProperty() {
        return subjectFxObjectProperty.get();
    }

    public ObjectProperty<SubjectFx> subjectFxObjectPropertyProperty() {
        return subjectFxObjectProperty;
    }

    public void setSubjectFxObjectProperty(SubjectFx subjectFxObjectProperty) {
        this.subjectFxObjectProperty.set(subjectFxObjectProperty);
    }

    public ObservableList<SubjectFx> getSubjectFxObservableList() {
        return subjectFxObservableList;
    }

    public void setSubjectFxObservableList(ObservableList<SubjectFx> subjectFxObservableList) {
        this.subjectFxObservableList = subjectFxObservableList;
    }

    public ObservableList<GradesFx> getGradesFxObservableList() {
        return gradesFxObservableList;
    }

    public void setGradesFxObservableList(ObservableList<GradesFx> gradesFxObservableList) {
        this.gradesFxObservableList = gradesFxObservableList;
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }

    public List<StudentFx> getStudentFxList() {
        return studentFxList;
    }

    public void setStudentFxList(List<StudentFx> studentFxList) {
        this.studentFxList = studentFxList;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public GradesDao getGradesDao() {
        return gradesDao;
    }

    public void setGradesDao(GradesDao gradesDao) {
        this.gradesDao = gradesDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public TreeItem<String> getListOfGrades() {
        return listOfGrades;
    }

    public void setListOfGrades(TreeItem<String> listOfGrades) {
        this.listOfGrades = listOfGrades;
    }

    public GradesFx getGradesFxList() {
        return gradesFxList;
    }

    public void setGradesFxList(GradesFx gradesFxList) {
        this.gradesFxList = gradesFxList;
    }
}
