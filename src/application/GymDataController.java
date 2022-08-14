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
    	
    	Label userHeightLabel = new Label();
    	userHeightLabel.setText("Your current height is: " + currentUser.getHeight() + "m");
    	
    	Label userWeightLabel = new Label();
    	userWeightLabel.setText("Your weight is: " + currentUser.getCurrentWeight() + "kg");
    	
    	HBox weightContainer = new HBox();
    	Label inputWeightLabel = new Label();
    	inputWeightLabel.setText("Input your current weight: ");
    	TextField inputWeightTextField = new TextField();
    	Label errorWeightLabel = new Label();
    	errorWeightLabel.setText("");
    	
    	weightContainer.getChildren().addAll(inputWeightLabel, inputWeightTextField, errorWeightLabel);
    	Button enterWeight = new Button("Enter Weight");
    	
    	
    	
    	Label weightUpdateLabel = new Label();
    	weightUpdateLabel.setText(" ");
    	
    	Label bmiLabel = new Label();
    	bmiLabel.setText(currentUser.setBmi());
    	
    	enterWeight.setOnAction(enterWeightEvent -> updateWeightScene(weightUpdateLabel, userWeightLabel, bmiLabel, currentUser, inputWeightTextField.getText()));
    	
    	
    	Button logOutButton = new Button("Log Out");
    	logOutButton.setOnAction(logOutEvent -> applicationStage.setScene(mainScene));
    	logInContainer.getChildren().addAll(userNameLabel, userAgeLabel, userWeightLabel, bmiLabel, weightContainer, enterWeight, weightUpdateLabel, logOutButton);
    	

      Scene logInScene = new Scene(logInContainer);
    	applicationStage.setScene(logInScene);
    }
    
    void updateWeightScene(Label weightUpdateLabel, Label userWeightLabel, Label bmiLabel, User currentUser, String updatedWeight) {
    	weightUpdateLabel.setText(currentUser.updateWeight(updatedWeight));
    	bmiLabel.setText(currentUser.setBmi());
    	userWeightLabel.setText("Your weight is: " + currentUser.getCurrentWeight() + "kg");
    	
    	
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
    	Label errorFirstName = new Label();
    	errorFirstName.setText("");
    	firstNameContainer.getChildren().addAll(firstNameLabel, firstNameTextField);
    	
    	HBox lastNameContainer = new HBox();
    	Label lastNameLabel = new Label();
    	lastNameLabel.setText("Enter your last name");
    	TextField lastNameTextField = new TextField();
    	Label errorLastName = new Label();
    	errorLastName.setText("");
    	lastNameContainer.getChildren().addAll(lastNameLabel, lastNameTextField);
    	
    	HBox passwordContainer = new HBox();
    	Label passwordLabel = new Label();
    	passwordLabel.setText("Enter a 6 to 10 digit password");
    	TextField passwordTextField = new TextField();
    	Label errorPassword = new Label();
    	errorPassword.setText("");
    	passwordContainer.getChildren().addAll(passwordLabel, passwordTextField);
    	
    	HBox ageContainer = new HBox();
    	Label ageLabel = new Label();
    	ageLabel.setText("Enter your age");
    	TextField ageTextField = new TextField();
    	Label errorAge = new Label();
    	errorAge.setText("");
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
    	Label errorHeight = new Label();
    	errorHeight.setText("");
    	Label heightUnitLabel = new Label();
    	heightUnitLabel.setText("m");
    	heightContainer.getChildren().addAll(heightLabel, heightTextField, heightUnitLabel);
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel = new Label();
    	weightLabel.setText("Enter your weight in kg");
    	TextField weightTextField = new TextField();
    	Label errorWeight = new Label();
    	errorWeight.setText("");
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
    	if(!userWorkoutCheckBox.isSelected()) {
    		memberMap.put(firstNameTextField.getText() + " " + lastNameTextField.getText(), new User(firstNameTextField.getText(), lastNameTextField.getText(), passwordTextField.getText(), ageTextField.getText() , genderChoiceBox.getValue(), heightTextField.getText(), weightTextField.getText(), userWorkoutCheckBox.isSelected()));
    	}
    	else {
    		memberMap.put(firstNameTextField.getText() + " " + lastNameTextField.getText(), new UserWorkout(firstNameTextField.getText(), lastNameTextField.getText(), passwordTextField.getText(), ageTextField.getText() , genderChoiceBox.getValue(), heightTextField.getText(), weightTextField.getText(), userWorkoutCheckBox.isSelected()));
    	}
    	if(!userWorkoutCheckBox.isSelected()) {
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
        		
        		memberMap.remove(firstNameTextField.getText() + " " + lastNameTextField.getText());
        	}
    	}
    	else {
    		UserWorkout newUser = (UserWorkout)memberMap.get(firstNameTextField.getText() + " " + lastNameTextField.getText());
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
        		setWorkoutScene(mainScene, newUser);
        	}
        	else {
        		
        		memberMap.remove(firstNameTextField.getText() + " " + lastNameTextField.getText());
        	}
    	}
    	
    	
    	
    }
    

    void setWorkoutScene(Scene mainScene, UserWorkout currentUser) {
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
    	TextField mondayHours = new TextField();
    	Label mondayHoursLabel = new Label("Hours");
    	mondayContainer.getChildren().addAll(mondayLabel, mondayWorkoutChoiceBox, mondayHours, mondayHoursLabel);
    	
    	HBox tuesdayContainer = new HBox();
    	Label tuesdayLabel = new Label();
    	tuesdayLabel.setText("Tuesday : ");
    	ChoiceBox<String> tuesdayWorkoutChoiceBox = new ChoiceBox<String>();
    	tuesdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	TextField tuesdayHours = new TextField();
    	Label tuesdayHoursLabel = new Label("Hours");
    	tuesdayContainer.getChildren().addAll(tuesdayLabel, tuesdayWorkoutChoiceBox, tuesdayHours, tuesdayHoursLabel);
    	
    	HBox wednesdayContainer = new HBox();
    	Label wednesdayLabel = new Label();
    	wednesdayLabel.setText("Wednesday : ");
    	ChoiceBox<String> wednesdayWorkoutChoiceBox = new ChoiceBox<String>();
    	wednesdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	TextField wednesdayHours = new TextField();
    	Label wednesdayHoursLabel = new Label("Hours");
    	wednesdayContainer.getChildren().addAll(wednesdayLabel, wednesdayWorkoutChoiceBox, wednesdayHours, wednesdayHoursLabel);
    	
    	HBox thursdayContainer = new HBox();
    	Label thursdayLabel = new Label();
    	thursdayLabel.setText("Thursday : ");
    	ChoiceBox<String> thursdayWorkoutChoiceBox = new ChoiceBox<String>();
    	thursdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	TextField thursdayHours = new TextField();
    	Label thursdayHoursLabel = new Label("Hours");
    	thursdayContainer.getChildren().addAll(thursdayLabel, thursdayWorkoutChoiceBox, thursdayHours, thursdayHoursLabel);
    	
    	HBox fridayContainer = new HBox();
    	Label fridayLabel = new Label();
    	fridayLabel.setText("Friday : ");
    	ChoiceBox<String> fridayWorkoutChoiceBox = new ChoiceBox<String>();
    	fridayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	TextField fridayHours = new TextField();
    	Label fridayHoursLabel = new Label("Hours");
    	fridayContainer.getChildren().addAll(fridayLabel, fridayWorkoutChoiceBox, fridayHours, fridayHoursLabel);
    	
    	HBox saturdayContainer = new HBox();
    	Label saturdayLabel = new Label();
    	saturdayLabel.setText("Saturday : ");
    	ChoiceBox<String> saturdayWorkoutChoiceBox = new ChoiceBox<String>();
    	saturdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	TextField saturdayHours = new TextField();
    	Label saturdayHoursLabel = new Label("Hours");
    	saturdayContainer.getChildren().addAll(saturdayLabel, saturdayWorkoutChoiceBox, saturdayHours, saturdayHoursLabel);
    	
    	HBox sundayContainer = new HBox();
    	Label sundayLabel = new Label();
    	sundayLabel.setText("Sunday : ");
    	ChoiceBox<String> sundayWorkoutChoiceBox = new ChoiceBox<String>();
    	sundayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	TextField sundayHours = new TextField();
    	Label sundayHoursLabel = new Label("Hours");
    	sundayContainer.getChildren().addAll(sundayLabel, sundayWorkoutChoiceBox, sundayHours, sundayHoursLabel);
    	
    	Button createRoutineButton = new Button();
    	createRoutineButton.setText("Create Routine");
    	
    	workoutRoutineContainer.getChildren().addAll(mondayContainer, tuesdayContainer, wednesdayContainer, thursdayContainer, fridayContainer, saturdayContainer, sundayContainer, createRoutineButton);
    	
    	Scene createWorkoutScene = new Scene(workoutRoutineContainer);
    	applicationStage.setScene(createWorkoutScene);
    	createRoutineButton.setOnAction(createRoutineEvent -> createRoutine(mainScene, currentUser, mondayWorkoutChoiceBox, mondayHours, tuesdayWorkoutChoiceBox, tuesdayHours, wednesdayWorkoutChoiceBox, wednesdayHours, thursdayWorkoutChoiceBox, thursdayHours, fridayWorkoutChoiceBox, fridayHours, saturdayWorkoutChoiceBox, saturdayHours, sundayWorkoutChoiceBox, sundayHours));
    }
    
    void createRoutine(Scene mainScene, UserWorkout currentUser, ChoiceBox<String> mondayWorkoutChoiceBox, TextField mondayHours, ChoiceBox<String> tuesdayWorkoutChoiceBox, TextField tuesdayHours, ChoiceBox<String> wednesdayWorkoutChoiceBox, TextField wednesdayHours, ChoiceBox<String> thursdayWorkoutChoiceBox, TextField thursdayHours, ChoiceBox<String> fridayWorkoutChoiceBox, TextField fridayHours, ChoiceBox<String> saturdayWorkoutChoiceBox, TextField saturdayHours, ChoiceBox<String> sundayWorkoutChoiceBox, TextField sundayHours) {
    	currentUser.setMonday(new Day(mondayWorkoutChoiceBox.getValue(), mondayHours.getText(), "Monday"));
    	currentUser.setTuesday(new Day(tuesdayWorkoutChoiceBox.getValue(), tuesdayHours.getText(), "Tuesday"));
    	currentUser.setWednesday(new Day(wednesdayWorkoutChoiceBox.getValue(), wednesdayHours.getText(), "Wednesday"));
    	currentUser.setThursday(new Day(thursdayWorkoutChoiceBox.getValue(), thursdayHours.getText(), "Thursday"));
    	currentUser.setFriday(new Day(fridayWorkoutChoiceBox.getValue(), fridayHours.getText(), "Friday"));
    	currentUser.setSaturday(new Day(saturdayWorkoutChoiceBox.getValue(), saturdayHours.getText(), "Saturday"));
    	currentUser.setSunday(new Day(sundayWorkoutChoiceBox.getValue(), sundayHours.getText(), "Sunday"));
    	
    	ArrayList<Day> dayList = new ArrayList<Day>();
    	dayList.add(currentUser.getMonday());
    	dayList.add(currentUser.getTuesday());
    	dayList.add(currentUser.getWednesday());
    	dayList.add(currentUser.getThursday());
    	dayList.add(currentUser.getFriday());
    	dayList.add(currentUser.getSaturday());
    	dayList.add(currentUser.getSunday());
    	
    	currentUser.setDays(dayList);
    	applicationStage.setScene(mainScene);
    }

}

