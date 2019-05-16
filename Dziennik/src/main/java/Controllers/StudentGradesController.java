package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelFX.GradesFx;
import modelFX.SubjectFx;
import services.StudentGradeService;

import java.util.Date;

public class StudentGradesController {
    @FXML
    private ComboBox<SubjectFx> cbSubject;

    @FXML
    private Button buttonPrint;

    @FXML
    private TableView<GradesFx> gradeTableView;

    @FXML
    private TableColumn<GradesFx, SubjectFx> columnSubject;

    @FXML
    private TableColumn<GradesFx, String> columnType;

    @FXML
    private TableColumn<GradesFx, Date> columnDate;

    @FXML
    private TableColumn<GradesFx, Double> columnGrade;

    private StudentGradeService studentGradeService;



    @FXML
    void initialize() {
        studentGradeService = new StudentGradeService();
        studentGradeService.init();

        this.cbSubject.setItems(this.studentGradeService.getSubjectFxObservableList());
        this.studentGradeService.subjectFxObjectPropertyProperty().bind(this.cbSubject.valueProperty());

        this.gradeTableView.setItems(this.studentGradeService.getGradesFxObservableList());
        this.columnSubject.setCellValueFactory(cellData -> cellData.getValue().subjectFxObjectPropertyProperty());
        this.columnType.setCellValueFactory(cellData -> cellData.getValue().detailsProperty());
        this.columnDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        this.columnGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty().asObject());

    }










    @FXML
    void comboBoxSubject(ActionEvent event) {
        this.studentGradeService.filterGradesList();

    }

    @FXML
    void printGrades(ActionEvent event) {

    }
}
