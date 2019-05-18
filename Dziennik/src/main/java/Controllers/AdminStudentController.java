package Controllers;

import Modele.Student;
import Modele.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelFX.ClassesFx;
import modelFX.StudentFx;
import services.StudentServices;
import services.UserServices;



public class AdminStudentController {


    @FXML
    private TextField lbStudentName;

    @FXML
    private TextField lbLastName;

    @FXML
    private TextField lbPesel;

    @FXML
    private TextField lbLogin;

    @FXML
    private TextField lbPassword;



    @FXML
    private Button addButton;



    @FXML
    private ComboBox<ClassesFx> cbClass;

    @FXML
    private TableView<StudentFx> studentTableView;

    @FXML
    private TableColumn<StudentFx,String> studentTableName;
    @FXML
    private TableColumn<StudentFx,String> studentTableLastName;
    @FXML
    private TableColumn<StudentFx,String> studentTablePesel;
    @FXML
    private TableColumn<StudentFx, ClassesFx> studentTableClass;
    @FXML
    private TableColumn<StudentFx, StudentFx> studentTableDelete;

    private StudentServices studentServices;
    private UserServices userServices;
    private Student student;
    private User user;



    @FXML
    void initialize(){


    studentServices = new StudentServices();
    userServices = new UserServices();
    studentServices.init();





    this.studentTableView.setItems(this.studentServices.getStudentFxObservableList());
    this.studentTableName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    this.studentTableLastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    this.studentTablePesel.setCellValueFactory(cellData -> cellData.getValue().peselProperty());

    this.studentTableClass.setCellValueFactory(cellData -> cellData.getValue().classesFxObjectPropertyProperty());

    this.studentTableDelete.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

    this.studentTableDelete.setCellFactory(param -> new TableCell<StudentFx,StudentFx>(){
        Button button = createDeleteButton();

        @Override
        protected void updateItem(StudentFx item, boolean empty){
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
                        studentServices.deleteStudent(item);
                    }catch(Exception e){

                    }
                });
            }

        }

    });


    this.addButton.disableProperty().bind(this.lbStudentName.textProperty().isEmpty()
    .or(this.lbLastName.textProperty().isEmpty())
    .or(this.lbPesel.textProperty().isEmpty())
    .or(this.lbLogin.textProperty().isEmpty())
    .or(this.lbPassword.textProperty().isEmpty())
    .or(this.cbClass.valueProperty().isNull())

    );

    this.cbClass.setItems(this.studentServices.getClassesFxObservableList());
    this.lbPesel.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d{0,11}?")){
                lbPesel.setText(oldValue);
            }
        }
    });

    }

    private Button createButton(String path){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return button;
    }

    private Button createDeleteButton(){
        Button button1 = new Button("Usun");
        //Image image = new Image(this.getClass().getResource("/icons/delete.png").toString());
       // ImageView imageView = new ImageView(image);
       // button1.setGraphic(imageView);
        return button1;
    }


    @FXML
    void addStudent(ActionEvent event) {
            //userServices.saveUser();
            //studentServices.saveStudent();


            String name = lbStudentName.getText();
            String lname = lbLastName.getText();
            String pesel = lbPesel.getText();
            String password = lbPassword.getText();
            String login = lbLogin.getText();

            ClassesFx clas = cbClass.getSelectionModel().getSelectedItem();
            String linkedAcc ="S";
            this.student = new Student(name,lname,pesel,clas,linkedAcc);
            this.user = new User(login,password,linkedAcc);
            user.setStudent(student);
            student.setUser(user);
            userServices.persist(user);

            clearFields();
            studentServices.init();

    }
    public void clearFields(){
        cbClass.getItems().clear();
        lbLastName.clear();
        lbStudentName.clear();
        lbPesel.clear();
        lbPassword.clear();
        lbLogin.clear();
    }



    public void comboBox(ActionEvent actionEvent) {
        this.studentServices.setClassesFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }
    public StudentServices getStudentServices(){
        return studentServices;
    }
}
