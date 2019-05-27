package Controllers;

import Modele.Schedule;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelFX.ClassesFx;
import modelFX.ScheduleFx;
import modelFX.SubjectFx;
import services.ScheduleService;



public class AdminScheduleController {
    @FXML
    private TextField lbTime;

    @FXML
    private TextField lbRoom;

    @FXML
    private ComboBox<String> cbDay;

    @FXML
    private ComboBox<ClassesFx> cbClass;

    @FXML
    private ComboBox<SubjectFx> cbSubject;

    @FXML
    private TableView<ScheduleFx> tableViewSchedule;

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

    @FXML
    private Button buttonAdd;

    private ScheduleService scheduleService;
    private Schedule schedule;

    /**
     * Inicjacja klasy kontrolera.
     */
    @FXML
    void initialize(){
        scheduleService = new ScheduleService();
        scheduleService.init();



        this.tableViewSchedule.setItems(this.scheduleService.getScheduleFxObservableList());
        this.columnDay.setCellValueFactory(cellData -> cellData.getValue().dayProperty());
        this.columnTime.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        this.columnRoom.setCellValueFactory(cellData -> cellData.getValue().roomProperty());

        this.columnClass.setCellValueFactory(cellData -> cellData.getValue().classesFxObjectPropertyProperty());
        this.columnSubject.setCellValueFactory(cellData -> cellData.getValue().subjectFxObjectPropertyProperty());
        this.columnDelete.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        this.columnDelete.setCellFactory(param -> new TableCell<ScheduleFx,ScheduleFx>(){
            javafx.scene.control.Button button = createDeleteButton();

            @Override
            protected void updateItem(ScheduleFx item, boolean empty){
                super.updateItem(item,empty);
                setGraphic(button);


                if(empty){
                    setGraphic(null);
                    return;
                }
                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        try {
                            scheduleService.deleteSchedule(item);
                        }catch (Exception e){

                        }

                    });
                }

            }

        });

        this.cbClass.setItems(this.scheduleService.getClassesFxObservableList());
        this.cbSubject.setItems(this.scheduleService.getSubjectFxObservableList());

        this.buttonAdd.disableProperty().bind(this.lbRoom.textProperty().isEmpty()
                .or(this.lbTime.textProperty().isEmpty())
                .or(this.cbClass.valueProperty().isNull())
                .or(this.cbSubject.valueProperty().isNull())
                .or(this.cbDay.valueProperty().isNull())

        );

        this.cbDay.getItems().setAll(
                "Poniedziałek",
                "Wtorek",
                "Środa",
                "Czwartek",
                "Piątek"
        );
    }
    private javafx.scene.control.Button createDeleteButton(){
        javafx.scene.control.Button button1 = new javafx.scene.control.Button("Usun");
        //Image image = new Image(this.getClass().getResource("/icons/delete.png").toString());
        // ImageView imageView = new ImageView(image);
        // button1.setGraphic(imageView);
        return button1;
    }

    public void AddLesson(ActionEvent actionEvent) {
        String day = cbDay.getValue();
        String time = lbTime.getText();
        String room = lbRoom.getText();
        SubjectFx subject = cbSubject.getSelectionModel().getSelectedItem();
        ClassesFx clas = cbClass.getSelectionModel().getSelectedItem();
        this.schedule = new Schedule(day,time,room,clas,subject);
        scheduleService.persist(schedule);
        clearFields();
        scheduleService.init();

    }

    public void clearFields(){
        cbDay.getItems().clear();
        cbSubject.getItems().clear();
        cbClass.getItems().clear();
        lbRoom.clear();
        lbTime.clear();
    }

    public void comboBoxClass(ActionEvent actionEvent) {
        this.scheduleService.setClassesFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }

    public void comboBoxSubject(ActionEvent actionEvent) {
        this.scheduleService.setClassesFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }
}
