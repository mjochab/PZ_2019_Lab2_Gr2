package Controllers;

import javafx.event.ActionEvent;

public class ToggleButtonMenuNauczycielController {

    private NauczycielViewController nauczycielViewController;


    /**
     * Metoda ustawiająca widok zarządzania Ocenami.
     * @param actionEvent
     */
    public void nauczycielOceny(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NauczycielOcenyView.fxml");
    }

    /**
     * Metoda ustawiająca widok zarządzania Uwagami.
     * @param actionEvent
     */
    public void nauczycielUwagi(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NauczycielUwagiView.fxml");
    }

    /**
     * Metoda ustawiająca widok zarządzania Obecnością.
     * @param actionEvent
     */
    public void nauczycielObecnosc(ActionEvent actionEvent) {
        nauczycielViewController.setCenter("/FXML/NauczycielObecnośćView.fxml");
    }


    public void setNauczycielViewController(NauczycielViewController nauczycielViewController) {
        this.nauczycielViewController = nauczycielViewController;
    }
}
