package Controllers;

import javafx.event.ActionEvent;

public class ToggleButtonMenuStudentController {

    private StudentViewController studentViewController;


    /**
     * Metoda ustawiająca widok przeglądania Ocen.
     * @param actionEvent
     */
    public void studentOceny(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentOcenyView.fxml");
    }

    /**
     * Metoda ustawiająca widok przeglądania Nieobecności.
     * @param actionEvent
     */
    public void studentNieobecnosci(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentNieobecnosciView.fxml");
    }

    /**
     * Metoda ustawiająca widok przeglądania Uwag.
     * @param actionEvent
     */
    public void studentUwagi(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentUwagiView.fxml");
    }

    /**
     * Metoda ustawiająca widok Drukowania.
     * @param actionEvent
     */
    public void studentDrukowanie(ActionEvent actionEvent) {
        studentViewController.setCenter("/FXML/StudentPlanView.fxml");
    }


    public void setStudentViewController(StudentViewController studentViewController) {
        this.studentViewController = studentViewController;
    }


}
