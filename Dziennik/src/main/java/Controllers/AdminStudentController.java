package Controllers;

import Modele.Student;
import Modele.User;
import hibernate.HibernateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelFX.ClassesFx;
import modelFX.StudentFx;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import services.ClassesService;
import services.StudentServices;
import services.UserServices;

import java.util.List;
import java.util.function.Predicate;


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
    private TextField filterField;


    @FXML
    private Button addButton;

    @FXML
    private Button fillData;

    @FXML
    private ComboBox<StudentFx> idComboBox;
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

    private ClassesService classesService;
    private StudentServices studentServices;
    private UserServices userServices;
    private Student student;
    private User user;
    private Class clas;
    private List<String> ls;

    /**
     * Inicjacja klasy kontrolera.
     */
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

        FilteredList<StudentFx> filteredData = new FilteredList<>(studentTableView.getItems(), p -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Student>) student -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }


                String lowerCaseFilter = newValue.toLowerCase();

                if (student.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getPesel().toLowerCase().contains(lowerCaseFilter)){
                    return  true;
                }
                return false;
            });
        });

        studentTableView.setItems(filteredData);


        SortedList<StudentFx> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(studentTableView.comparatorProperty());


        studentTableView.setItems(sortedData);
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
    public void fillData(ActionEvent event){




        StudentFx student = studentTableView.getSelectionModel().getSelectedItem();



        String newname=lbStudentName.getText();
        String newlastname=lbLastName.getText();
        String newpesel=lbPesel.getText();
        Long newclass=cbClass.getSelectionModel().getSelectedItem().getClassId();

        String newlogin = lbLogin.getText();
        String newpassword = lbPassword.getText();

        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("update Student set first_name='"+newname+"', last_name='"+newlastname+"',pesel='"+newpesel+"',class_id='"+newclass+"' where student_id = '"+student.getStudentId()+"'");
            // SQLQuery query_2 = session.createSQLQuery("update User set user_name='"+newlogin+"',passwrd='"+newpassword+"' where user_id ='"+student.getUser().getUserId()+"'");
            query.executeUpdate();
            // query_2.executeUpdate();
            session.getTransaction().commit();
            session.close();



        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Błąd");
        }
        /*this.student = new Student(name,lname,pesel,clas,linkedAcc);
        this.user = new User(login,password,linkedAcc);
        user.setStudent(student);
        student.setUser(user);
        userServices.persist(user);
        clearFields();
        studentServices.init();*/

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


    public void chooseId(ActionEvent event) {
        this.studentServices.setStudentFxObjectProperty(this.idComboBox.getSelectionModel().getSelectedItem());
    }

    public void copyStudent(ActionEvent event) {
        StudentFx student = studentTableView.getSelectionModel().getSelectedItem();
        String name = studentTableView.getSelectionModel().getSelectedItem().getFirstName();
        String lname = studentTableView.getSelectionModel().getSelectedItem().getLastName();
        String pesel = studentTableView.getSelectionModel().getSelectedItem().getPesel();
        Class clas = studentTableView.getSelectionModel().getSelectedItem().getClass();

       // String user_login = studentTableView.getSelectionModel().getSelectedItem().getStudentId();

        cbClass.getSelectionModel().selectFirst();
        //String password = idComboBox.getSelectionModel().getSelectedItem().getUser().getPasswrd();
        //User login = idComboBox.getSelectionModel().getSelectedItem().getUser().getUsername();

        //String clas_name = idComboBox.getSelectionModel().getSelectedItem().getClassesFxObjectProperty().getClassName();
        // Long clas_id = idComboBox.getSelectionModel().getSelectedItem().getClasses().getClassId();
        String linkedAcc = studentTableView.getSelectionModel().getSelectedItem().getLinkedAcc();

        //String user_login = studentTableView.getSelectionModel().getSelectedItem().getUser().getUsername();
        String user_id2 = userServices.getUserFxObjectProperty().getUsername();
        lbStudentName.setText(name);
        lbLastName.setText(lname);
        lbPesel.setText(pesel);

        //lbLogin.setText(user_login);
        //lbLogin.setText("student"+student.getUser().getUserId());
        this.cbClass.setItems(this.studentServices.getClassesFxObservableList());

    }
}
