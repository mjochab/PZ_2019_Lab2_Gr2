package Controllers;

import Modele.Classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
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

    /**
     * Inicjacja klasy kontrolera .
     */
    @FXML
    public void initialize(){
        this.classesService = new ClassesService();
        this.classesService.init();



        this.cbClass.setItems(this.classesService.getClassesFxObservableList());
        this.classTreeView.setRoot(this.classesService.getRoot());


        this.addClassButton.disableProperty().bind(lbClassName.textProperty().isEmpty());
        this.deleteClassButton.disableProperty().bind(this.classesService.classesFxObjectPropertyProperty().isNull());
    }

    /**
     * Metoda dodaje nową klase do bazy.
     *
     * @param actionEvent
     */
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

    /**
     * Metoda usuwa klase z bazy.
     *
     * @param actionEvent
     */
    public void deleteClass(ActionEvent actionEvent) {
        try{
           this.classesService.delete(cbClass.getValue().getClassId());
        }catch (Exception e){
            System.out.println("nie usunieto");
        }
    }

    public void comboBox(ActionEvent actionEvent) {
       this.classesService.setClassesFxObjectProperty(this.cbClass.getSelectionModel().getSelectedItem());
    }
}
