package application;

import java.util.ArrayList;

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
    private TextField passwordTextField;

    @FXML
    private ChoiceBox<?> selectUserChoiceBox;
    
    private UsersData membersList = new UsersData(new ArrayList<User>());

    

    @FXML

    void getLogInScene(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox logInContainer = new VBox();
    	
    
    	Label userNameLabel = new Label();
    	userNameLabel.setText("Name : ");
    	
    	Label userAgeLabel = new Label();
    	userAgeLabel.setText("Age: ");
    	
    	Label userHeight = new Label();
    	userHeight.setText("Your current height is: ");
    	
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
    void getCreateAccountScene(ActionEvent event) {
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
    	
    	HBox heightContainer = new HBox();
    	Label heightLabel = new Label();
    	heightLabel.setText("Enter your height in meters");
    	TextField heightTextField = new TextField();
    	Label heightUnitLabel = new Label();
    	heightUnitLabel.setText("kg");
    	heightContainer.getChildren().addAll(heightLabel, heightTextField, heightUnitLabel);
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel = new Label();
    	weightLabel.setText("Enter your weight in kg");
    	TextField weightTextField = new TextField();
    	Label weightUnitLabel = new Label();
    	weightUnitLabel.setText("kg");
    	weightContainer.getChildren().addAll(weightLabel, weightTextField, weightUnitLabel);
    	
    	HBox createAccButtonsContainer = new HBox();
    	Button createAccButton = new Button();
    	createAccButton.setText("Create Account");
    	Button cancelButton = new Button();
    	cancelButton.setText("Cancel");
    	cancelButton.setOnAction(cancelEvent -> applicationStage.setScene(mainScene));
    	createAccButtonsContainer.getChildren().addAll(createAccButton, cancelButton);
    	
    	Label createAccErrorLabel = new Label();
    	createAccErrorLabel.setText("");
    	
    	createAccContainer.getChildren().addAll(firstNameContainer, lastNameContainer,passwordContainer, ageContainer, genderContainer, heightContainer, weightContainer, createAccButtonsContainer, createAccErrorLabel);
    	
    	Scene createAccountScene = new Scene(createAccContainer);
    	applicationStage.setScene(createAccountScene);
    	

    }
    
    void createAccount(Scene mainScene, TextField firstNameTextField, TextField lastNameTextField , TextField passwordTextField , TextField ageTextField , ChoiceBox<String> genderChoiceBox , TextField heightTextField, TextField weightTextField) {
    	boolean errorInCreateAcc = false;
    	User newUser = new User(firstNameTextField.getText(), lastNameTextField.getText(), passwordTextField.getText(), ageTextField.getText() , genderChoiceBox.getValue(), heightTextField.getText(), weightTextField.getText() );
    	if (newUser.getFirstName() == null) {
    		errorInCreateAcc = true;
    	}
    	if (newUser.getLastName() == null) {
    		errorInCreateAcc = true;
    	}
    	if (newUser.getPassword() == null) {
    		errorInCreateAcc = true;
    	}
    	if (newUser.getAge() == -1) {
    		errorInCreateAcc = true;
    	}
    	if (newUser.getGender() == null) {
    		errorInCreateAcc = true;
    	}
    	if (newUser.getHeight() == -1) {
    		errorInCreateAcc = true;
    	}
    	if (newUser.getCurrentWeight() == -1) {
    		errorInCreateAcc = true;
    	}
    	
    	if(!errorInCreateAcc) {
    		membersList.addUser(newUser);
    	}
    	
    	
    }

    

}

