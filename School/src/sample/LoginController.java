package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private GridPane rootPane;

    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Window owner = submitButton.getScene().getWindow();

        String person = nameField.getText();

       // Do zrobienia logowanie


        if (nameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Błąd", "Podaj login");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Błąd", "Podaj hasło");
            return;
        }

        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Logowanie udane",
                "Witaj " + nameField.getText());


        if(person.equals("Administrator")) {
            GridPane pane = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        if(person.equals("Nauczyciel")) {
            GridPane pane = FXMLLoader.load(getClass().getResource("Teacher.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        if(person.equals("Uczeń")) {
            GridPane pane = FXMLLoader.load(getClass().getResource("Student.fxml"));
            rootPane.getChildren().setAll(pane);
        }


    }


}
