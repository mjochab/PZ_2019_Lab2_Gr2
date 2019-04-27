package Controllers;

import Modele.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import modelFX.SubjectFx;
import services.SubjectService;

public class AdminSubjectController {

    @FXML
    private Button addSubjectButton;

    @FXML
    private Button deleteSubjectButton;

    @FXML
    private TextField lbSubjectName;

    @FXML
    private ComboBox<SubjectFx> cbSubject;

    @FXML
    private TreeView<String> subjectTreeView;

    private SubjectService subjectService;
    private Subject subject;
    private SubjectFx subjectFx;


    public void initialize(){
        this.subjectService = new SubjectService();
        this.subjectService.init();



        this.cbSubject.setItems(this.subjectService.getSubjectFxObservableList());
        this.subjectTreeView.setRoot(this.subjectService.getRoot());


        this.addSubjectButton.disableProperty().bind(lbSubjectName.textProperty().isEmpty());
        this.deleteSubjectButton.disableProperty().bind(this.subjectService.subjectFxObjectProperty().isNull());
    }


    public void addSubject(ActionEvent actionEvent) {
        try{
            String name = lbSubjectName.getText();

            this.subject = new Subject(name);
            subjectService.persist(this.subject);
            lbSubjectName.clear();
            //classesService.saveClassInDataBase(lbClassName.getText());
        }catch (Exception e){
            System.out.println("Nie dodano do bazy");
        }
    }

    public void deleteSubject(ActionEvent actionEvent) {
        try{
            this.subjectService.delete(cbSubject.getValue().getSubjectId());
        }catch (Exception e){
            System.out.println("nie usunieto");
        }
    }

    public void comboBox(ActionEvent actionEvent) {
        this.subjectService.setSubjectFxObjectProperty(this.cbSubject.getSelectionModel().getSelectedItem());
    }
}
