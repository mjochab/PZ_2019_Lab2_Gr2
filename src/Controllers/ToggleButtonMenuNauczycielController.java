package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class ToggleButtonMenuNauczycielController {

    private NauczycielViewController nauczycielViewController;



    public void nauczycielOceny(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NauczycielOcenyView.fxml");
    }

    public void nauczycielUwagi(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NauczycielUwagiView.fxml");
    }

    public void nauczycielObecnosc(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NauczycielObecnośćView.fxml");
    }

    public void nauczycielPlan(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NayczycielPlanView.fxml");
    }


    public void setNauczycielViewController(NauczycielViewController nauczycielViewController) {
        this.nauczycielViewController = nauczycielViewController;
    }
}
