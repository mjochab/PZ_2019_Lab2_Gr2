package Controllers;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField nameField;

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
    @FXML
    public void LogIn(ActionEvent actionEvent) throws Exception {
        Window owner = submitButton.getScene().getWindow();

        String person = nameField.getText();
        Parent parent;

        if (nameField.getText().isEmpty()) {
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
        else if(person.equals("Uczeń")) {
            parent = FXMLLoader.load(getClass().getResource("Student.fxml"));
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





}
