package Controllers;

import Converters.StudentConverter;
import Modele.Frequently;
import Modele.Student;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import modelFX.ClassesFx;
import modelFX.FrequentlyFx;
import modelFX.StudentFx;
import services.FrequentlyService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TeacherFrequentlyController {

    @FXML
    private ComboBox<ClassesFx> cbClass1;

    @FXML
    private ComboBox<ClassesFx> cbClass2;

    @FXML
    private ComboBox<StudentFx> cbStudent1;

    @FXML
    private ComboBox<StudentFx> cbStudent2;

    @FXML
    private ComboBox<Integer> cbNumberOfHours;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button buttonAdd;

    @FXML
    private TableView<FrequentlyFx> tableFrequently;


    @FXML
    private TableColumn<FrequentlyFx, Date> columnDate;

    @FXML
    private TableColumn<FrequentlyFx,Integer> columnHours;

    @FXML
    private TableColumn<FrequentlyFx, FrequentlyFx> columnDelete;

    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();

    private FrequentlyService frequentlyService;
    private Frequently frequently;

    @FXML
    void initialize(){
        frequentlyService = new FrequentlyService();
        frequentlyService.init();

        this.cbNumberOfHours.getItems().setAll(
                1,2,3,4,5,6,7,8,9,10
        );

        this.cbClass1.setItems(this.frequentlyService.getClassesFxObservableList());
        cbClass1.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null){
                cbStudent1.getItems().clear();
                cbStudent1.setDisable(true);
            } else{
                List<Student> studentList = frequentlyService.findAllStudentByClass(cbClass1.getValue().getClassId());
                studentFxObservableList.clear();
                studentList.forEach(c->{
                    StudentFx studentFx = StudentConverter.convertToStudentFx(c);
                    studentFxObservableList.add(studentFx);

                });
                this.cbStudent1.setItems(getStudentFxObservableList());
                this.cbStudent1.setCellFactory(new Callback<ListView<StudentFx>, ListCell<StudentFx>>() {
                    @Override
                    public ListCell<StudentFx> call(ListView<StudentFx> param) {
                        return new ListCell<StudentFx>(){
                            protected void updateItem(StudentFx t, boolean bln){
                                super.updateItem(t,bln);
                                if(t != null){
                                    setText(t.getFirstName()+" "+t.getLastName());

                                } else {
                                    setText(null);
                                }
                            }
                        };
                    }
                });
                this.cbStudent1.setButtonCell(new ListCell<StudentFx>() {
                    @Override
                    protected void updateItem(StudentFx t, boolean bln){
                        super.updateItem(t,bln);
                        if(t != null){
                            setText(t.getFirstName()+" "+t.getLastName());

                        } else {
                            setText(null);
                        }
                    }

                });

                cbStudent1.setDisable(false);
            }

        }));


        //sekcja druga

        this.cbClass2.setItems(this.frequentlyService.getClassesFxObservableList());
        cbClass2.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null){
                cbStudent2.getItems().clear();
                cbStudent2.setDisable(true);
            } else{
                List<Student> studentList = frequentlyService.findAllStudentByClass(cbClass2.getValue().getClassId());
                studentFxObservableList.clear();
                studentList.forEach(c->{
                    StudentFx studentFx = StudentConverter.convertToStudentFx(c);
                    studentFxObservableList.add(studentFx);

                });
                this.cbStudent2.setItems(getStudentFxObservableList());
                this.cbStudent2.setCellFactory(new Callback<ListView<StudentFx>, ListCell<StudentFx>>() {
                    @Override
                    public ListCell<StudentFx> call(ListView<StudentFx> param) {
                        return new ListCell<StudentFx>(){
                            protected void updateItem(StudentFx t, boolean bln){
                                super.updateItem(t,bln);
                                if(t != null){
                                    setText(t.getFirstName()+" "+t.getLastName());

                                } else {
                                    setText(null);
                                }
                            }
                        };
                    }
                });
                this.cbStudent2.setButtonCell(new ListCell<StudentFx>() {
                    @Override
                    protected void updateItem(StudentFx t, boolean bln){
                        super.updateItem(t,bln);
                        if(t != null){
                            setText(t.getFirstName()+" "+t.getLastName());

                        } else {
                            setText(null);
                        }
                    }

                });

                cbStudent2.setDisable(false);
            }

        }));

        this.frequentlyService.studentFxObjectPropertyProperty().bind(this.cbStudent2.valueProperty());

        // tableView

        this.tableFrequently.setItems(this.frequentlyService.getFrequentlyFxObservableList());
        this.columnDate.setCellValueFactory(cellData ->  cellData.getValue().dateProperty());

        this.columnHours.setCellValueFactory(cellData -> cellData.getValue().absenseProperty().asObject());


        this.columnDelete.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.columnDelete.setCellFactory(param -> new TableCell<FrequentlyFx, FrequentlyFx>(){
            Button button = createDeleteButton();

            @Override
            protected void updateItem(FrequentlyFx item, boolean empty){
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
                            frequentlyService.deleteFrequently(item);
                        }catch(Exception e){

                        }
                    });
                }

            }

        });




    }


    public void btnAdd(ActionEvent actionEvent) {

        LocalDate ld = datePicker.getValue();
        Calendar c =  Calendar.getInstance();

        c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());


        StudentFx student = cbStudent1.getSelectionModel().getSelectedItem();
        Date date = c.getTime();
        int absence = cbNumberOfHours.getValue();

        this.frequently = new Frequently(date,student,absence);
        frequentlyService.persist(frequently);
        frequentlyService.init();
    }

    private Button createDeleteButton(){
        Button button1 = new Button("Usuń");
        //Image image = new Image(this.getClass().getResource("/icons/delete.png").toString());
        // ImageView imageView = new ImageView(image);
        // button1.setGraphic(imageView);
        return button1;
    }

    public void comboBoxClass1(ActionEvent actionEvent) {
        this.frequentlyService.setClassesFxObjectProperty(this.cbClass1.getSelectionModel().getSelectedItem());
    }

    public void comboBoxStudent1(ActionEvent actionEvent) {
        this.frequentlyService.setStudentFxObjectProperty(this.cbStudent1.getSelectionModel().getSelectedItem());
    }

    public void comboBoxHours(ActionEvent actionEvent) {
    }



    public void comboBoxClass2(ActionEvent actionEvent) {
        this.frequentlyService.setClassesFxObjectProperty(this.cbClass2.getSelectionModel().getSelectedItem());
    }
    public void comboBoxStudent2(ActionEvent actionEvent) {
        this.frequentlyService.filterFrequentlyList();
    }


    public ObservableList<StudentFx> getStudentFxObservableList() {
        return studentFxObservableList;
    }

    public void setStudentFxObservableList(ObservableList<StudentFx> studentFxObservableList) {
        this.studentFxObservableList = studentFxObservableList;
    }

    public FrequentlyService getFrequentlyService(){
        return frequentlyService;
    }
}
