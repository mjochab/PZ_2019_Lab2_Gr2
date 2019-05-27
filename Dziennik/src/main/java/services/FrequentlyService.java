package services;

import Converters.ClassConverter;
import Converters.FrequentlyConventer;
import Modele.Classes;
import Modele.Frequently;
import Modele.Student;
import dao.ClassDao;
import dao.FrequentlyDao;
import dao.StudentDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.ClassesFx;
import modelFX.FrequentlyFx;
import modelFX.StudentFx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FrequentlyService {

    ClassDao classDao;
    StudentDao studentDao = new StudentDao();
    FrequentlyDao frequentlyDao;

    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<FrequentlyFx> frequentlyFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<FrequentlyFx> frequentlyFxObjectProperty = new SimpleObjectProperty<>(new FrequentlyFx());
    private List<FrequentlyFx> frequentlyFxList = new ArrayList<>();

    /**
     * Konstruktor klasy FrequentlyService i inicjalizacja FrequentlyDao
     */
    public FrequentlyService(){
        frequentlyDao = new FrequentlyDao();
    }

    public void init(){
        frequentlyDao = new FrequentlyDao();
        List<Frequently> frequentlies = findAllFrequently();
        frequentlyFxList.clear();
        frequentlies.forEach(frequently -> this.frequentlyFxList.add(FrequentlyConventer.convertToFrequentlyFX(frequently)));
        this.frequentlyFxObservableList.setAll(frequentlyFxList);

        initCbClass();
    }

    /**
     * Metoda pobiera wszystkie obecności z bazy danych.
     * @return List<Car>
     */
    public List<Frequently> findAllFrequently(){
        frequentlyDao.openCurrentSession();
        List<Frequently> frequentlies = frequentlyDao.findAll();
        frequentlyDao.closeCurrentSession();

        return frequentlies;
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


    public void filterFrequentlyList(){
        if(getStudentFxObjectProperty() != null){
            filterPredicate(predicateStudent());
        }else{
            this.frequentlyFxObservableList.setAll(this.frequentlyFxList);
        }
    }

    private void filterPredicate(Predicate<FrequentlyFx> predicate) {
        List<FrequentlyFx> newList = frequentlyFxList.stream().filter(predicate).collect(Collectors.toList());
        this.frequentlyFxObservableList.setAll(newList);
    }
    private Predicate<FrequentlyFx> predicateStudent() {
        return frequentlyFx -> frequentlyFx.getStudentFxObjectProperty().getStudentId() == getStudentFxObjectProperty().getStudentId();
    }


    /**
     * Metoda zapisuje obecność do bazy danych.
     * @param entity
     */
    public void persist(Frequently entity) {
        frequentlyDao.openCurrentSessionWithTransaction();
        frequentlyDao.persist(entity);
        frequentlyDao.closeCurrentSessionWithTransaction();
    }

    /**
     * Metoda usuwa z bazy danych obecność o podanym id.
     * @param id
     */
    public void delete(long id) {
        frequentlyDao.openCurrentSessionWithTransaction();
        Frequently frequently = frequentlyDao.findById(id);
        frequentlyDao.delete(frequently);
        frequentlyDao.closeCurrentSessionWithTransaction();
    }

    public void deleteFrequently(FrequentlyFx frequentlyFx){
        frequentlyDao.openCurrentSessionWithTransaction();
        delete(frequentlyFx.getFrequentlyId());
        init();
        frequentlyDao.closeCurrentSessionWithTransaction();

    }


    /**
     * Metoda znajduje obecność o podanym id.
     * @param id
     * @return
     */
    public Frequently findById(long id){
        frequentlyDao.openCurrentSession();
        Frequently frequently = frequentlyDao.findById(id);
        frequentlyDao.closeCurrentSession();

        return frequently;
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

    public ObservableList<FrequentlyFx> getFrequentlyFxObservableList() {
        return frequentlyFxObservableList;
    }

    public void setFrequentlyFxObservableList(ObservableList<FrequentlyFx> frequentlyFxObservableList) {
        this.frequentlyFxObservableList = frequentlyFxObservableList;
    }

    public FrequentlyFx getFrequentlyFxObjectProperty() {
        return frequentlyFxObjectProperty.get();
    }

    public ObjectProperty<FrequentlyFx> frequentlyFxObjectPropertyProperty() {
        return frequentlyFxObjectProperty;
    }

    public void setFrequentlyFxObjectProperty(FrequentlyFx frequentlyFxObjectProperty) {
        this.frequentlyFxObjectProperty.set(frequentlyFxObjectProperty);
    }

    public List<FrequentlyFx> getFrequentlyFxList() {
        return frequentlyFxList;
    }

    public void setFrequentlyFxList(List<FrequentlyFx> frequentlyFxList) {
        this.frequentlyFxList = frequentlyFxList;
    }

    public ClassDao getClassDao() {
        return classDao;
    }

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public FrequentlyDao getFrequentlyDao() {
        return frequentlyDao;
    }

    public void setFrequentlyDao(FrequentlyDao frequentlyDao) {
        this.frequentlyDao = frequentlyDao;
    }


}
