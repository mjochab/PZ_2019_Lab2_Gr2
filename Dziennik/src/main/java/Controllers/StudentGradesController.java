package Controllers;

import Modele.Student;
import com.itextpdf.text.DocumentException;
import dao.GradeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelFX.GradesFx;
import modelFX.SubjectFx;
import pdf.PdfGenerator;
import services.StudentGradeService;
import services.StudentServices;
import services.SubjectService;
import sessions.UserSession;

import java.io.IOException;
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

    private GradeDao gradeDao;

    /**
     * Inicjacja klasy kontrolera.
     */
    @FXML
    void initialize() {
        gradeDao = new GradeDao();
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

    /**
     * Metoda generująca PDF'a z ocenami ucznia.
     * @param event
     */
    @FXML
    void printGrades(ActionEvent event) {
        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(UserSession.getInstance().currentUser().getStudent().getStudentId());

        SubjectService subjectService = new SubjectService();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Generowanie PDF");
        alert.setHeaderText(null);
        alert.setContentText("Jesteś pewien, że chcesz wygenerować PDF dla ucznia: "+student.getFirstName()+" "+student.getLastName()+ "?");

        ButtonType buttonTypeNo = new ButtonType("Nie");
        ButtonType buttonTypeYes = new ButtonType("Tak");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        alert.showAndWait().ifPresent(rs -> {
            if (rs == buttonTypeYes) {
                try {
                    String fileName = student.getFirstName()+" "+student.getLastName()+" - wykaz ocen.pdf ";
                    new PdfGenerator().createPdf(fileName, UserSession.getInstance().currentUser().getStudent().getStudentId());
                } catch (IOException | DocumentException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
