package Controllers;

import Modele.Teacher;
import Modele.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelFX.SubjectFx;
import modelFX.TeacherFx;
import services.TeacherServices;
import services.UserServices;



public class AdminTeacherController {
    @FXML
    private TextField lbNameT;

    @FXML
    private TextField lbLastNameT;

    @FXML
    private TextField lbPasswordT;

    @FXML
    private TextField lbLoginT;

    @FXML
    private ComboBox<SubjectFx> cbSubject;

    @FXML
    private Button buttonAdd;
    
    @FXML
    private Button buttonModify;

    @FXML
    private TableView<TeacherFx> tableViewTeacher;

    @FXML
    private TableColumn<TeacherFx,String> tableTeacherName;

    @FXML
    private TableColumn<TeacherFx,String> tableTeacherLastName;

    @FXML
    private TableColumn<TeacherFx,SubjectFx> tableTeacherSubject;

    @FXML
    private TableColumn<TeacherFx,TeacherFx> tableTeacherDelete;

    private TeacherServices teacherServices;
    private UserServices userServices;
    private Teacher teacher;
    private User user;

    @FXML
    void initialize(){
        teacherServices = new TeacherServices();
        userServices = new UserServices();
        teacherServices.init();

        this.tableViewTeacher.setItems(this.teacherServices.getTeacherFxObservableList());
        this.tableTeacherName.setCellValueFactory(cellData -> cellData.getValue().firstNameTProperty());
        this.tableTeacherLastName.setCellValueFactory(cellData -> cellData.getValue().lastNameTProperty());
        this.tableTeacherSubject.setCellValueFactory(cellData -> cellData.getValue().subjectFxObjectPropertyProperty());
        this.tableTeacherDelete.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        this.tableTeacherDelete.setCellFactory(param -> new TableCell<TeacherFx,TeacherFx>(){
            javafx.scene.control.Button button = createDeleteButton();

            @Override
            protected void updateItem(TeacherFx item, boolean empty){
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
                            teacherServices.deleteTeacher(item);
                        }catch (Exception e){

                        }
                    });
                }

            }
        });


        this.buttonAdd.disableProperty().bind(this.lbNameT.textProperty().isEmpty()
                .or(this.lbLastNameT.textProperty().isEmpty())
                .or(this.lbLoginT.textProperty().isEmpty())
                .or(this.lbPasswordT.textProperty().isEmpty())
                .or(this.cbSubject.valueProperty().isNull())
        );


        this.cbSubject.setItems(this.teacherServices.getSubjectFxObservableList());
    }

    private javafx.scene.control.Button createDeleteButton(){
        javafx.scene.control.Button button1 = new javafx.scene.control.Button("Usuń");
        //Image image = new Image(this.getClass().getResource("/icons/delete.png").toString());
        // ImageView imageView = new ImageView(image);
        // button1.setGraphic(imageView);
        return button1;
    }


    public void addTeacher(ActionEvent actionEvent) {

        String name = lbNameT.getText();
        String lname = lbLastNameT.getText();
        String password = lbLoginT.getText();
        String login = lbPasswordT.getText();
        SubjectFx subjectFx = cbSubject.getSelectionModel().getSelectedItem();
        String linkedAcc ="T";
        this.teacher = new Teacher(name,lname,subjectFx,linkedAcc);
        this.user = new User(login,password,linkedAcc);
        user.setTeacher(teacher);
        teacher.setUser(user);
        userServices.persist(user);

        clearFields();
        teacherServices.init();

    }

    public void clearFields(){
        lbNameT.clear();
        cbSubject.getItems().clear();
        lbLastNameT.clear();
        lbLoginT.clear();
        lbPasswordT.clear();
    }

    public void modifyTeacher(ActionEvent actionEvent) {
    }

    public void comboBox(ActionEvent actionEvent) {
        this.teacherServices.setSubjectFxObjectProperty(this.cbSubject.getSelectionModel().getSelectedItem());
    }
    public TeacherServices getTeacherServices(){
        return teacherServices;
    }
}
