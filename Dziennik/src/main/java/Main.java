import Controllers.LoginController;
import Modele.Admin;
import Modele.Teacher;
import Modele.User;
import hibernate.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        LoginController.createStartView(primaryStage,root);
      // primaryStage.show();


        //Test zapisu usera do bazy

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
/*
        User user = new User();
        user.setLogin("test1");
        user.setHaslo("test1");

        Admin admin = new Admin();
        admin.setImieAdmin("admin1");
        admin.setNazwiskoAdmin("admin1");
        admin.setUser(user);
        session.save(user);
        session.save(admin);


        Teacher teacher = new Teacher();
        teacher.setImieTeacher("teacher1");
        teacher.setNazwiskoTeacher("teacher1");


        session.save(teacher);
        session.getTransaction().commit();

        session.close();
*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
