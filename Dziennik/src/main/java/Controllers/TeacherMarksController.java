package Controllers;

import Converters.StudentConverter;
import Modele.Grades;
import Modele.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import modelFX.ClassesFx;
import modelFX.StudentFx;
import modelFX.SubjectFx;
import services.ClassesService;
import services.GradesServices;
import services.StudentServices;
import services.SubjectService;

import java.util.Date;
import java.util.List;

public class TeacherMarksController {


    @FXML
    private ComboBox<ClassesFx> teacherChooseClass;

    @FXML
    private TextField gradeField;
    private StudentServices studentServices;
    private ClassesService classesService;
    private ClassesFx clasFx;
    private SubjectService subjectService;
    private Grades grades;
    private GradesServices gradesServices;
    @FXML
    private ComboBox<String> teacherChooseReason = new ComboBox<>();
    @FXML
    private ComboBox<SubjectFx> teacherChooseSubject = new ComboBox<SubjectFx>();
    private ClassesService subjectTreeView;
    private ComboBox<StudentFx> teacherChooseStudent = new ComboBox<>();
    private ObservableList<StudentFx> studentFxObservableList = FXCollections.observableArrayList();
    public void initialize(){

        this.gradesServices = new GradesServices();
        this.gradesServices.init();
        this.teacherChooseReason.getItems().setAll(
                "Sprawdzian",
                "Klasówka",
                "Zadanie"
        );

        this.classesService = new ClassesService();
        this.classesService.init();
        this.teacherChooseClass.setItems(this.classesService.getClassesFxObservableList());

        this.subjectService = new SubjectService();
        this.subjectService.init();
        this.teacherChooseSubject.setItems(this.subjectService.getSubjectFxObservableList());




        teacherChooseClass.getSelectionModel().selectFirst();
        teacherChooseReason.getSelectionModel().selectFirst();
        teacherChooseSubject.getSelectionModel().selectFirst();


        //this.cbStudent.disable    Property().bind(cbClass.valueProperty().isNull());
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

    public void getStudents(ActionEvent actionEvent) {
        this.classesService.setClassesFxObjectProperty(this.teacherChooseClass.getSelectionModel().getSelectedItem());

        // Pobranie ID aktualnie wybranej klasy
        int output = (int) teacherChooseClass.getSelectionModel().getSelectedItem().getClassId();
        System.out.println(output);


    }

    public void AddGrade(ActionEvent actionEvent) {
        String reason = teacherChooseReason.getSelectionModel().getSelectedItem();
        String grade = gradeField.getText();
        Date date = new Date();

        String student = "Uczeń";
        SubjectFx subject = teacherChooseSubject.getSelectionModel().getSelectedItem();
        ClassesFx class_ = teacherChooseClass.getSelectionModel().getSelectedItem();

        System.out.println(reason+grade+date+student+subject+class_);
        this.grades = new Grades();


        subjectService.init();

    }


    public ObservableList<StudentFx> getStudentFxObservableList() {
        return studentFxObservableList;
    }

    public void setStudentFxObservableList(ObservableList<StudentFx> studentFxObservableList) {
        this.studentFxObservableList = studentFxObservableList;
    }
}
