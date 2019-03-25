package Controllers;

import javafx.event.ActionEvent;

public class ToggleButtonMenuStudentController {

    private StudentViewController studentViewController;



    public void studentOceny(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentOcenyView.fxml");
    }

    public void studentNieobecnosci(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentNieobecnosciView.fxml");
    }

    public void studentDrukowanie(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentPlanView.fxml");
    }


    public void setStudentViewController(StudentViewController studentViewController) {
        this.studentViewController = studentViewController;
    }
}
