package Controllers;

import Converters.StudentConverter;
import Converters.SubjectConverter;
import Modele.Grades;
import Modele.Student;
import Modele.Subject;
import Modele.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import modelFX.ClassesFx;
import modelFX.GradesFx;
import modelFX.StudentFx;
import services.ClassesService;
import services.GradesServices;
import services.StudentServices;
import services.SubjectService;
import sessions.UserSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TeacherMarksController {


    @FXML
    private ComboBox<ClassesFx> teacherChooseClass;

    @FXML
    private Slider gradeSlider;

    @FXML
    private ComboBox<String> teacherChooseReason;

    @FXML
    private Label lbSubject;

    @FXML
    private ComboBox<ClassesFx> cbClass2;

    @FXML
    private ComboBox<StudentFx> cbStudent2;


    @FXML
    private TableView<GradesFx> tableViewGrades;

    @FXML
    private TableColumn<GradesFx, Date> columnDate;

    @FXML
    private TableColumn<GradesFx,Double> columnGrade;

    @FXML
    private TableColumn<GradesFx, String> columnType;





    @FXML
    private ComboBox<StudentFx> teacherChooseStudent;

    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();


    private StudentServices studentServices;
    private ClassesService classesService;
    private ClassesFx clasFx;
    private SubjectService subjectService;
    private Grades grades;
    private GradesServices gradesServices;

    public void initialize(){
        Teacher teacherFx =  UserSession.getInstance().currentUser().getTeacher();
        this.gradesServices = new GradesServices();
        this.gradesServices.init();
        this.teacherChooseReason.getItems().setAll(
                "Sprawdzian",
                "Klasówka",
                "Zadanie"
        );

        this.lbSubject.setText(String.valueOf(SubjectConverter.convertToSubjectFx(UserSession.getInstance().currentUser().getTeacher().getSubject())));

        this.teacherChooseClass.setItems(this.gradesServices.getClassesFxObservableList());
        teacherChooseClass.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null){
                teacherChooseStudent.getItems().clear();
                teacherChooseStudent.setDisable(true);
            } else{
                List<Student> studentList = gradesServices.findAllStudentByClass(teacherChooseClass.getValue().getClassId());
                studentFxObservableList.clear();
                studentList.forEach(c->{
                    StudentFx studentFx = StudentConverter.convertToStudentFx(c);
                    studentFxObservableList.add(studentFx);

                });
                this.teacherChooseStudent.setItems(getStudentFxObservableList());
                this.teacherChooseStudent.setCellFactory(new Callback<ListView<StudentFx>, ListCell<StudentFx>>() {
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
                this.teacherChooseStudent.setButtonCell(new ListCell<StudentFx>() {
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

                teacherChooseStudent.setDisable(false);
            }

        }));


        this.gradesServices.studentFxObjectPropertyProperty().bind(this.cbStudent2.valueProperty());

        this.cbClass2.setItems(this.gradesServices.getClassesFxObservableList());
        cbClass2.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue == null){
                cbStudent2.getItems().clear();
                cbStudent2.setDisable(true);
            } else{
                List<Student> studentList = gradesServices.findAllStudentByClass(cbClass2.getValue().getClassId());
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

        this.tableViewGrades.setItems(this.gradesServices.getGradesFxObservableList());
        this.columnDate.setCellValueFactory(cellData ->  cellData.getValue().dateProperty());
        this.columnGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty().asObject());
        this.columnType.setCellValueFactory(cellData -> cellData.getValue().detailsProperty());


    }

    public void comboBoxClass(ActionEvent actionEvent) {
        this.gradesServices.setClassesFxObjectProperty(this.teacherChooseClass.getSelectionModel().getSelectedItem());
    }

    public void comboBoxStudent(ActionEvent actionEvent) {
        this.gradesServices.setStudentFxObjectProperty(this.teacherChooseStudent.getSelectionModel().getSelectedItem());
    }

    public void comboBoxClass2(ActionEvent actionEvent) {
        this.gradesServices.setClassesFxObjectProperty(this.cbClass2.getSelectionModel().getSelectedItem());
    }

    public void comboBoxStudent2(ActionEvent actionEvent) {
        this.gradesServices.filterGradesList();
    }






    public void addGrade(ActionEvent actionEvent) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String reason = teacherChooseReason.getValue();
        Subject subject = UserSession.getInstance().currentUser().getTeacher().getSubject();
        StudentFx student = teacherChooseStudent.getSelectionModel().getSelectedItem();
        Date dateCreated = date;
        double grade = gradeSlider.getValue();

        this.grades = new Grades(dateCreated,reason,student,subject,grade);
        gradesServices.persist(grades);
        clearFields();
        initialize();
    }

    public void clearFields(){

        teacherChooseStudent.getItems().clear();
        teacherChooseClass.getItems().clear();
        teacherChooseReason.getItems().clear();


    }

    public ObservableList<StudentFx> getStudentFxObservableList() {
        return studentFxObservableList;
    }
}
