package services;

import Converters.SubjectConverter;
import Modele.Subject;
import dao.SubjectDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import modelFX.SubjectFx;

import java.util.List;

public class SubjectService {

    private SubjectDao subjectDao;
    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();

    public SubjectService(){
        subjectDao = new SubjectDao();
    }

    public void init(){

        SubjectDao subjectDao = new SubjectDao();
        List<Subject> subjects = findAllSubjects();

        initRoot(subjects);
        initClassList(subjects);
    }

    private void initRoot(List<Subject> subjects){
        this.root.getChildren().clear();

        subjects.forEach(c->{
            TreeItem<String> subjectItem = new TreeItem<>(c.getSubjectName());
            c.getTeachers().forEach(b->{
                subjectItem.getChildren().add(new TreeItem<>(b.getFirstName() +" "+ b.getLastName()));
            });
            root.getChildren().add(subjectItem);
        });
    }

    private void initClassList(List<Subject> subjects){
        this.subjectFxObservableList.clear();
        subjects.forEach(c->{
            SubjectFx subjectFx = SubjectConverter.convertToSubjectFx(c);
            this.subjectFxObservableList.add(subjectFx);
        });
    }


    public List<Subject> findAllSubjects() {
        subjectDao.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        subjectDao.closeCurrentSession();

        return subjects;
    }


    public void persist(Subject entity) {
        subjectDao.openCurrentSessionWithTransaction();
        subjectDao.persist(entity);
        subjectDao.closeCurrentSessionWithTransaction();
    }

    public void delete(long id) {
        subjectDao.openCurrentSessionWithTransaction();
        Subject subject = subjectDao.findById(id);
        subjectDao.delete(subject);
        subjectDao.closeCurrentSessionWithTransaction();
    }

    public ObservableList<SubjectFx> getSubjectFxObservableList() {
        return subjectFxObservableList;
    }

    public ObjectProperty<SubjectFx> subjectFxObjectProperty() {
        return subjectFxObjectProperty;
    }

    public void setSubjectFxObjectProperty(SubjectFx subjectFxObjectProperty) {
        this.subjectFxObjectProperty.set(subjectFxObjectProperty);
    }

    public TreeItem<String> getRoot() {
        return root;
    }
}
