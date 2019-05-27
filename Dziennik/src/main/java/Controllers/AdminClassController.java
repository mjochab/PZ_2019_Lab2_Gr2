package Controllers;

import Modele.Classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modelFX.ClassesFx;
import services.ClassesService;

public class AdminClassController {

    @FXML
    private Button addClassButton;

    @FXML
    private Button deleteClassButton;

    @FXML
    private TextField lbClassName;

    @FXML
    private ComboBox<ClassesFx> cbClass;

    @FXML
    private TreeView<String> classTreeView;

    private ClassesService classesService;
    private Classes classes;
    private ClassesFx clasFx;

    @FXML
    public void initialize(){
        this.classesService = new ClassesService();
        this.classesService.init();



        this.cbClass.setItems(this.classesService.getClassesFxObservableList());
        this.classTreeView.setRoot(this.classesService.getRoot());


        this.addClassButton.disableProperty().bind(lbClassName.textProperty().isEmpty());
        this.deleteClassButton.disableProperty().bind(this.classesService.classesFxObjectPropertyProperty().isNull());
    }

    public void addClass(ActionEvent actionEvent) {
        try{
            String name = lbClassName.getText();

            this.classes = new Classes(name);
            classesService.persist(this.classes);
            lbClassName.clear();
            classesService.init();
            //classesService.saveClassInDataBase(lbClassName.getText());
        }catch (Exception e){
            System.out.println("Nie dodano do bazy");
        }
    }

    public void deleteClass(ActionEvent actionEvent) {
        try{
           this.classesService.delete(cbClass.getValue().getClassId());
           initialize();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Bład usuwania");
            alert.setHeaderText(null);
            alert.setContentText("Nie można usunąć klasy w której są uczniowie.");
            alert.showAndWait();
        }
    }

    public void comboBox(ActionEvent actionEvent) {
       this.classesService.setClassesFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }
}
