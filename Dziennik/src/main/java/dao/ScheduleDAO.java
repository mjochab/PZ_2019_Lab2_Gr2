package dao;

import Modele.Schedule;
import hibernate.HibernateUtil;

import java.util.List;

public class ScheduleDAO extends HibernateUtil implements DAO<Schedule> {

    @Override
    public Schedule findById(long scheduleId) {
        Schedule schedule = (Schedule) getCurrentSession().get(Schedule.class, scheduleId);
        return schedule;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Schedule> findAll() {
        List<Schedule> schedules = (List<Schedule>) getCurrentSession().createQuery("from Schedule").list();
        return schedules;
    }

    public void deleteById(long scheduleId){
        Schedule schedule = (Schedule) getCurrentSession().get(Schedule.class,scheduleId);
        getCurrentSession().delete(schedule);
    }

    @Override
    public void delete(Schedule schedule) {
        getCurrentSession().delete(schedule);
    }

    @Override
    public void persist(Schedule entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Schedule entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void deleteAll() {
        List<Schedule> entityList = findAll();
        for (Schedule entity : entityList) {
            delete(entity);
        }
    }
}
