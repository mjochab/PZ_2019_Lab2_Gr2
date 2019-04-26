package services;

import Converters.ConverterClass;
import Modele.Classes;
import dao.ClasDAO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import modelFX.ClasFx;

import java.util.List;

public class ClassesService {

    private ObservableList<ClasFx> clasFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClasFx> clasFxObjectProperty = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();
    private static ClasDAO clasDAO;


    public void init(){
        ClasDAO clasDAO = new ClasDAO();
        List<Classes> classes = clasDAO.findAll();
        initClassList(classes);
        initRoot(classes);

    }

    private void initRoot(List<Classes> classes){
        this.root.getChildren().clear();
        classes.forEach(c->{
            TreeItem<String> treeItem = new TreeItem<>(c.getClassName());
            c.getStudents().forEach(b->{
                treeItem.getChildren().add(new TreeItem<>(b.getFirstName() + b.getLastName()));
            });
            root.getChildren().add(treeItem);
        });
    }

    private void initClassList(List<Classes> classes){
        this.clasFxObservableList.clear();
        classes.forEach(c->{
            ClasFx clasFx = ConverterClass.convertToClassFX(c);
            this.clasFxObservableList.add(clasFx);
        });
    }
    /*
    public void persist(Classes entity) {
        clasDAO().openCurrentSessionWithTransaction();
        clasDAO.persist(entity);
        clasDAO.closeCurrentSessionWithTransaction();
    }
*/

    public void saveClassInDataBase(String name){
        clasDAO.openCurrentSessionWithTransaction();
        Classes classes = new Classes();
        classes.setClassName(name);
        clasDAO.persist(classes);
        init();
        clasDAO.closeCurrentSessionWithTransaction();
    }

    public void updateClasInDataBase(Classes entity){
        clasDAO.openCurrentSessionWithTransaction();
        clasDAO.update(entity);
        clasDAO.closeCurrentSessionWithTransaction();

    }

    public void delete() {
        clasDAO.openCurrentSessionWithTransaction();
        clasDAO.deleteById(clasFxObjectProperty.getValue().getClassId());
        init();
        clasDAO.closeCurrentSessionWithTransaction();
    }

/*
    public void deleteClassById(){
        ClasDAO clasDAO= new ClasDAO();
        clasDAO.deleteById(clasFxObjectProperty.getValue().getClassId());
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.de
    }
    */

    public ClassesService(){
        clasDAO = new ClasDAO();
    }

    public ClasDAO clasDAO(){
        return clasDAO;
    }

    public Classes findById(long clasId){
        clasDAO.openCurrentSession();
        Classes classes = clasDAO.findById(clasId);
        clasDAO.closeCurrentSession();

        return classes;
    }
    public List<Classes> listOfClasses(){
        clasDAO.openCurrentSession();
        List<Classes> classes = clasDAO.findAll();
        clasDAO.closeCurrentSession();

        return classes;
    }

    public ObservableList<ClasFx> getClasFxObservableList() {
        return clasFxObservableList;
    }

    public void setClasFxObservableList(ObservableList<ClasFx> clasFxObservableList) {
        this.clasFxObservableList = clasFxObservableList;
    }

    public ClasFx getClasFxObjectProperty() {
        return clasFxObjectProperty.get();
    }

    public ObjectProperty<ClasFx> clasFxObjectPropertyProperty() {
        return clasFxObjectProperty;
    }

    public void setClasFxObjectProperty(ClasFx clasFxObjectProperty) {
        this.clasFxObjectProperty.set(clasFxObjectProperty);
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }

    public static ClasDAO getClasDAO() {
        return clasDAO;
    }

    public static void setClasDAO(ClasDAO clasDAO) {
        ClassesService.clasDAO = clasDAO;
    }
}
