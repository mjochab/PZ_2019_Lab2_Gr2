package services;

import Modele.User;
import dao.UserDao;

public class UserServices {

    private UserDao userDao;

    public void persist(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.persist(entity);
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
}
