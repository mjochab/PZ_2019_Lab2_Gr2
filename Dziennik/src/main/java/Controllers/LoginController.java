package Controllers;

import Modele.User;
import hibernate.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


import org.hibernate.Query;
import org.hibernate.Session;
import sessions.UserSession;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static void createStartView(Stage primaryStage, Parent root) {
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.getIcons().add());
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /*
    @FXML
    public void LogIn(ActionEvent actionEvent) throws Exception {
        Window owner = submitButton.getScene().getWindow();

        String person = loginField.getText();
        Parent parent;

        if (loginField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Błąd", "Podaj login");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Błąd", "Podaj hasło");
            return;
        }

      // AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Logowanie udane",
          //     "Witaj " + nameField.getText());


        if(person.equals("Admin")) {
            parent = FXMLLoader.load(getClass().getResource("/FXML/AdminView.fxml"));
            //rootPane.getChildren().setAll(pane);
        }
        else if(person.equals("Nauczyciel")) {
            parent = FXMLLoader.load(getClass().getResource("/FXML/NauczycielView.fxml"));
            //rootPane.getChildren().setAll(pane);
        }
        else if(person.equals("Student")) {
            parent = FXMLLoader.load(getClass().getResource("/FXML/StudentView.fxml"));
            //rootPane.getChildren().setAll(pane);
        }
        else {
            throw new Exception("Problem załadowania modułu");
        }


        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }
    */

    private boolean authorizeUser(String username, String passwrd){
        String user = "User";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from "+user+" where upper(username) = :username and passwrd = :passwd");
        query.setParameter("username", username.toUpperCase());
        query.setParameter("passwd", passwrd);

        if(query.list().isEmpty()){
            return false;
        } else {
            List<?> list = query.list();
            User userAccount = (User)list.get(0);
            UserSession.getInstance().setCurrentUser(userAccount);

            return true;
        }
    }



    @FXML
    private void LogIn(ActionEvent event) throws Exception {
        if(authorizeUser(loginField.getText(), passwordField.getText())){
            Parent parent;
            char userType = UserSession.getInstance().currentUser().getLinkedAcc().charAt(0);

            if(userType == 'T'){
                parent = FXMLLoader.load(getClass().getResource("/FXML/NauczycielView.fxml"));
            } else if(userType == 'S') {
                parent = FXMLLoader.load(getClass().getResource("/FXML/StudentView.fxml"));
            } else if(userType == 'A') {
                parent = FXMLLoader.load(getClass().getResource("/FXML/AdminView.fxml"));
            } else {
                throw new Exception("Problem załadowania modułu");
            }

            Scene scene = new Scene(parent);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Bład logowania");
            alert.setHeaderText(null);
            alert.setContentText("Podane hasło/nazwa użytkownika jest niepoprawna.");
            alert.showAndWait();
        }
    }





}
