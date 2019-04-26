package Controllers;

import Modele.Classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import modelFX.ClasFx;
import services.ClassesService;

public class AdminClassController {

    @FXML
    private Button addClassButton;

    @FXML
    private Button deleteClassButton;

    @FXML
    private TextField lbClassName;

    @FXML
    private ComboBox<ClasFx> cbClass;

    @FXML
    private TreeView<String> classTreeView;

    private ClassesService classesService;
    private Classes classes;
    private ClasFx clasFx;

    @FXML
    public void initialize(){
        this.classesService = new ClassesService();
        try{
            this.classesService.init();
        }catch (Exception e){

        }

        this.cbClass.setItems(this.classesService.getClasFxObservableList());
        this.classTreeView.setRoot(this.classesService.getRoot());


        this.addClassButton.disableProperty().bind(lbClassName.textProperty().isEmpty());
        this.deleteClassButton.disableProperty().bind(this.classesService.clasFxObjectPropertyProperty().isNull());
    }

    public void addClass(ActionEvent actionEvent) {
        try{
           // String name = lbClassName.getText();
          //  this.classes = new Classes(name);
          //  classesService.persist(this.classes);
            classesService.saveClassInDataBase(lbClassName.getText());
        }catch (Exception e){
            System.out.println("Nie dodano do bazy");
        }
    }

    public void deleteClass(ActionEvent actionEvent) {
        try{
            this.classesService.delete();
        }catch (Exception e){
            System.out.println("nie usunieto");
        }
    }

    public void comboBox(ActionEvent actionEvent) {
        this.classesService.setClasFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }
}
