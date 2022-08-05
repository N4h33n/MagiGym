package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class GymDataController {
	Stage applicationStage;

    @FXML
    private TextField passwordTextFiled;

    @FXML
    private ChoiceBox<?> selectUserChoiceBox;

    

    @FXML
    void logIn(ActionEvent event) {
    	
    	Scene logInScene = new Scene(new Label("We will update"));
    	applicationStage.setScene(logInScene);
    }

    

    @FXML
    void createAccount(ActionEvent event) {
    	Scene createAccountScene = new Scene(new Label("We Shall Add things"));
    	applicationStage.setScene(createAccountScene);
    	

    }

    

}

