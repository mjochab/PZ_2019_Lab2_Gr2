package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class StudentViewController  {
    @FXML
    private BorderPane borderPane;
    @FXML
    private ToggleButtonMenuStudentController toggleButtonMenuStudentController;
    @FXML
    private Label lbluser;

    @FXML
    private void initialize(){
        toggleButtonMenuStudentController.setStudentViewController(this);

    }

    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try{
            parent = loader.load();

        }catch(IOException e){
            e.printStackTrace();
        }
        borderPane.setCenter(parent);
    }

    public void btnWyloguj(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }
}
