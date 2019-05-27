package services;

import Converters.ClassConverter;
import Modele.Classes;
import dao.ClassDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import modelFX.ClassesFx;

import java.util.List;

public class ClassesService {

    private ClassDao classDao;
    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    /**
     * Konstruktor klasy ClassesService i inicjalizacja ClassDao
     */
    public ClassesService(){
        classDao = new ClassDao();
    }

    public void init(){

        ClassDao classDao = new ClassDao();
        List<Classes> classes = findAllClasses();

        initRoot(classes);
        initClassList(classes);

    }

    private void initRoot(List<Classes> classes){
        this.root.getChildren().clear();


        classes.forEach(c->{
            TreeItem<String> classItem = new TreeItem<>(c.getClassName());
            c.getStudents().forEach(b->{
                 classItem.getChildren().add(new TreeItem<>(b.getFirstName() +" "+ b.getLastName()));
            });
            root.getChildren().add(classItem);
        });

    }

    private void initClassList(List<Classes> classes){
        this.classesFxObservableList.clear();
        classes.forEach(c->{
            ClassesFx classesFx = ClassConverter.convertToClassFx(c);
            this.classesFxObservableList.add(classesFx);
        });
    }


    /**
     * Metoda pobiera wszystkie klasy z bazy danych.
     * @return
     */
    public List<Classes> findAllClasses() {
        classDao.openCurrentSession();
        List<Classes> classes = classDao.findAll();
        classDao.closeCurrentSession();

        return classes;
    }

    /**
     * Meroda zapisuje klase do bazy danych.
     * @param entity
     */
    public void persist(Classes entity) {
        classDao.openCurrentSessionWithTransaction();
        classDao.persist(entity);
        classDao.closeCurrentSessionWithTransaction();
    }

    /**
     * Metoda aktualizuje dane o klasie w bazie danych.
     * @param entity
     */
    public void update(Classes entity) {
        classDao.openCurrentSessionWithTransaction();
        classDao.update(entity);
        classDao.closeCurrentSessionWithTransaction();
    }

    /**
     * Metoda znajduje klase o podanym id.
     * @param id
     * @return
     */
    public Classes findById(long id) {
        classDao.openCurrentSession();
        Classes classes = classDao.findById(id);
        classDao.closeCurrentSession();
        return classes;
    }

    /**
     * Metoda usuwa z bazy danych klase o podanym id.
     * @param id
     */
    public void delete(long id) {
        classDao.openCurrentSessionWithTransaction();
        Classes classes = classDao.findById(id);
        classDao.delete(classes);
        classDao.closeCurrentSessionWithTransaction();
    }


    /**
     * Metoda usuwa wszystkie klasy z bazy danych.
     */
    public void deleteAll() {
        classDao.openCurrentSessionWithTransaction();
        classDao.deleteAll();
        classDao.closeCurrentSessionWithTransaction();
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

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}
