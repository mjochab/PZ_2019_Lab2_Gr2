package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelFX.WarnsFx;
import services.StudentWarnsService;

import java.util.Date;

public class StudentWarnsController {
    @FXML
    private TableView<WarnsFx> warnsTableView;

    @FXML
    private TableColumn<WarnsFx, Date> columnDate;

    @FXML
    private TableColumn<WarnsFx, String> columnTeacherName;

    @FXML
    private TableColumn<WarnsFx, String> columnTeacherSurname;

    @FXML
    private TableColumn<WarnsFx, String> columnWarns;

    private StudentWarnsService studentWarnsService;


    /**
     * Inicjacja klasy kontrolera.
     */
    @FXML
    void initialize() {
        studentWarnsService= new StudentWarnsService();
        studentWarnsService.init();

        this.warnsTableView.setItems(this.studentWarnsService.getWarnsFxObservableList());
        this.columnDate.setCellValueFactory(cellData ->  cellData.getValue().date_createdProperty());
        this.columnTeacherName.setCellValueFactory(cellData -> cellData.getValue().getTeacherFxObjectProperty().firstNameTProperty());
        this.columnTeacherSurname.setCellValueFactory(cellData -> cellData.getValue().getTeacherFxObjectProperty().lastNameTProperty());
        this.columnWarns.setCellValueFactory(cellData -> cellData.getValue().contentProperty());


    }
}
