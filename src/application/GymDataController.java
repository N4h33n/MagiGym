package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    	Scene mainScene = applicationStage.getScene();
    	VBox logInContainer = new VBox();
    	
    
    	Label userNameLabel = new Label();
    	userNameLabel.setText("Name : ");
    	
    	Label userAgeLabel = new Label();
    	userAgeLabel.setText("Age: ");
    	
    	Label userWeight = new Label();
    	userWeight.setText("Your current weight is: ");
    	
    	HBox weightContainer = new HBox();
    	Label inputWeightLabel = new Label();
    	inputWeightLabel.setText("Input your current weight ");
    	TextField inputWeightTextField = new TextField();
    	
    	weightContainer.getChildren().addAll(inputWeightLabel, inputWeightTextField);
    	Button enterWeight = new Button("Enter Weight");
    	
    	Label weightUpdateLabel = new Label();
    	weightUpdateLabel.setText(" ");
    	
    	logInContainer.getChildren().addAll(userNameLabel, userAgeLabel, userWeight, weightContainer, enterWeight, weightUpdateLabel);
    	
    	
    	Scene logInScene = new Scene(logInContainer);
    	applicationStage.setScene(logInScene);
    }

    

    @FXML
    void createAccount(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox createAccContainer = new VBox();
    	
    	HBox firstNameContainer = new HBox();
    	Label firstNameLabel = new Label();
    	firstNameLabel.setText("Enter your first name");
    	TextField firstNameTextField = new TextField();
    	firstNameContainer.getChildren().addAll(firstNameLabel, firstNameTextField);
    	
    	HBox lastNameContainer = new HBox();
    	Label lastNameLabel = new Label();
    	lastNameLabel.setText("Enter your last name");
    	TextField lastNameTextField = new TextField();
    	lastNameContainer.getChildren().addAll(lastNameLabel, lastNameTextField);
    	
    	HBox passwordContainer = new HBox();
    	Label passwordLabel = new Label();
    	passwordLabel.setText("Enter a 6 to 10 digit password");
    	TextField passwordTextField = new TextField();
    	passwordContainer.getChildren().addAll(passwordLabel, passwordTextField);
    	
    	HBox ageContainer = new HBox();
    	Label ageLabel = new Label();
    	ageLabel.setText("Enter your age");
    	TextField ageTextField = new TextField();
    	ageContainer.getChildren().addAll(ageLabel, ageTextField);
    	
    	HBox genderContainer = new HBox();
    	Label genderLabel = new Label();
    	genderLabel.setText("Select your gender");
    	ChoiceBox<String> genderChoiceBox = new ChoiceBox<String>();
    	genderChoiceBox.getItems().add("Male");
    	genderChoiceBox.getItems().add("Female");
    	genderContainer.getChildren().addAll(genderLabel, genderChoiceBox);
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel = new Label();
    	weightLabel.setText("Enter your weight in kg");
    	TextField weightTextField = new TextField();
    	Label unitLabel = new Label();
    	unitLabel.setText("kg");
    	weightContainer.getChildren().addAll(weightLabel, weightTextField, unitLabel);
    	
    	createAccContainer.getChildren().addAll(firstNameContainer, lastNameContainer,passwordContainer, ageContainer, genderContainer, weightContainer);
    	
    	Scene createAccountScene = new Scene(createAccContainer);
    	applicationStage.setScene(createAccountScene);
    	

    }

    

}

