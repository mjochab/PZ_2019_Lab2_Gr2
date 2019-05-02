package services;

import Converters.SubjectConverter;
import Converters.TeacherConverter;
import Modele.Subject;
import Modele.Teacher;
import dao.SubjectDao;
import dao.TeacherDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.SubjectFx;
import modelFX.TeacherFx;

import java.util.ArrayList;
import java.util.List;

public class TeacherServices {
    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<TeacherFx> teacherFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<TeacherFx> teacherFxObjectProperty = new SimpleObjectProperty<>(new TeacherFx());

    private List<TeacherFx> teacherFxList = new ArrayList<>();
    private TeacherDao teacherDao;
    private SubjectDao subjectDao;

    public TeacherServices(){
        teacherDao = new TeacherDao();
    }

    public void init(){
        teacherDao =  new TeacherDao();
        List<Teacher> teachers = findAllTeachers();
        teacherFxList.clear();
        teachers.forEach(teacher -> this.teacherFxList.add(TeacherConverter.convertToTeacherFx(teacher)));
        this.teacherFxObservableList.setAll(teacherFxList);

        initSubjectList();
    }

    private void initSubjectList(){
        subjectDao = new SubjectDao();
        List<Subject> subjectList = findAllSubject();
        subjectFxObservableList.clear();
        subjectList.forEach(c->{
            SubjectFx subjectFx = SubjectConverter.convertToSubjectFx(c);
            subjectFxObservableList.add(subjectFx);
        });
    }

    public void persist(Teacher entity) {
        teacherDao.openCurrentSessionWithTransaction();
        teacherDao.persist(entity);
        teacherDao.closeCurrentSessionWithTransaction();
    }

    public void delete(long id) {
        teacherDao.openCurrentSessionWithTransaction();
        Teacher teacher = teacherDao.findById(id);
        teacherDao.delete(teacher);
        teacherDao.closeCurrentSessionWithTransaction();
    }

    public void deleteTeacher(TeacherFx teacherFx){
        teacherDao.openCurrentSessionWithTransaction();
        delete(teacherFx.getTeacherId());
        init();
        teacherDao.closeCurrentSessionWithTransaction();

    }

    public List<Teacher> findAllTeachers(){
        teacherDao.openCurrentSession();
        List<Teacher> teachers = teacherDao.findAll();
        teacherDao.closeCurrentSession();

        return teachers;
    }
    public List<Subject> findAllSubject() {
        teacherDao.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        teacherDao.closeCurrentSession();

        return subjects;
    }

    public Teacher findById(long id){
        teacherDao.openCurrentSession();
        Teacher teacher = teacherDao.findById(id);
        teacherDao.closeCurrentSession();

        return teacher;
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

    public List<TeacherFx> getTeacherFxList() {
        return teacherFxList;
    }

    public void setTeacherFxList(List<TeacherFx> teacherFxList) {
        this.teacherFxList = teacherFxList;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
}
