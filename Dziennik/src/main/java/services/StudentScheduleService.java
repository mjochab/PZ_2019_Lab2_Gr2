package services;

import Modele.Schedule;
import dao.ScheduleDao;
import dao.SubjectDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.ClassesFx;
import modelFX.ScheduleFx;
import modelFX.SubjectFx;
import sessions.UserSession;

import java.util.ArrayList;
import java.util.List;

public class StudentScheduleService {

    private ObservableList<ScheduleFx> scheduleFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ScheduleFx> scheduleFxObjectProperty = new SimpleObjectProperty<>(new ScheduleFx());
    private ObservableList<ClassesFx> classesFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ClassesFx> classesFxObjectProperty = new SimpleObjectProperty<>();
    private ObservableList<SubjectFx> subjectFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<SubjectFx> subjectFxObjectProperty = new SimpleObjectProperty<>();

    private List<ScheduleFx> scheduleFxList = new ArrayList<>();
    private SubjectDao subjectDao;
    private ScheduleDao scheduleDao;



    public void init(){
        scheduleDao = new ScheduleDao();


    }


    public List<Schedule> findAllSchedules(){
        scheduleDao.openCurrentSession();
        List<Schedule> schedules = scheduleDao.findAllScheduleForClass(UserSession.getInstance().currentUser().getStudent().getClasses().getClassId());
        scheduleDao.closeCurrentSession();

        return schedules;
    }
}
