package services;

import Converters.ClassConverter;
import Converters.StudentConverter;
import Modele.Classes;
import Modele.Student;
import dao.ClassDao;
import dao.StudentDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import modelFX.ClassesFx;
import modelFX.StudentFx;

import java.util.ArrayList;
import java.util.List;

public class StudentServices {
    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>(new StudentFx());

    private List<StudentFx> studentFxList = new ArrayList<>();
    private StudentDao studentDao;
    private ClassDao classDao;
    private TreeItem<String> listOfStudents = new TreeItem<>();

    /**
     * Konstruktor klasy StudentService i inicjalizacja StudentDao
     */
    public StudentServices(){
        studentDao = new StudentDao();
    }

    public void init(){
        studentDao =  new StudentDao();
        List<Student> students = findAllStudents();
        studentFxList.clear();
        students.forEach(student -> this.studentFxList.add(StudentConverter.convertToStudentFx(student)));
        this.studentFxObservableList.setAll(studentFxList);

        initClassList();
    }



    private void initClassList(){
        classDao = new ClassDao();
        List<Classes> classesList = findAllClasses();
        classesFxObservableList.clear();
        classesList.forEach(c->{
            ClassesFx classesFx = ClassConverter.convertToClassFx(c);
            classesFxObservableList.add(classesFx);
        });
    }
    public void saveStudent(){
        studentDao.openCurrentSessionWithTransaction();
        Student student = StudentConverter.convertToStudent(this.getStudentFxObjectProperty());
        classDao.openCurrentSessionWithTransaction();
        Classes classes = classDao.findById(this.getStudentFxObjectProperty().getClassesFxObjectProperty().getClassId());
        classDao.closeCurrentSessionWithTransaction();
        student.setClasses(classes);
        studentDao.persist(student);
        studentDao.closeCurrentSessionWithTransaction();
    }



    public TreeItem<String> getRoot() {
        return listOfStudents;
    }
    public void setRoot(TreeItem<String> root) {
        this.listOfStudents = root;
    }


    /**
     * Metoda zapisuje studenta do bazy danych.
     * @param entity
     */
    public void persist(Student entity) {
        studentDao.openCurrentSessionWithTransaction();
        studentDao.persist(entity);
        studentDao.closeCurrentSessionWithTransaction();
    }

    /**
     * Metoda aktualizuje dane o studencie.
     * @param entity
     */
    public void update(Student entity) {
        studentDao.openCurrentSessionWithTransaction();
        studentDao.update(entity);
        studentDao.closeCurrentSessionWithTransaction();
    }


    /**
     * Metoda usuwa z bazy danych studenta o poodanym id.
     * @param id
     */
    public void delete(long id) {
        studentDao.openCurrentSessionWithTransaction();
        Student student = studentDao.findById(id);
        studentDao.delete(student);
        studentDao.closeCurrentSessionWithTransaction();
    }

    public void deleteStudent(StudentFx studentFx){
        studentDao.openCurrentSessionWithTransaction();
        delete(studentFx.getStudentId());
        init();
        studentDao.closeCurrentSessionWithTransaction();


    }


    public List<Student> findAllStudentByClass(long classId){
        studentDao.openCurrentSession();
        List<Student> students = studentDao.findAllStudentsInClass(classId);
        studentDao.closeCurrentSession();

        return students;
    }

    public List<Student> findAllStudents(){
        studentDao.openCurrentSession();
        List<Student> students = studentDao.findAll();
        studentDao.closeCurrentSession();

        return students;
    }
    public List<Classes> findAllClasses() {
        classDao.openCurrentSession();
        List<Classes> classes = classDao.findAll();
        classDao.closeCurrentSession();

        return classes;
    }

    /**
     * Metoda znajduje studenta o podanym id.
     * @param id
     * @return
     */
    public Student findById(long id){
        studentDao.openCurrentSession();
        Student student = studentDao.findById(id);
        studentDao.closeCurrentSession();

        return student;
    }



    public StudentDao studentDao(){
        return studentDao;
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
