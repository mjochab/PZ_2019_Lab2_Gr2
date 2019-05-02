package dao;

import Modele.Schedule;
import hibernate.SessionCreator;

import java.util.List;

public class ScheduleDao extends SessionCreator implements Dao<Schedule>{

    @Override
    public void persist(Schedule entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Schedule entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Schedule findById(long id) {
        return (Schedule) getCurrentSession().get(Schedule.class, id);
    }

    @Override
    public void delete(Schedule entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Schedule> findAll() {
        return (List<Schedule>) getCurrentSession().createQuery("from Schedule").list();
    }

    @Override
    public void deleteAll() {
        List<Schedule> students = findAll();
        students.forEach(this::delete);
    }

    @SuppressWarnings("unchecked")
    public List<Schedule> findAllScheduleForClass(long classId){
        List<Schedule> schedules = (List<Schedule>) getCurrentSession().createQuery("from Schedule where class_id = "+classId).list();
        return schedules;
    }
}
