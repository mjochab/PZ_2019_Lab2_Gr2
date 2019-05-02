package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import modelFX.SubjectFx;

import java.awt.*;

public class AdminTeacherController {
    @FXML
    private TextField lbTeacherName;

    @FXML
    private TextField lbTeacherNAme;

    @FXML
    private TextField lbPasswordT;

    @FXML
    private TextField lbLoginT;

    @FXML
    private ComboBox<SubjectFx> cbSubject;

    @FXML
    private Button buttonAdd;
    
    @FXML
    private Button buttonModify;

    public void addTeacher(ActionEvent actionEvent) {
    }

    public void modifyTeacher(ActionEvent actionEvent) {
    }
}
