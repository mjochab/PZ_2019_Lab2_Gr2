package Controllers;

import Modele.Student;
import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pdf.SchedulePdf;
import services.StudentServices;
import services.SubjectService;
import sessions.UserSession;

import java.io.IOException;

public class StudentScheduleController {
    @FXML
    private Button btnPrintSchedule;

    @FXML
    void printSchedule(ActionEvent event) {

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(UserSession.getInstance().currentUser().getStudent().getStudentId());

        SubjectService subjectService = new SubjectService();

        try {
            String fileName = student.getFirstName() + " " + student.getLastName() + " - plan zajec.pdf ";
            new SchedulePdf().createPdf(fileName, UserSession.getInstance().currentUser().getStudent().getStudentId());
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}


