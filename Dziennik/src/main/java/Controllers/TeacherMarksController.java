package Controllers;

import Converters.StudentConverter;
import Modele.Grades;
import Modele.Student;
import Modele.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.util.Callback;
import modelFX.ClassesFx;
import modelFX.StudentFx;
import modelFX.SubjectFx;
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
    private ComboBox<SubjectFx> cbSubject;


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


        this.cbSubject.setItems(this.gradesServices.getSubjectFxObservableList());
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


    }

    public void comboBoxClass(ActionEvent actionEvent) {
        this.gradesServices.setClassesFxObjectProperty(this.teacherChooseClass.getSelectionModel().getSelectedItem());
    }

    public void comboBoxStudent(ActionEvent actionEvent) {
        this.gradesServices.setStudentFxObjectProperty(this.teacherChooseStudent.getSelectionModel().getSelectedItem());
    }

    public void comboBoxSubject(ActionEvent actionEvent) {
        this.gradesServices.setSubjectFxObjectProperty(this.cbSubject.getSelectionModel().getSelectedItem());
    }






    public void addGrade(ActionEvent actionEvent) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String reason = teacherChooseReason.getValue();
        SubjectFx subject = cbSubject.getSelectionModel().getSelectedItem();
        StudentFx student = teacherChooseStudent.getSelectionModel().getSelectedItem();
        Date dateCreated = date;
        double grade = gradeSlider.getValue();

        this.grades = new Grades(dateCreated,reason,student,subject,grade);
        gradesServices.persist(grades);
        clearFields();
    }

    public void clearFields(){
        cbSubject.getItems().clear();
        teacherChooseStudent.getItems().clear();
        teacherChooseClass.getItems().clear();
        teacherChooseReason.getItems().clear();


    }

    public ObservableList<StudentFx> getStudentFxObservableList() {
        return studentFxObservableList;
    }
}
