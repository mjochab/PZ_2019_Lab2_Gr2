package services;

import Converters.ClassConverter;
import Converters.ScheduleConverter;
import Converters.SubjectConverter;
import Modele.Classes;
import Modele.Schedule;
import Modele.Subject;
import dao.ClassDao;
import dao.ScheduleDao;
import dao.SubjectDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.ClassesFx;
import modelFX.ScheduleFx;
import modelFX.SubjectFx;

import java.util.ArrayList;
import java.util.List;

public class ScheduleService {

    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<ScheduleFx> scheduleFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ScheduleFx> scheduleFxObjectProperty = new SimpleObjectProperty<>(new ScheduleFx());

    private List<ScheduleFx> scheduleFxList = new ArrayList<>();
    private ScheduleDao scheduleDao;
    private SubjectDao subjectDao;
    private ClassDao classDao;

    /**
     * Konstruktor klasy ScheduleService i inicjalizacja ScheduleDao
     */
    public ScheduleService(){
        scheduleDao = new ScheduleDao();
    }


    public void init(){
        scheduleDao =  new ScheduleDao();
        List<Schedule> schedules = findAllSchedule();
        scheduleFxList.clear();
        schedules.forEach(schedule -> this.scheduleFxList.add(ScheduleConverter.convertToScheduleFx(schedule)));
        this.scheduleFxObservableList.setAll(scheduleFxList);

        initClassList();
        initSubjectList();
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

    private void initSubjectList(){
        subjectDao = new SubjectDao();
        List<Subject> subjectList = findAllSubject();
        subjectFxObservableList.clear();
        subjectList.forEach(c->{
            SubjectFx subjectFx = SubjectConverter.convertToSubjectFx(c);
            subjectFxObservableList.add(subjectFx);
        });
    }

    /**
     * Metoda zapisuje obecność do bazy danych.
     * @param entity
     */
    public void persist(Schedule entity) {
        scheduleDao.openCurrentSessionWithTransaction();
        scheduleDao.persist(entity);
        scheduleDao.closeCurrentSessionWithTransaction();
    }

    /**
     * Metoda aktualizuje dane o obecności w bazie danych.
     * @param entity
     */
    public void update(Schedule entity) {
        scheduleDao.openCurrentSessionWithTransaction();
        scheduleDao.update(entity);
        scheduleDao.closeCurrentSessionWithTransaction();
    }


    /**
     * Metoda usuwa z bazy danych obecność o podanym id
     * @param id
     */
    public void delete(long id) {
        scheduleDao.openCurrentSessionWithTransaction();
        Schedule schedule = scheduleDao.findById(id);
        scheduleDao.delete(schedule);
        scheduleDao.closeCurrentSessionWithTransaction();
    }

    public void deleteSchedule(ScheduleFx scheduleFx){
        scheduleDao.openCurrentSessionWithTransaction();
        delete(scheduleFx.getSheduleId());
        init();
        scheduleDao.closeCurrentSessionWithTransaction();

    }

    public List<Schedule> findAllSchedule(){
        scheduleDao.openCurrentSession();
        List<Schedule> schedules = scheduleDao.findAll();
        scheduleDao.closeCurrentSession();

        return schedules;
    }
    public List<Classes> findAllClasses() {
        classDao.openCurrentSession();
        List<Classes> classes = classDao.findAll();
        classDao.closeCurrentSession();

        return classes;
    }

    public List<Subject> findAllSubject() {
        subjectDao.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        subjectDao.closeCurrentSession();

        return subjects;
    }

    /**
     * Metoda znajduje obecnośc o podanym id.
     * @param id
     * @return schedule
     */
    public Schedule findById(long id){
        scheduleDao.openCurrentSession();
        Schedule schedule = scheduleDao.findById(id);
        scheduleDao.closeCurrentSession();

        return schedule;
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

    public ObservableList<ScheduleFx> getScheduleFxObservableList() {
        return scheduleFxObservableList;
    }

    public void setScheduleFxObservableList(ObservableList<ScheduleFx> scheduleFxObservableList) {
        this.scheduleFxObservableList = scheduleFxObservableList;
    }

    public ScheduleFx getScheduleFxObjectProperty() {
        return scheduleFxObjectProperty.get();
    }

    public ObjectProperty<ScheduleFx> scheduleFxObjectPropertyProperty() {
        return scheduleFxObjectProperty;
    }

    public void setScheduleFxObjectProperty(ScheduleFx scheduleFxObjectProperty) {
        this.scheduleFxObjectProperty.set(scheduleFxObjectProperty);
    }

    public List<ScheduleFx> getScheduleFxList() {
        return scheduleFxList;
    }

    public void setScheduleFxList(List<ScheduleFx> scheduleFxList) {
        this.scheduleFxList = scheduleFxList;
    }

    public ScheduleDao getScheduleDao() {
        return scheduleDao;
    }

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public ClassDao getClassDao() {
        return classDao;
    }

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }
}
