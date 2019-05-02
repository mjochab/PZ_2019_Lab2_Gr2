package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelFX.ClassesFx;
import modelFX.ScheduleFx;
import modelFX.SubjectFx;

import java.awt.*;

public class AdminScheduleController {
    @FXML
    private TextField lbTime;

    @FXML
    private TextField lbRoom;

    @FXML
    private ComboBox cbTime;

    @FXML
    private ComboBox<ClassesFx> cbClass;

    @FXML
    private ComboBox<SubjectFx> cbSubject;

    @FXML
    private TableView<ScheduleFx> TableViewSchedule;

    @FXML
    private TableColumn<ScheduleFx,String> columnDay;

    @FXML
    private TableColumn<ScheduleFx,String> columnTime;

    @FXML
    private TableColumn<ScheduleFx,String> columnRoom;

    @FXML
    private TableColumn<ScheduleFx,ClassesFx> columnClass;

    @FXML
    private TableColumn<ScheduleFx,SubjectFx> columnSubject;

    @FXML
    private TableColumn<ScheduleFx,ScheduleFx> columnDelete;
}
