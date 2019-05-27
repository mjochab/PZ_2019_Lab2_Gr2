package Controllers;

import javafx.event.ActionEvent;

public class ToggleButtonMenuAdminController {

    private AdminViewController adminViewController;


    /**
     * Metoda ustawiająca widok zarządzania Uczniami.
     * @param actionEvent
     */
    public void adminUczniowie(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzanieUczniemView.fxml");
    }

    /**
     * Metoda ustawiająca widok zarządzania Nauczycielami.
     * @param actionEvent
     */
    public void adminNauczyciele(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzanieNauczycielemView.fxml");
    }

    /**
     * Metoda ustawiająca widok zarządzania Przedmiotami.
     * @param actionEvent
     */
    public void adminPrzedmioty(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzaniePrzedmiotemView.fxml");
    }

    /**
     * Metoda ustawiająca widok zarządzania Klasami.
     * @param actionEvent
     */
    public void adminKlasy(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzanieKlasaView.fxml");
    }

    /**
     * Metoda ustawiająca widok zarządzania Planem.
     * @param actionEvent
     */
    public void adminPlan(ActionEvent actionEvent) {
        adminViewController.setCenter("/FXML/AdminZarzadzaniePlanemView.fxml");
    }

    public void setAdminViewController(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
    }
}
