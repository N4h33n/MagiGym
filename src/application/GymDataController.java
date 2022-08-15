package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GymDataController {
	Stage applicationStage;

    @FXML
    private TextField passwordTextField;

    ArrayList<String> listNames = new ArrayList<String>();
    
    @FXML
    private ChoiceBox<String> selectUserChoiceBox;
    
    private UsersData members = new UsersData(new ArrayList<User>());

    
   Map<String, User> memberMap = new HashMap<>();
   
   @FXML
   private Label logInErrorLabel;
   
    void getLogInScene(User currentUser) {
    	Scene mainScene = applicationStage.getScene();
    	VBox logInContainer = new VBox();
    	BackgroundFill background_fill = new BackgroundFill(Color.web("#2E4057"), CornerRadii.EMPTY, Insets.EMPTY);
    	Background background = new Background(background_fill);
    	logInContainer.setBackground(background);
    	logInContainer.setStyle("-fx-font: 12 SansSerif");
    
    	Label userNameLabel = new Label();
    	userNameLabel.setText("Name : " + currentUser.getFirstName() + " " + currentUser.getLastName());
    	userNameLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userNameLabel, new Insets(10));
    	
    	Label userAgeLabel = new Label();
    	userAgeLabel.setText("Age: " + currentUser.getAge());
    	userAgeLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userAgeLabel, new Insets(10));
    	
    	Label userHeightLabel = new Label();
    	userHeightLabel.setText("Your current height is: " + currentUser.getHeight() + "m");
    	userHeightLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userHeightLabel, new Insets(10));
    	
    	Label userWeightLabel = new Label();
    	userWeightLabel.setText("Your weight is: " + currentUser.getCurrentWeight() + "kg");
    	userWeightLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userWeightLabel, new Insets(10));
    	
    	HBox weightContainer = new HBox();
    	Label inputWeightLabel = new Label();
    	inputWeightLabel.setText("Input your current weight: ");
    	inputWeightLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(inputWeightLabel, new Insets(10));
    	
    	TextField inputWeightTextField = new TextField();
    	HBox.setMargin( inputWeightTextField, new Insets(10));
    	
    	Label errorWeightLabel = new Label();
    	errorWeightLabel.setText("");
    	errorWeightLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(errorWeightLabel, new Insets(10));
    	
    	weightContainer.getChildren().addAll(inputWeightLabel, inputWeightTextField, errorWeightLabel);
    	Button enterWeight = new Button("Enter Weight");
    	VBox.setMargin(enterWeight, new Insets(10));
    	
    	
    	Label weightUpdateLabel = new Label();
    	weightUpdateLabel.setText(" ");
    	weightUpdateLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(weightUpdateLabel, new Insets(10));
    	
    	Label bmiLabel = new Label();
    	bmiLabel.setText(currentUser.setBmi());
    	bmiLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(bmiLabel, new Insets(10));
    	
    	enterWeight.setOnAction(enterWeightEvent -> updateWeightScene(weightUpdateLabel, userWeightLabel, bmiLabel, currentUser, inputWeightTextField.getText()));
    	
    	
    	Button logOutButton = new Button("Log Out");
    	
    	logOutButton.setOnAction(logOutEvent -> applicationStage.setScene(mainScene));
    	VBox.setMargin(logOutButton, new Insets(10));
    	
    	logInContainer.getChildren().addAll(userNameLabel, userAgeLabel, userWeightLabel, bmiLabel, weightContainer, enterWeight, weightUpdateLabel, logOutButton);
    	

      Scene logInScene = new Scene(logInContainer);
      
    	applicationStage.setScene(logInScene);
    }
    
    void getLogInWorkoutScene(UserWorkout currentUser) {
    	Scene mainScene = applicationStage.getScene();
    	VBox logInContainer = new VBox();
    	BackgroundFill background_fill = new BackgroundFill(Color.web("#2E4057"), CornerRadii.EMPTY, Insets.EMPTY);
    	Background background = new Background(background_fill);
    	logInContainer.setBackground(background);
    	logInContainer.setStyle("-fx-font: 12 SansSerif");
    	
    
    	Label userNameLabel = new Label();
    	userNameLabel.setText("Name : " + currentUser.getFirstName() + currentUser.getLastName());
    	userNameLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userNameLabel, new Insets(10));
    	
    	Label userAgeLabel = new Label();
    	userAgeLabel.setText("Age: " + currentUser.getAge());
    	userAgeLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userAgeLabel, new Insets(10));
    	
    	Label userHeightLabel = new Label();
    	userHeightLabel.setText("Your current height is: " + currentUser.getHeight() + "m");
    	userHeightLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userHeightLabel, new Insets(10));
    	
    	Label userWeightLabel = new Label();
    	userWeightLabel.setText("Your weight is: " + currentUser.getCurrentWeight() + "kg");
    	userWeightLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(userWeightLabel, new Insets(10));
    	
    	Label workoutLabel = new Label();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	int dayToday = calendar.get(Calendar.DAY_OF_WEEK);
    	
    	
    	for (int i = 0; i < currentUser.getDays().size(); i++) {
    		if (i+1 == dayToday) {
    			if (currentUser.getDays().get(i).getWorkoutType() == "Rest") {
    				workoutLabel.setText("You are not set to workout today.");
    				workoutLabel.setStyle("-fx-text-fill:white");
    			}
    			else {
    				workoutLabel.setText("You are set to do " + currentUser.getDays().get(i).getWorkoutType() + " for " + currentUser.getDays().get(i).getHours() + " hours.");
    				workoutLabel.setStyle("-fx-text-fill:white");
    			}
    			
    		}
    	}
    	
    	HBox weightContainer = new HBox();
    	Label inputWeightLabel = new Label();
    	inputWeightLabel.setText("Input your current weight: ");
    	inputWeightLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(inputWeightLabel, new Insets(10));
    	
    	TextField inputWeightTextField = new TextField();
    	HBox.setMargin( inputWeightTextField, new Insets(10));
    	
    	Label errorWeightLabel = new Label();
    	errorWeightLabel.setText("");
    	errorWeightLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(errorWeightLabel, new Insets(10));
    	
    	weightContainer.getChildren().addAll(inputWeightLabel, inputWeightTextField, errorWeightLabel);

    	Button enterWeight = new Button("Enter Weight");
    	VBox.setMargin(enterWeight, new Insets(10));
    	
    	
    	
    	Label weightUpdateLabel = new Label();
    	weightUpdateLabel.setText(" ");
    	weightUpdateLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(weightUpdateLabel, new Insets(10));
    	
    	Label bmiLabel = new Label();
    	bmiLabel.setText(currentUser.setBmi());
    	bmiLabel.setStyle("-fx-text-fill:white");
    	VBox.setMargin(bmiLabel, new Insets(10));
    	
    	enterWeight.setOnAction(enterWeightEvent -> updateWeightScene(weightUpdateLabel, userWeightLabel, bmiLabel, currentUser, inputWeightTextField.getText()));
    	
    	
    	Button logOutButton = new Button("Log Out");
    	logOutButton.setOnAction(logOutEvent -> applicationStage.setScene(mainScene));

    	logInContainer.getChildren().addAll(userNameLabel, userAgeLabel, userWeightLabel, bmiLabel, workoutLabel, weightContainer, enterWeight, weightUpdateLabel, logOutButton);

    	VBox.setMargin(logOutButton, new Insets(10));
    	
    	

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
	   User userSelected = memberMap.get(selectedUser);
	   if(selectedUser == null) {
		   logInErrorLabel.setText("Please select a user");
	   }
	   else {
		   if (!userSelected.isIncludeWorkout()) {
			   User currentUser = userSelected;
			   if(passwordTextField.getText().equals(currentUser.getPassword())) {
				   logInErrorLabel.setText("");
				   getLogInScene(currentUser);
				   passwordTextField.clear();
				   selectUserChoiceBox.valueProperty().set(null);
			   }
			   else {
				   logInErrorLabel.setText("Incorrect password for selected user");
			   }
		   }
		   else {
			   UserWorkout currentUser = (UserWorkout) userSelected;
			   if(passwordTextField.getText().equals(currentUser.getPassword())) {
				   logInErrorLabel.setText("");
				   getLogInWorkoutScene(currentUser);
				   passwordTextField.clear();
				   selectUserChoiceBox.valueProperty().set(null);
			   }
			   else {
				   logInErrorLabel.setText("Incorrect password for selected user");
			   }
		   }
	   }
   }

    

    @FXML
    void getCreateAccountScene(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox createAccContainer = new VBox();
    	BackgroundFill background_fill = new BackgroundFill(Color.web("#2E4057"), CornerRadii.EMPTY, Insets.EMPTY);
    	Background background = new Background(background_fill);
    	createAccContainer.setBackground(background);
    	createAccContainer.setStyle("-fx-font: 12 SansSerif");
    	
    	HBox firstNameContainer = new HBox();
    	Label firstNameLabel = new Label();
    	firstNameLabel.setText("Enter your first name");
    	firstNameLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(firstNameLabel, new Insets(10));
    	
    	TextField firstNameTextField = new TextField();
    	HBox.setMargin(firstNameTextField, new Insets(10));
    	
    	Label errorFirstName = new Label();
    	errorFirstName.setText("");
    	errorFirstName.setStyle("-fx-text-fill:white");
    	HBox.setMargin(errorFirstName, new Insets(10));
    	
    	firstNameContainer.getChildren().addAll(firstNameLabel, firstNameTextField, errorFirstName);
    	
    	HBox lastNameContainer = new HBox();
    	Label lastNameLabel = new Label();
    	lastNameLabel.setText("Enter your last name");
    	lastNameLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(lastNameLabel, new Insets(10));
    	
    	TextField lastNameTextField = new TextField();
    	HBox.setMargin(lastNameTextField, new Insets(10));
    	
    	Label errorLastName = new Label();
    	errorLastName.setText("");
    	errorLastName.setStyle("-fx-text-fill:white");
    	HBox.setMargin(errorLastName, new Insets(10));
    	
    	lastNameContainer.getChildren().addAll(lastNameLabel, lastNameTextField, errorLastName);
    	
    	HBox passwordContainer = new HBox();
    	Label passwordLabel = new Label();
    	passwordLabel.setText("Enter a 6 to 10 digit password");
    	passwordLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(passwordLabel, new Insets(10));
    	
    	TextField passwordTextField = new TextField();
    	HBox.setMargin(passwordTextField, new Insets(10));
    	
    	Label errorPassword = new Label();
    	errorPassword.setText("");
    	errorPassword.setStyle("-fx-text-fill:white");
    	
    	HBox.setMargin(errorPassword, new Insets(10));
    	
    	passwordContainer.getChildren().addAll(passwordLabel, passwordTextField, errorPassword);
    	
    	HBox ageContainer = new HBox();
    	Label ageLabel = new Label();
    	ageLabel.setText("Enter your age");
    	ageLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(ageLabel, new Insets(10));
    	
    	TextField ageTextField = new TextField();
    	HBox.setMargin(ageTextField, new Insets(10));
    	
    	Label errorAge = new Label();
    	errorAge.setText("");
    	errorAge.setStyle("-fx-text-fill:white");
    	HBox.setMargin(errorAge, new Insets(10));
    	
    	ageContainer.getChildren().addAll(ageLabel, ageTextField, errorAge);
    	
    	HBox genderContainer = new HBox();
    	Label genderLabel = new Label();
        genderLabel.setText("Select your gender");
        genderLabel.setStyle("-fx-text-fill:white");
        HBox.setMargin(genderLabel, new Insets(10));
        
    	ChoiceBox<String> genderChoiceBox = new ChoiceBox<String>();
    	genderChoiceBox.getItems().add("Male");
    	genderChoiceBox.getItems().add("Female");
    	HBox.setMargin(genderChoiceBox, new Insets(10));
    	
    	Label errorGender = new Label();
    	errorGender.setText("");
    	HBox.setMargin(errorGender, new Insets(10));
    	
    	genderContainer.getChildren().addAll(genderLabel, genderChoiceBox, errorGender);
    	
    	HBox heightContainer = new HBox();
    	Label heightLabel = new Label();
    	heightLabel.setText("Enter your height in meters");
    	heightLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(heightLabel, new Insets(10));
    	
    	TextField heightTextField = new TextField();
    	HBox.setMargin(heightTextField, new Insets(10));
    	
    	Label errorHeight = new Label();
    	errorHeight.setText("");
    	errorHeight.setStyle("-fx-text-fill:white");
    	HBox.setMargin(errorHeight, new Insets(10));
    	
    	Label heightUnitLabel = new Label();
    	heightUnitLabel.setText("m");
    	heightUnitLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(heightUnitLabel, new Insets(10));
    	
    	heightContainer.getChildren().addAll(heightLabel, heightTextField, heightUnitLabel, errorHeight);
    	
    	HBox weightContainer = new HBox();
    	Label weightLabel = new Label();
    	weightLabel.setText("Enter your weight in kg");
    	weightLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(weightLabel, new Insets(10)); 
    	
    	TextField weightTextField = new TextField();
    	HBox.setMargin(weightTextField, new Insets(10)); 
    	
    	Label errorWeight = new Label();
    	errorWeight.setText("");
    	HBox.setMargin(errorWeight, new Insets(10)); 
    	
    	Label weightUnitLabel = new Label();
    	weightUnitLabel.setText("kg");
    	weightUnitLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin( weightUnitLabel, new Insets(10));
    	
    	weightContainer.getChildren().addAll(weightLabel, weightTextField, weightUnitLabel, errorWeight);
    	
    	HBox userWorkoutContainer = new HBox();
    	Label userWorkoutLabel = new Label();
    	userWorkoutLabel.setText("Include a workout routine?");
    	userWorkoutLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin( userWorkoutLabel, new Insets(10));
    	
    	CheckBox userWorkoutCheckBox = new CheckBox("Yes");
    	userWorkoutCheckBox.setStyle("-fx-text-fill:white");
    	HBox.setMargin(userWorkoutCheckBox, new Insets(10));
    	
    	userWorkoutContainer.getChildren().addAll(userWorkoutLabel, userWorkoutCheckBox);
    	
    	HBox createAccButtonsContainer = new HBox();
    	Button createAccButton = new Button();
    	createAccButton.setText("Create Account");
    	HBox.setMargin(createAccButton, new Insets(10));
    	
    	Button cancelButton = new Button();
    	cancelButton.setText("Cancel");
    	cancelButton.setOnAction(cancelEvent -> applicationStage.setScene(mainScene));
    	HBox.setMargin(cancelButton, new Insets(10));
    	
    	createAccButtonsContainer.getChildren().addAll(createAccButton, cancelButton);
    	
    	Label createAccErrorLabel = new Label();
    	createAccErrorLabel.setText("");
    	createAccErrorLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(createAccErrorLabel, new Insets(10));
    	
    	createAccContainer.getChildren().addAll(firstNameContainer, lastNameContainer,passwordContainer, ageContainer, genderContainer, heightContainer, weightContainer, userWorkoutContainer, createAccButtonsContainer, createAccErrorLabel);
    	
    	Scene createAccountScene = new Scene(createAccContainer);
    	applicationStage.setScene(createAccountScene);
    	createAccButton.setOnAction(createAccEvent -> createAccount(mainScene, firstNameTextField, errorFirstName, lastNameTextField, errorLastName, passwordTextField, errorPassword, ageTextField, errorAge, genderChoiceBox , errorGender, heightTextField, errorHeight, weightTextField, errorWeight, userWorkoutCheckBox));
    	
    	

    }
    
    void createAccount(Scene mainScene, TextField firstNameTextField, Label errorFirstName, TextField lastNameTextField , Label errorLastName, TextField passwordTextField , Label errorPassword,TextField ageTextField , Label errorAge, ChoiceBox<String> genderChoiceBox , Label errorGender, TextField heightTextField, Label errorHeight, TextField weightTextField, Label errorWeight,CheckBox userWorkoutCheckBox) {
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
        		errorFirstName.setText("Make sure name is alphabetic");
        	}
    		else {
    			errorFirstName.setText("");
    		}
        	if (newUser.getLastName() == null) {
        		errorInCreateAcc = true;
        		errorLastName.setText("Make sure name is alphabetic");
        	}
        	else {
    			errorLastName.setText("");
    		}
        	if (newUser.getPassword() == null) {
        		errorInCreateAcc = true;
        		errorPassword.setText("Password has to be between 6 and 10 characters");
        	}
        	else {
    			errorPassword.setText("");
    		}
        	if (newUser.getAge() == -1) {
        		errorInCreateAcc = true;
        		errorAge.setText("Please enter a valid positive number");
        	}
        	else if (newUser.getAge() == -2) {
        		errorInCreateAcc = true;
        		errorAge.setText("You have to be 18 or older to create an account");
        	}
        	else {
    			errorAge.setText("");
    		}
        	if (newUser.getGender() == null) {
        		errorInCreateAcc = true;
        		errorGender.setText("Please select an option");
        	}
        	else {
    			errorGender.setText("");
    		}
        	if (newUser.getHeight() == -1) {
        		errorInCreateAcc = true;
        		errorHeight.setText("Please enter a valid positive number");
        	}
        	else {
    			errorHeight.setText("");
    		}
        	if (newUser.getCurrentWeight() == -1) {
        		errorInCreateAcc = true;
        		errorWeight.setText("Please enter a valid positive number");
        	}
        	else {
    			errorWeight.setText("");
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
        		errorFirstName.setText("Make sure name is alphabetic");
        		}
    		else {
    			errorFirstName.setText("");
    		}
        	if (newUser.getLastName() == null) {
        		errorInCreateAcc = true;
        		errorLastName.setText("Make sure name is alphabetic");
        	}
        	else {
    			errorLastName.setText("");
    		}
        	if (newUser.getPassword() == null) {
        		errorInCreateAcc = true;
        		errorPassword.setText("Password has to be between 6 and 10 characters");
        	}
        	else {
    			errorPassword.setText("");
    		}
        	if (newUser.getAge() == -1) {
        		errorInCreateAcc = true;
        		errorAge.setText("Please enter a valid positive number");
        	}
        	else if (newUser.getAge() == -2) {
        		errorInCreateAcc = true;
        		errorAge.setText("You have to be 18 or older to create an account");
        	}
        	else {
    			errorAge.setText("");
    		}
        	if (newUser.getGender() == null) {
        		errorInCreateAcc = true;
        		errorGender.setText("Please select an option");
        	}
        	else {
    			errorAge.setText("");
    		}
        	if (newUser.getHeight() == -1) {
        		errorInCreateAcc = true;
        		errorHeight.setText("Please enter a valid positive number");
        	}
        	else {
    			errorHeight.setText("");
    		}
        	if (newUser.getCurrentWeight() == -1) {
        		errorInCreateAcc = true;
        		errorWeight.setText("Please enter a valid positive number");
        	}
        	else {
    			errorWeight.setText("");
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
    	BackgroundFill background_fill = new BackgroundFill(Color.web("#2E4057"), CornerRadii.EMPTY, Insets.EMPTY);
    	Background background = new Background(background_fill);
    	workoutRoutineContainer.setBackground(background);
    	workoutRoutineContainer.setStyle("-fx-font: 12 SansSerif");
    	
    	ArrayList<String> workoutTypes = new ArrayList<String>();
    	workoutTypes.add("Full Body");
    	workoutTypes.add("Upper Body");
    	workoutTypes.add("Lower Body");
    	workoutTypes.add("Cardio");
    	workoutTypes.add("Weight Lift");
    	workoutTypes.add("Legs");
    	workoutTypes.add("Light workout");
    	workoutTypes.add("General Wrokout");
    	workoutTypes.add("Rest");
    	
    	HBox sundayContainer = new HBox();
    	Label sundayLabel = new Label();
    	sundayLabel.setText("Sunday : ");
    	sundayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(sundayLabel, new Insets(10));
    	
    	ChoiceBox<String> sundayWorkoutChoiceBox = new ChoiceBox<String>();
    	sundayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	HBox.setMargin(sundayWorkoutChoiceBox, new Insets(10));
    	
    	TextField sundayHours = new TextField();
    	HBox.setMargin(sundayHours, new Insets(10));
    	
    	Label sundayHoursLabel = new Label("Hours");
    	sundayHoursLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(sundayHoursLabel, new Insets(10));
    	
    	sundayContainer.getChildren().addAll(sundayLabel, sundayWorkoutChoiceBox, sundayHours, sundayHoursLabel);
    	
    	HBox mondayContainer = new HBox();
    	Label mondayLabel = new Label();
    	mondayLabel.setText("Monday : ");
    	mondayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(mondayLabel, new Insets(10));
    	
    	ChoiceBox<String> mondayWorkoutChoiceBox = new ChoiceBox<String>();
    	mondayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	HBox.setMargin(mondayWorkoutChoiceBox, new Insets(10));
    	
    	TextField mondayHours = new TextField();
    	HBox.setMargin(mondayHours, new Insets(10));
    	
    	Label mondayHoursLabel = new Label("Hours");
    	mondayHoursLabel .setStyle("-fx-text-fill:white");
    	HBox.setMargin(mondayHoursLabel, new Insets(10));
    	
    	mondayContainer.getChildren().addAll(mondayLabel, mondayWorkoutChoiceBox, mondayHours, mondayHoursLabel);
    	
    	HBox tuesdayContainer = new HBox();
    	Label tuesdayLabel = new Label();
    	tuesdayLabel.setText("Tuesday : ");
    	tuesdayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(tuesdayLabel, new Insets(10));
    	
    	ChoiceBox<String> tuesdayWorkoutChoiceBox = new ChoiceBox<String>();
    	tuesdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	HBox.setMargin(tuesdayWorkoutChoiceBox, new Insets(10));
    	
    	TextField tuesdayHours = new TextField();
    	HBox.setMargin(tuesdayHours, new Insets(10));
    	
    	Label tuesdayHoursLabel = new Label("Hours");
    	tuesdayHoursLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(tuesdayHoursLabel, new Insets(10));
    	
    	tuesdayContainer.getChildren().addAll(tuesdayLabel, tuesdayWorkoutChoiceBox, tuesdayHours, tuesdayHoursLabel);
    	
    	HBox wednesdayContainer = new HBox();
    	
    	Label wednesdayLabel = new Label();
    	wednesdayLabel.setText("Wednesday : ");
    	wednesdayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(wednesdayLabel, new Insets(10));
    	
    	ChoiceBox<String> wednesdayWorkoutChoiceBox = new ChoiceBox<String>();
    	wednesdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	HBox.setMargin(wednesdayWorkoutChoiceBox, new Insets(10));
    	
    	TextField wednesdayHours = new TextField();
    	HBox.setMargin(wednesdayHours, new Insets(10));
    	
    	Label wednesdayHoursLabel = new Label("Hours");
    	wednesdayHoursLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(wednesdayHoursLabel, new Insets(10));
    	
    	wednesdayContainer.getChildren().addAll(wednesdayLabel, wednesdayWorkoutChoiceBox, wednesdayHours, wednesdayHoursLabel);
    	
    	HBox thursdayContainer = new HBox();
    	Label thursdayLabel = new Label();
    	thursdayLabel.setText("Thursday : ");
    	thursdayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(thursdayLabel, new Insets(10));
    	
    	ChoiceBox<String> thursdayWorkoutChoiceBox = new ChoiceBox<String>();
    	thursdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	HBox.setMargin( thursdayWorkoutChoiceBox, new Insets(10));
    	
    	TextField thursdayHours = new TextField();
    	HBox.setMargin(thursdayHours, new Insets(10));
    	
    	Label thursdayHoursLabel = new Label("Hours");
    	thursdayHoursLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin( thursdayHoursLabel, new Insets(10));
    	
    	thursdayContainer.getChildren().addAll(thursdayLabel, thursdayWorkoutChoiceBox, thursdayHours, thursdayHoursLabel);
    	
    	HBox fridayContainer = new HBox();
    	Label fridayLabel = new Label();
    	fridayLabel.setText("Friday : ");
    	fridayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(fridayLabel, new Insets(10));
    	
    	ChoiceBox<String> fridayWorkoutChoiceBox = new ChoiceBox<String>();
    	fridayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
    	HBox.setMargin(fridayWorkoutChoiceBox, new Insets(10));
    	
    	TextField fridayHours = new TextField();
    	HBox.setMargin(fridayHours, new Insets(10));
    	
    	Label fridayHoursLabel = new Label("Hours");
    	fridayHoursLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin( fridayHoursLabel, new Insets(10));
    	
    	fridayContainer.getChildren().addAll(fridayLabel, fridayWorkoutChoiceBox, fridayHours, fridayHoursLabel);
    	
    	HBox saturdayContainer = new HBox();
    	Label saturdayLabel = new Label();
    	saturdayLabel.setText("Saturday : ");
    	saturdayLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(saturdayLabel, new Insets(10));
    	
    	ChoiceBox<String> saturdayWorkoutChoiceBox = new ChoiceBox<String>();
        saturdayWorkoutChoiceBox.setItems(FXCollections.observableArrayList(workoutTypes));
        HBox.setMargin(saturdayWorkoutChoiceBox, new Insets(10));
        
    	TextField saturdayHours = new TextField();
    	HBox.setMargin(saturdayHours, new Insets(10));
    	
    	 
    	Label saturdayHoursLabel = new Label("Hours");
    	saturdayHoursLabel.setStyle("-fx-text-fill:white");
    	HBox.setMargin(saturdayHoursLabel, new Insets(10));

    	saturdayContainer.getChildren().addAll(saturdayLabel, saturdayWorkoutChoiceBox, saturdayHours, saturdayHoursLabel);
    	
    	Button createRoutineButton = new Button();
    	createRoutineButton.setText("Create Routine");
    	VBox.setMargin(createRoutineButton, new Insets(10));
    	
    	Label errorRoutine = new Label();
    	errorRoutine.setStyle("-fx-text-fill:white");
    	errorRoutine.setText("");
    	VBox.setMargin(errorRoutine, new Insets(10));
    	
    	workoutRoutineContainer.getChildren().addAll(sundayContainer, mondayContainer, tuesdayContainer, wednesdayContainer, thursdayContainer, fridayContainer, saturdayContainer, createRoutineButton, errorRoutine);
    	
    	Scene createWorkoutScene = new Scene(workoutRoutineContainer);
    	applicationStage.setScene(createWorkoutScene);
    	createRoutineButton.setOnAction(createRoutineEvent -> createRoutine(mainScene, currentUser, sundayWorkoutChoiceBox, sundayHours, mondayWorkoutChoiceBox, mondayHours, tuesdayWorkoutChoiceBox, tuesdayHours, wednesdayWorkoutChoiceBox, wednesdayHours, thursdayWorkoutChoiceBox, thursdayHours, fridayWorkoutChoiceBox, fridayHours, saturdayWorkoutChoiceBox, saturdayHours, errorRoutine));
    }
    
    void createRoutine(Scene mainScene, UserWorkout currentUser,ChoiceBox<String>  sundayWorkoutChoiceBox, TextField sundayHours, ChoiceBox<String>  mondayWorkoutChoiceBox, TextField mondayHours, ChoiceBox<String> tuesdayWorkoutChoiceBox, TextField tuesdayHours, ChoiceBox<String> wednesdayWorkoutChoiceBox, TextField wednesdayHours, ChoiceBox<String> thursdayWorkoutChoiceBox, TextField thursdayHours, ChoiceBox<String> fridayWorkoutChoiceBox, TextField fridayHours, ChoiceBox<String> saturdayWorkoutChoiceBox, TextField saturdayHours, Label errorRoutine) {
    	
    	boolean errorInRoutine = false;
    	
    	currentUser.setSunday(new Day(sundayWorkoutChoiceBox.getValue(), sundayHours.getText(), "Sunday"));
    	currentUser.setMonday(new Day(mondayWorkoutChoiceBox.getValue(), mondayHours.getText(), "Monday"));
    	currentUser.setTuesday(new Day(tuesdayWorkoutChoiceBox.getValue(), tuesdayHours.getText(), "Tuesday"));
    	currentUser.setWednesday(new Day(wednesdayWorkoutChoiceBox.getValue(), wednesdayHours.getText(), "Wednesday"));
    	currentUser.setThursday(new Day(thursdayWorkoutChoiceBox.getValue(), thursdayHours.getText(), "Thursday"));
    	currentUser.setFriday(new Day(fridayWorkoutChoiceBox.getValue(), fridayHours.getText(), "Friday"));
    	currentUser.setSaturday(new Day(saturdayWorkoutChoiceBox.getValue(), saturdayHours.getText(), "Saturday"));
    	
    	if(currentUser.getSunday().getHours() == -1 || currentUser.getMonday().getHours() == -1 || currentUser.getTuesday().getHours() == -1 || currentUser.getWednesday().getHours() == -1 || currentUser.getThursday().getHours() == -1 || currentUser.getFriday().getHours() == -1 || currentUser.getSaturday().getHours() == -1 || currentUser.getSunday().getWorkoutType() == null || currentUser.getMonday().getWorkoutType() == null || currentUser.getTuesday().getWorkoutType() == null || currentUser.getWednesday().getWorkoutType() == null || currentUser.getThursday().getWorkoutType() == null || currentUser.getFriday().getWorkoutType() == null || currentUser.getSaturday().getWorkoutType() == null) {
    		errorInRoutine = true;
    		errorRoutine.setText("Enter valid number inout for hours between 0 to 24");
    	}
    	if(!errorInRoutine) {
	    	ArrayList<Day> dayList = new ArrayList<Day>();
	    	dayList.add(currentUser.getSunday());
	    	dayList.add(currentUser.getMonday());
	    	dayList.add(currentUser.getTuesday());
	    	dayList.add(currentUser.getWednesday());
	    	dayList.add(currentUser.getThursday());
	    	dayList.add(currentUser.getFriday());
	    	dayList.add(currentUser.getSaturday());
	    	
	    	
	    	currentUser.setDays(dayList);
	    	applicationStage.setScene(mainScene);
    	}
    }

}

