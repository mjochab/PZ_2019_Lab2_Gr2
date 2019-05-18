package Controllers;

import Converters.StudentConverter;
import Modele.Student;
import Modele.Teacher;
import Modele.Warns;
import dao.StudentDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import modelFX.ClassesFx;
import modelFX.StudentFx;
import modelFX.TeacherFx;
import services.WarnService;
import sessions.UserSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TeacherWarnsController {
    @FXML
    private ComboBox<ClassesFx>cbClass;

    @FXML
    private ComboBox<StudentFx>cbStudent;

    @FXML
    private TextField lbContent;

    @FXML
    private Button btnAdd;

    private Warns warns;
    private Teacher teacher;
    private TeacherFx teacherFx;
    private WarnService warnService;
    private StudentDao studentDao;
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    private NauczycielViewController nauczycielViewController;

    @FXML
    void initialize() {


        warnService = new WarnService();
        warnService.init();

        this.cbClass.setItems(this.warnService.getClassesFxObservableList());
        //this.cbStudent.disableProperty().bind(cbClass.valueProperty().isNull());
        cbClass.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null){
                cbStudent.getItems().clear();
                cbStudent.setDisable(true);
            } else{
                List<Student> studentList = warnService.findAllStudentByClass(cbClass.getValue().getClassId());
                studentFxObservableList.clear();
                studentList.forEach(c->{
                    StudentFx studentFx = StudentConverter.convertToStudentFx(c);
                    studentFxObservableList.add(studentFx);

                });
                this.cbStudent.setItems(getStudentFxObservableList());
                this.cbStudent.setCellFactory(new Callback<ListView<StudentFx>, ListCell<StudentFx>>() {
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
                this.cbStudent.setButtonCell(new ListCell<StudentFx>() {
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

                cbStudent.setDisable(false);
            }

        }));



    }

    public void comboBoxClass(ActionEvent actionEvent) {
        this.warnService.setClassesFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }

    public void comboboxStudent(ActionEvent actionEvent) {
        this.warnService.setStudentFxObjectProperty(this.cbStudent.getSelectionModel().getSelectedItem());
    }

    public void addWarn(ActionEvent actionEvent) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();


        String name = lbContent.getText();
        Date dateCreated = date;
        StudentFx studentFx = cbStudent.getSelectionModel().getSelectedItem();
        Teacher teacherFx =  UserSession.getInstance().currentUser().getTeacher();
        this.warns = new Warns(dateCreated,name,studentFx,teacherFx);
        warnService.persist(warns);
        clearFields();
        warnService.init();

    }

    public void clearFields(){
        cbClass.getItems().clear();
        cbStudent.getItems().clear();
        lbContent.clear();

    }

    public ObservableList<StudentFx> getStudentFxObservableList() {
        return studentFxObservableList;
    }

    public void setStudentFxObservableList(ObservableList<StudentFx> studentFxObservableList) {
        this.studentFxObservableList = studentFxObservableList;
    }
}
