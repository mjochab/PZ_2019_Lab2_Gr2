package services;

import Modele.Warns;
import dao.WarnsDAO;

import java.util.List;

public class WarnsService {

    private static WarnsDAO warnsDAO;

    public WarnsService(){
        warnsDAO = new WarnsDAO();
    }

    public List<Warns> findAllStudentWarns(long studentId){
        warnsDAO.openCurrentSession();
        List<Warns> warns = warnsDAO.findAll();
        warnsDAO.closeCurrentSession();
        return warns;
    }
    public List<Warns> findAllWarns(){
        warnsDAO.openCurrentSession();
        List<Warns> warnsList = warnsDAO.findAll();
        warnsDAO.closeCurrentSession();

        return warnsList;
    }

    public Warns findById(long id){
        warnsDAO.openCurrentSession();
        Warns warns = warnsDAO.findById(id);
        warnsDAO.closeCurrentSession();

        return warns;
    }

    public void createWarn(Warns warns){
        warnsDAO.openCurrentSessionWithTransaction();
        warnsDAO.persist(warns);
        warnsDAO.closeCurrentSessionWithTransaction();
    }

    public void removeWarn(Warns warns){
        warnsDAO.openCurrentSessionWithTransaction();
        warnsDAO.delete(warns);
        warnsDAO.closeCurrentSessionWithTransaction();
    }


    public WarnsDAO warnsDao(){
        return warnsDAO;
    }
}
