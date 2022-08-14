package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

    ArrayList<String> listNames = new ArrayList<String>();
    
    @FXML
    private ChoiceBox<String> selectUserChoiceBox;
    
    private UsersData members = new UsersData(new ArrayList<User>());

    
   Map<String, User> memberMap = new HashMap<>();
   
    void getLogInScene(User currentUser) {
    	Scene mainScene = applicationStage.getScene();
    	VBox logInContainer = new VBox();
    	
    
    	Label userNameLabel = new Label();
    	userNameLabel.setText("Name : " + currentUser.getFirstName() + currentUser.getLastName());
    	
    	Label userAgeLabel = new Label();
    	userAgeLabel.setText("Age: " + currentUser.getAge());
    	
    	Label userHeight = new Label();
    	userHeight.setText("Your current height is: " + currentUser.getHeight() + "m");
    	
    	Label userWeight = new Label();
    	userWeight.setText("Your weight is: " + currentUser.getCurrentWeight() + "kg");
    	
    	HBox weightContainer = new HBox();
    	Label inputWeightLabel = new Label();
    	inputWeightLabel.setText("Input your current weight: ");
    	TextField inputWeightTextField = new TextField();
    	
    	weightContainer.getChildren().addAll(inputWeightLabel, inputWeightTextField);
    	Button enterWeight = new Button("Enter Weight");
    	
    	
    	
    	Label weightUpdateLabel = new Label();
    	weightUpdateLabel.setText(" ");
    	
    	enterWeight.setOnAction(enterWeightEvent -> weightUpdateLabel.setText(currentUser.updateWeight(inputWeightTextField.getText())));
    	
    	
    	
    	Button logOutButton = new Button("Log Out");
    	logOutButton.setOnAction(logOutEvent -> applicationStage.setScene(mainScene));
    	logInContainer.getChildren().addAll(userNameLabel, userAgeLabel, userWeight, weightContainer, enterWeight, weightUpdateLabel, logOutButton);
    	

      Scene logInScene = new Scene(logInContainer);
    	applicationStage.setScene(logInScene);
    }
   
   @FXML
   void logIn() {
	   String selectedUser = selectUserChoiceBox.getValue();
	   User currentUser = memberMap.get(selectedUser);
	   if(passwordTextField.getText().equals(currentUser.getPassword())) {
		   getLogInScene(currentUser);
	   }
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
    	heightUnitLabel.setText("m");
    	heightContainer.getChildren().addAll(heightLabel, heightTextField, heightUnitLabel);
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel = new Label();
    	weightLabel.setText("Enter your weight in kg");
    	TextField weightTextField = new TextField();
    	Label weightUnitLabel = new Label();
    	weightUnitLabel.setText("kg");
    	weightContainer.getChildren().addAll(weightLabel, weightTextField, weightUnitLabel);
    	
    	HBox userWorkoutContainer = new HBox();
    	Label userWorkoutLabel = new Label();
    	userWorkoutLabel.setText("Include a workout routine?");
    	CheckBox userWorkoutCheckBox = new CheckBox("Yes");
    	
    	userWorkoutContainer.getChildren().addAll(userWorkoutLabel, userWorkoutCheckBox);
    	
    	HBox createAccButtonsContainer = new HBox();
    	Button createAccButton = new Button();
    	createAccButton.setText("Create Account");
    	Button cancelButton = new Button();
    	cancelButton.setText("Cancel");
    	cancelButton.setOnAction(cancelEvent -> applicationStage.setScene(mainScene));
    	createAccButtonsContainer.getChildren().addAll(createAccButton, cancelButton);
    	
    	Label createAccErrorLabel = new Label();
    	createAccErrorLabel.setText("");
    	
    	createAccContainer.getChildren().addAll(firstNameContainer, lastNameContainer,passwordContainer, ageContainer, genderContainer, heightContainer, weightContainer, userWorkoutContainer, createAccButtonsContainer, createAccErrorLabel);
    	
    	Scene createAccountScene = new Scene(createAccContainer);
    	applicationStage.setScene(createAccountScene);
    	createAccButton.setOnAction(createAccEvent -> createAccount(mainScene, firstNameTextField, lastNameTextField, passwordTextField, ageTextField, genderChoiceBox , heightTextField, weightTextField, userWorkoutCheckBox));
    	
    	

    }
    
    void createAccount(Scene mainScene, TextField firstNameTextField, TextField lastNameTextField , TextField passwordTextField , TextField ageTextField , ChoiceBox<String> genderChoiceBox , TextField heightTextField, TextField weightTextField, CheckBox userWorkoutCheckBox) {
    	boolean errorInCreateAcc = false; 
    	memberMap.put(firstNameTextField.getText() + " " + lastNameTextField.getText(), new User(firstNameTextField.getText(), lastNameTextField.getText(), passwordTextField.getText(), ageTextField.getText() , genderChoiceBox.getValue(), heightTextField.getText(), weightTextField.getText()));
    	User newUser = memberMap.get(firstNameTextField.getText() + " " + lastNameTextField.getText());
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
    		members.addUser(newUser);
    		listNames.add(firstNameTextField.getText() + " " + lastNameTextField.getText());
    		selectUserChoiceBox.setItems(FXCollections.observableArrayList(listNames));
    		applicationStage.setScene(mainScene);
    	}
    	else {
    		System.out.println("error" + newUser.getFirstName() + newUser.getLastName());
    		System.out.println("error"+  newUser.getAge());
    		System.out.println("error"+ newUser.getGender());
    		System.out.println("error"+ newUser.getHeight());
    		System.out.println("erorr" + newUser.getCurrentWeight());
    		memberMap.remove(firstNameTextField.getText() + " " + lastNameTextField.getText());
    	}
    	
    	
    }
    

    void setWorkoutScene(UserWorkout currentUser) {
    	Scene mainScene = applicationStage.getScene();
    	VBox workoutRoutineContainer = new VBox();
    	ArrayList<String> workoutTypes = new ArrayList<String>();
    	workoutTypes.add("Full Body");
    	workoutTypes.add("Upper Body");
    	workoutTypes.add("Lower Body");
    	workoutTypes.add("Cardio");
    	workoutTypes.add("Weight Lift");
    	workoutTypes.add("Legs");
    	workoutTypes.add("Light workout");
    	workoutTypes.add("General Wrokout");
    	workoutTypes.add("General Workout");
    	
    	HBox mondayContainer = new HBox();
    	Label mondayLabel = new Label();
    	mondayLabel.setText("Monday : ");
    	ChoiceBox<String> mondayWorkoutChoiceBox = new ChoiceBox<String>();
    	mondayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	mondayContainer.getChildren().addAll(mondayLabel, mondayWorkoutChoiceBox);
    	
    	HBox tuesdayContainer = new HBox();
    	Label tuesdayLabel = new Label();
    	tuesdayLabel.setText("Tuesday : ");
    	ChoiceBox<String> tuesdayWorkoutChoiceBox = new ChoiceBox<String>();
    	tuesdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	tuesdayContainer.getChildren().addAll(tuesdayLabel, tuesdayWorkoutChoiceBox);
    	
    	HBox wednesdayContainer = new HBox();
    	Label wednesdayLabel = new Label();
    	wednesdayLabel.setText("Wednesday : ");
    	ChoiceBox<String> wednesdayWorkoutChoiceBox = new ChoiceBox<String>();
    	wednesdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	wednesdayContainer.getChildren().addAll(wednesdayLabel, wednesdayWorkoutChoiceBox);
    	
    	HBox thursdayContainer = new HBox();
    	Label thursdayLabel = new Label();
    	thursdayLabel.setText("Thursday : ");
    	ChoiceBox<String> thursdayWorkoutChoiceBox = new ChoiceBox<String>();
    	thursdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	thursdayContainer.getChildren().addAll(thursdayLabel, thursdayWorkoutChoiceBox);
    	
    	HBox fridayContainer = new HBox();
    	Label fridayLabel = new Label();
    	fridayLabel.setText("Friday : ");
    	ChoiceBox<String> fridayWorkoutChoiceBox = new ChoiceBox<String>();
    	fridayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	fridayContainer.getChildren().addAll(fridayLabel, fridayWorkoutChoiceBox);
    	
    	HBox saturdayContainer = new HBox();
    	Label saturdayLabel = new Label();
    	saturdayLabel.setText("Saturday : ");
    	ChoiceBox<String> saturdayWorkoutChoiceBox = new ChoiceBox<String>();
    	saturdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	saturdayContainer.getChildren().addAll(saturdayLabel, saturdayWorkoutChoiceBox);
    	
    	HBox sundayContainer = new HBox();
    	Label sundayLabel = new Label();
    	sundayLabel.setText("Sunday : ");
    	ChoiceBox<String> sundayWorkoutChoiceBox = new ChoiceBox<String>();
    	sundayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	sundayContainer.getChildren().addAll(sundayLabel, sundayWorkoutChoiceBox);
    	
    	workoutRoutineContainer.getChildren().addAll(mondayContainer, tuesdayContainer, wednesdayContainer, thursdayContainer, fridayContainer, saturdayContainer, sundayContainer);
    	
    	
    }

}

