package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelFX.FrequentlyFx;
import services.StudentFrequentlyService;

import java.util.Date;

public class StudentFrequentlyController {
    @FXML
    private Label lbNumber;

    @FXML
    private TableView<FrequentlyFx> frequentlyTableView;

    @FXML
    private TableColumn<FrequentlyFx, Date> columnDate;

    @FXML
    private TableColumn<FrequentlyFx, Integer> columnHours;

    private StudentFrequentlyService studentFrequentlyService;

    @FXML
    void initialize() {
        studentFrequentlyService= new StudentFrequentlyService();
        studentFrequentlyService.init();

        this.frequentlyTableView.setItems(this.studentFrequentlyService.getFrequentlyFxObservableList());
        this.columnDate.setCellValueFactory(cellData ->  cellData.getValue().dateProperty());
        this.columnHours.setCellValueFactory(cellData -> cellData.getValue().absenseProperty().asObject());

        this.lbNumber.setText(this.studentFrequentlyService.Count());
    }

}
