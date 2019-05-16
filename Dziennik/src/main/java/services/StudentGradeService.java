package services;

import Converters.GradesConventer;
import Converters.SubjectConverter;
import Modele.Grades;
import Modele.Subject;
import dao.GradeDao;
import dao.SubjectDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.GradesFx;
import modelFX.SubjectFx;
import sessions.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentGradeService {

    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<GradesFx> gradesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<GradesFx> gradesFxObjectProperty = new SimpleObjectProperty<>(new GradesFx());

    private List<GradesFx> gradesFxList = new ArrayList<>();

    private SubjectDao subjectDao;
    private GradeDao gradeDao;

    public void init(){
        gradeDao =  new GradeDao();
        List<Grades> grades = findAllGrades();
        gradesFxList.clear();
        grades.forEach(grades1 -> this.gradesFxList.add(GradesConventer.convertToGradesFx(grades1)));
        this.gradesFxObservableList.setAll(gradesFxList);

        initCbSubject();
    }

    private void initCbSubject(){
        subjectDao = new SubjectDao();
        List<Subject> subjectList = findAllSubject();
        subjectFxObservableList.clear();
        subjectList.forEach(c->{
            SubjectFx subjectFx = SubjectConverter.convertToSubjectFx(c);
            subjectFxObservableList.add(subjectFx);
        });
    }




    public List<Grades> findAllGrades(){
        gradeDao.openCurrentSession();
        List<Grades> grades = gradeDao.findAllGradesOfStudent(UserSession.getInstance().currentUser().getStudent().getStudentId());
        gradeDao.closeCurrentSession();

        return grades;
    }

    public List<Subject> findAllSubject() {
        subjectDao.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        subjectDao.closeCurrentSession();

        return subjects;
    }


    public void filterGradesList(){
        if(getGradesFxObjectProperty() != null){
            filterPredicate(predicateGrade());
        }else{
            this.gradesFxObservableList.setAll(this.gradesFxList);
        }
    }



    private void filterPredicate(Predicate<GradesFx> predicate) {
        List<GradesFx> newList = gradesFxList.stream().filter(predicate).collect(Collectors.toList());
        this.gradesFxObservableList.setAll(newList);
    }
    private Predicate<GradesFx> predicateGrade() {
        return gradesFx -> gradesFx.getSubjectFxObjectProperty().getSubjectId() == getSubjectFxObjectProperty().getSubjectId();
    }

    public ObservableList<SubjectFx> getSubjectFxObservableList() {
        return subjectFxObservableList;
    }

    public void setSubjectFxObservableList(ObservableList<SubjectFx> subjectFxObservableList) {
        this.subjectFxObservableList = subjectFxObservableList;
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

    public ObservableList<GradesFx> getGradesFxObservableList() {
        return gradesFxObservableList;
    }

    public void setGradesFxObservableList(ObservableList<GradesFx> gradesFxObservableList) {
        this.gradesFxObservableList = gradesFxObservableList;
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

    public List<GradesFx> getGradesFxList() {
        return gradesFxList;
    }

    public void setGradesFxList(List<GradesFx> gradesFxList) {
        this.gradesFxList = gradesFxList;
    }
}
