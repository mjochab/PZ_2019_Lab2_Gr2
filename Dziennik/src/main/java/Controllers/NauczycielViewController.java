package Controllers;

import Modele.Admin;
import Modele.Student;
import Modele.Teacher;
import Modele.User;
import hibernate.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import sessions.UserSession;

import java.io.IOException;
import java.util.List;


public class NauczycielViewController  {
    @FXML
    private BorderPane borderPane1;
    @FXML
    private ToggleButtonMenuNauczycielController toggleButtonMenuNauczycielController;
    @FXML
    private Label sessionInfo;

    private List<?> userInitialized;
    private User user = UserSession.getInstance().currentUser();

    @FXML
    private void initialize(){
        toggleButtonMenuNauczycielController.setNauczycielViewController(this);
        initUser();
    }
    private String parseUserType(String user){
        String userType = "";

        switch(user.charAt(0)){
            case 'T':
                userType = "Teacher";
                break;
            case 'A':
                userType = "Admin";
                break;
            case 'S':
                userType = "Student";
                break;
        }

        return userType;
    }
    public void initUser(){
        String userType = parseUserType(user.getLinkedAcc());

        if(!"".equals(userType)){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from "+userType+" where linked_acc = :acc");
            query.setParameter("acc", user.getLinkedAcc());
            userInitialized = query.list();
            session.close();
        } else {
            System.err.println("User cannot be initialized caused user "+userType+" is empty or doesn't exists!");
        }

        if(parseUserType(user.getLinkedAcc()).equals("Student")){
            Student student = (Student) userInitialized.get(0);
            sessionInfo.setText(student.getFirstName()+ " " + student.getLastName());
        } else if(parseUserType(user.getLinkedAcc()).equals("Teacher")){
            Teacher teacher = (Teacher) userInitialized.get(0);
            sessionInfo.setText(teacher.getFirstName()+" "+teacher.getLastName());
        } else if (parseUserType(user.getLinkedAcc()).equals("Admin")){
            Admin admin = (Admin) userInitialized.get(0);
            sessionInfo.setText(admin.getFirstNameA()+" "+admin.getLastNameA());
        }
    }

    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try{
            parent = loader.load();

        }catch(IOException e){
            e.printStackTrace();
        }
        borderPane1.setCenter(parent);
    }

    public void btnWyloguj(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }
}
