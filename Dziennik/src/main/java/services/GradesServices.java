package services;

import Converters.ClassConverter;
import Converters.SubjectConverter;
import Modele.Classes;
import Modele.Grades;
import Modele.Student;
import Modele.Subject;
import dao.ClassDao;
import dao.GradeDao;
import dao.StudentDao;
import dao.SubjectDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.ClassesFx;
import modelFX.GradesFx;
import modelFX.StudentFx;
import modelFX.SubjectFx;

import java.util.List;

public class GradesServices {

    private ClassDao classDao;
    private GradeDao gradeDao;
    private SubjectDao subjectDao;
    private StudentDao studentDao = new StudentDao();
    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<GradesFx> gradesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<GradesFx> gradesFxObservableList = FXCollections.observableArrayList();


    public GradesServices() {
        gradeDao = new GradeDao();
    }

    public void init(){
        gradeDao = new GradeDao();
        initCbClass();
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
    public List<Subject> findAllSubject() {
        subjectDao.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        subjectDao.closeCurrentSession();

        return subjects;
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
    public List<Grades> findAllStudentGrades(long studentId){
        gradeDao.openCurrentSession();
        List<Grades> gradesList = gradeDao.findAllGradesOfStudent(studentId);
        gradeDao.closeCurrentSession();
        return gradesList;
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
        gradeDao.openCurrentSession();
        List<Grades> grades = gradeDao.findAll();
        gradeDao.closeCurrentSession();

        return grades;
    }





    public void persist(Grades entity) {
        gradeDao.openCurrentSessionWithTransaction();
        gradeDao.persist(entity);
        gradeDao.closeCurrentSessionWithTransaction();
    }


    public void update(Grades entity) {
        gradeDao.openCurrentSessionWithTransaction();
        gradeDao.update(entity);
        gradeDao.closeCurrentSessionWithTransaction();
    }


    public Grades findById(long id) {
        gradeDao.openCurrentSession();
        Grades grades = gradeDao.findById(id);
        gradeDao.closeCurrentSession();
        return grades;
    }


    public void delete(long id) {
        gradeDao.openCurrentSessionWithTransaction();
        Grades grades = gradeDao.findById(id);
        gradeDao.delete(grades);
        gradeDao.closeCurrentSessionWithTransaction();
    }


    public void deleteAll() {
        gradeDao.openCurrentSessionWithTransaction();
        gradeDao.deleteAll();
        gradeDao.closeCurrentSessionWithTransaction();
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

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public GradeDao getGradesDao() {
        return gradeDao;
    }

    public void setGradesDao(GradeDao gradesDao) {
        this.gradeDao = gradesDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
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

    public ObservableList<GradesFx> getGradesFxObservableList() {
        return gradesFxObservableList;
    }

    public void setGradesFxObservableList(ObservableList<GradesFx> gradesFxObservableList) {
        this.gradesFxObservableList = gradesFxObservableList;
    }
}
