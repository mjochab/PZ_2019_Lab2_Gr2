package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class ToggleButtonMenuNauczycielController {

    private NauczycielViewController nauczycielViewController;



    public void nauczcielOceny(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/NauczycielOcenyView.fxml");
    }

    public void nauczycielUwagi(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/NauczycielUwagiView.fxml");
    }

    public void nauczycielObecnosc(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/NauczycielObecnośćView.fxml");
    }

    public void nauczycielPlan(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/NayczycielPlanView.fxml");
    }


    public void setAdminViewController(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
    }
}
