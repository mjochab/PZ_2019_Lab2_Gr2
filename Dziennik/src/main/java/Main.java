import Controllers.LoginController;
import Modele.Admin;
import Modele.User;
import hibernate.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import services.UserServices;

public class Main extends Application {

    private UserServices userServices;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        LoginController.createStartView(primaryStage,root);





        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User();
        user.setUserId(1);
        user.setLinkedAcc("A");
        user.setUsername("admin");
        user.setPasswrd("admin");

        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setFirstNameA("admin");
        admin.setLastNameA("admin");
        admin.setLinkedAcc("A");

        admin.setUser(user);
        user.setAdmin(admin);


        session.saveOrUpdate(user);
        session.getTransaction().commit();

        session.close();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
