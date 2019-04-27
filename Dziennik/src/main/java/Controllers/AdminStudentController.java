package Controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
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
    private Button modifyButton;

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
        Button button = createButton("/icons/delete.png");
        @Override
        protected void updateItem(StudentFx item,boolean empty){
            super.updateItem(item,empty);

            if(empty){
                setGraphic(null);
                return;
            }
            if(!empty){
                setGraphic(button);
                button.setOnAction(event -> {
                    studentServices.deleteStudent(item);
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
    this.cbClass.valueProperty().bindBidirectional(this.studentServices.getStudentFxObjectProperty().classesFxObjectPropertyProperty());

    }

    private Button createButton(String path){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return button;
    }

    @FXML
    void addStudent(ActionEvent event) {

    }

    public void modifyStudent(ActionEvent actionEvent) {
    }
}
