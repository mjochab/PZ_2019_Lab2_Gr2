package services;

import Converters.UserConverter;
import Modele.Student;
import Modele.User;
import dao.StudentDao;
import dao.UserDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import modelFX.StudentFx;
import modelFX.UserFx;

public class UserServices {
    private ObjectProperty<UserFx> userFxObjectProperty = new SimpleObjectProperty<>(new UserFx());
    private ObjectProperty<StudentFx> studentFxObjectProperty = new SimpleObjectProperty<>();
    private UserDao userDao = new UserDao();
    private StudentDao studentDao;

    public void persist(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionWithTransaction();
    }
    public void saveUser(){
        userDao.openCurrentSessionWithTransaction();
        User user = UserConverter.convertToUser(this.getUserFxObjectProperty());
        Student student = new Student();
        user.setStudent(student);
        userDao.persist(user);
        userDao.closeCurrentSessionWithTransaction();
    }


    public void update(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionWithTransaction();
    }



    public void delete(long id) {
        userDao.openCurrentSessionWithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionWithTransaction();
    }

    public UserFx getUserFxObjectProperty() {
        return userFxObjectProperty.get();
    }

    public ObjectProperty<UserFx> userFxObjectPropertyProperty() {
        return userFxObjectProperty;
    }

    public void setUserFxObjectProperty(UserFx userFxObjectProperty) {
        this.userFxObjectProperty.set(userFxObjectProperty);
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
}
