package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class ToggleButtonMenuAdminController {

    private AdminViewController adminViewController;



    public void adminUczniowie(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzanieUczniemView.fxml");
    }

    public void adminNauczyciele(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzanieNauczycielemView.fxml");
    }

    public void adminPrzedmioty(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzaniePrzedmiotemView.fxml");
    }

    public void adminKlasy(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzanieKlasaView.fxml");
    }

    public void adminPlan(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzaniePlanemView.fxml");
    }

    public void setAdminViewController(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
    }
}
