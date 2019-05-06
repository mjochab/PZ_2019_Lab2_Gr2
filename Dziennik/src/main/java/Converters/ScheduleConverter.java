package Converters;

import Modele.Schedule;
import modelFX.ScheduleFx;

public class ScheduleConverter {

    public static ScheduleFx convertToScheduleFx(Schedule schedule){
        ScheduleFx scheduleFx = new ScheduleFx();
        scheduleFx.setDay(schedule.getDay());
        scheduleFx.setTime(schedule.getTime());
        scheduleFx.setRoom(schedule.getRoom());
        scheduleFx.setSheduleId(schedule.getlessonId());
        scheduleFx.setClassesFxObjectProperty(ClassConverter.convertToClassFx(schedule.getClas()));
        scheduleFx.setSubjectFxObjectProperty(SubjectConverter.convertToSubjectFx(schedule.getSubjects()));
        return scheduleFx;
    }

    public static Schedule convertToSchedule(ScheduleFx scheduleFx){
        Schedule schedule = new Schedule();
        schedule.setlessonId(scheduleFx.getSheduleId());
        schedule.setDay(scheduleFx.getDay());
        schedule.setTime(scheduleFx.getTime());
        schedule.setRoom(scheduleFx.getRoom());
        return schedule;

    }
}
