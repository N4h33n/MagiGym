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

    
   Map<String, User> memberMap = new HashMap<>();
   
   @FXML
   private Label logInErrorLabel;
   
   /**
    * get the scene where it shows the users data, bmi, and updates weight to the current weight. 
    * @param currentUser the user whose data is being manipulated
    */
   
    void getLogInScene(User currentUser) {
    	Scene mainScene = applicationStage.getScene();
    	VBox logInContainer = new VBox();
    	// we made use of Background and BackgroundFill classes to match the background of each scene to the main scene.
    	// we found the methods and their formats from here:
    	// https://www.geeksforgeeks.org/javafx-background-class/
    	BackgroundFill background_fill = new BackgroundFill(Color.web("#2E4057"), CornerRadii.EMPTY, Insets.EMPTY);
    	Background background = new Background(background_fill);
    	logInContainer.setBackground(background);
    	logInContainer.setStyle("-fx-font: 12 SansSerif");
    
    	Label userNameLabel = new Label();
    	userNameLabel.setText("Name : " + currentUser.getFirstName() + " " + currentUser.getLastName());
    	// we found out how to change the color of the text in a field from the following link:
    	// https://stackoverflow.com/questions/24702542/how-to-change-the-color-of-text-in-javafx-textfield
    	userNameLabel.setStyle("-fx-text-fill:white");
    	// we found out about hard coding margins for elements in the scene to make it look cleaner from here:
    	// https://www.demo2s.com/java/javafx-space-padding-and-margin.html
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
    
    /**
     * get the scene where it shows the users data, bmi, and updates weight to the current weight and the type of workout they have to do today and for how many hours. 
     * @param currentUser the user whose data is being manipulated
     */
    
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
    	// we found out how to use a combination of the Calendar and Date libraries to compare a given day to the current day in the week from here:
    	// https://www.baeldung.com/java-get-day-of-week
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
    
    /**
     * Changes user information to reflect new weight input by the user and also displays it on the screen
     * @param weightUpdateLabel a label which displays the weight change from the previous weight
     * @param userWeightLabel the label displaying the user's current weight to be updated
     * @param bmiLabel a label displaying the user's updated bmi
     * @param currentUser the User who's data is being manipulated
     * @param updatedWeight the updated weight input by the user
     */
    void updateWeightScene(Label weightUpdateLabel, Label userWeightLabel, Label bmiLabel, User currentUser, String updatedWeight) {
    	
    	weightUpdateLabel.setText(currentUser.updateWeight(updatedWeight));
    	bmiLabel.setText(currentUser.setBmi());
    	userWeightLabel.setText("Your weight is: " + currentUser.getCurrentWeight() + "kg");
    	
    	
    }

   @FXML
   /**
    * initiates the log in process by checking whether input for login is valid. If any error, suitable message is displayed
    * using labels. If valid, method to change scene is called.
    */
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
				   // we found out how to clear previous input for a text field from here to prevent privacy issues:
				   // https://o7planning.org/11093/javafx-textfield
				   passwordTextField.clear();
				   // we found out about clearing a selected choice for a combobox from here and applied the same method for a chociebox:
				   // https://stackoverflow.com/questions/12142518/combobox-clearing-value-issue
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

    
   /**
    * get the scene where the user inputs information to create an account for them
    * @param event an ActionEvent
    */
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
    	errorGender.setStyle("-fx-text-fill:white");
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
    	errorWeight.setStyle("-fx-text-fill:white");
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
    	// set action of the cancel button to retur to the main scene
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
    	// set action of the create account button to use the createAccount method to try to create an account using given user inputs
    	createAccButton.setOnAction(createAccEvent -> createAccount(mainScene, firstNameTextField, errorFirstName, lastNameTextField, errorLastName, passwordTextField, errorPassword, ageTextField, errorAge, genderChoiceBox , errorGender, heightTextField, errorHeight, weightTextField, errorWeight, userWorkoutCheckBox));
    	
    	

    }
    /**
     * error checks every single parameter 
     * @param mainScene the home-page scene of the application
     * @param firstNameTextField the first name of the user
     * @param errorFirstName to indicate if there is any error in any user input for the first name
     * @param lastNameTextField the last name of the user
     * @param errorLastName to indicate if there is any error in any user input for the last name
     * @param passwordTextField the login password of the user
     * @param errorPassword to indicate if there is any error in any user input for the password
     * @param ageTextField the age of the user
     * @param errorAge indicates if there is any error in the age input
     * @param genderChoiceBox the gender of the user whether the user is a male or female
     * @param errorGender indicated if there is any error in gender
     * @param heightTextField the height of the user
     * @param errorHeight indicate if there is any error in the height of the user
     * @param weightTextField the weight of the user
     * @param errorWeight checks if there is any error in  the weight
     * @param userWorkoutCheckBox does an error check for the users with workout routine and no workout routine
     */
    
    void createAccount(Scene mainScene, TextField firstNameTextField, Label errorFirstName, TextField lastNameTextField , Label errorLastName, TextField passwordTextField , Label errorPassword,TextField ageTextField , Label errorAge, ChoiceBox<String> genderChoiceBox , Label errorGender, TextField heightTextField, Label errorHeight, TextField weightTextField, Label errorWeight,CheckBox userWorkoutCheckBox) {
    	boolean errorInCreateAcc = false; 
    	// we found out about using a hashmap to store references to objects using user input instead of hard coding references from here:
    	// https://stackoverflow.com/questions/22915233/how-to-change-the-name-of-a-object-using-user-input/22915480#22915480
    	// remove and put methods for hashmaps were found from the documentation for the class:
    	// https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
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
        		listNames.add(firstNameTextField.getText() + " " + lastNameTextField.getText());
        		// we found out about setting the options for a choicebox using an ArrayList in the form of an observableArrayList from here:
        		// https://stackoverflow.com/questions/26195243/creating-an-observable-list-collection
        		selectUserChoiceBox.setItems(FXCollections.observableArrayList(listNames));
        		setWorkoutScene(mainScene, newUser);
        	}
        	else {
        		
        		memberMap.remove(firstNameTextField.getText() + " " + lastNameTextField.getText());
        	}
    	}
    	
    	
    	
    }
    /**
     * gets the scene where the user inputs what type of workout and for how many hours they want to do it
     * @param mainScene the home-page scene of the application
     * @param currentUser the user whose data is being manipulated
     */
    

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
    
    /**
     * Uses the UserWorkout class and the Day class and creates a personalized workout routine for the specified user
     * using information input by the user
     * @param mainScene the home-page scene of the application
     * @param currentUser the user for whom the routine is being created
     * @param sundayWorkoutChoiceBox choicebox to select type of workout dedicated for sundays
     * @param sundayHours text field to enter hours dedicated to the selected workout on sundays
     * @param mondayWorkoutChoiceBox choicebox to select type of workout dedicated for mondays
     * @param mondayHours text field to enter hours dedicated to the selected workout on mondays
     * @param tuesdayWorkoutChoiceBox choicebox to select type of workout dedicated for tuesdays
     * @param tuesdayHours text field to enter hours dedicated to the selected workout on tuesdays
     * @param wednesdayWorkoutChoiceBox choicebox to select type of workout dedicated for wednesdays
     * @param wednesdayHours text field to enter hours dedicated to the selected workout on wednesdays
     * @param thursdayWorkoutChoiceBox choicebox to select type of workout dedicated for thursdays
     * @param thursdayHours text field to enter hours dedicated to the selected workout on thursdays
     * @param fridayWorkoutChoiceBox choicebox to select type of workout dedicated for fridays
     * @param fridayHours text field to enter hours dedicated to the selected workout on fridays
     * @param saturdayWorkoutChoiceBox choicebox to select type of workout dedicated for saturdays
     * @param saturdayHours text field to enter hours dedicated to the selected workout on saturdays
     * @param errorRoutine label which changes to indicate if there is an error in any of the user input
     */
    void createRoutine(Scene mainScene, UserWorkout currentUser,ChoiceBox<String>  sundayWorkoutChoiceBox, TextField sundayHours, ChoiceBox<String>  mondayWorkoutChoiceBox, TextField mondayHours, ChoiceBox<String> tuesdayWorkoutChoiceBox, TextField tuesdayHours, ChoiceBox<String> wednesdayWorkoutChoiceBox, TextField wednesdayHours, ChoiceBox<String> thursdayWorkoutChoiceBox, TextField thursdayHours, ChoiceBox<String> fridayWorkoutChoiceBox, TextField fridayHours, ChoiceBox<String> saturdayWorkoutChoiceBox, TextField saturdayHours, Label errorRoutine) {
    	
    	// create a boolean to keep track of error in any input
    	boolean errorInRoutine = false;
    	
    	// attempt to set a workout routine for each day for the user using method in the UserWorkout class
    	currentUser.setSunday(new Day(sundayWorkoutChoiceBox.getValue(), sundayHours.getText(), "Sunday"));
    	currentUser.setMonday(new Day(mondayWorkoutChoiceBox.getValue(), mondayHours.getText(), "Monday"));
    	currentUser.setTuesday(new Day(tuesdayWorkoutChoiceBox.getValue(), tuesdayHours.getText(), "Tuesday"));
    	currentUser.setWednesday(new Day(wednesdayWorkoutChoiceBox.getValue(), wednesdayHours.getText(), "Wednesday"));
    	currentUser.setThursday(new Day(thursdayWorkoutChoiceBox.getValue(), thursdayHours.getText(), "Thursday"));
    	currentUser.setFriday(new Day(fridayWorkoutChoiceBox.getValue(), fridayHours.getText(), "Friday"));
    	currentUser.setSaturday(new Day(saturdayWorkoutChoiceBox.getValue(), saturdayHours.getText(), "Saturday"));
    	
    	// if any of the attributes are the default value in the UserWorkout class, that means there is an error in the input
    	// change boolean to true and set the label to reflect the error
    	if(currentUser.getSunday().getHours() == -1 || currentUser.getMonday().getHours() == -1 || currentUser.getTuesday().getHours() == -1 || currentUser.getWednesday().getHours() == -1 || currentUser.getThursday().getHours() == -1 || currentUser.getFriday().getHours() == -1 || currentUser.getSaturday().getHours() == -1 || currentUser.getSunday().getWorkoutType() == null || currentUser.getMonday().getWorkoutType() == null || currentUser.getTuesday().getWorkoutType() == null || currentUser.getWednesday().getWorkoutType() == null || currentUser.getThursday().getWorkoutType() == null || currentUser.getFriday().getWorkoutType() == null || currentUser.getSaturday().getWorkoutType() == null) {
    		errorInRoutine = true;
    		errorRoutine.setText("Enter valid number input for hours between 0 to 24");
    	}
    
    	/* if no error in input, create a new ArrayList of Days to add the workout routine to and set the Days instance for the
    	user to this list */
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
	    	// return to main scene upon successful creation of routine
	    	applicationStage.setScene(mainScene);
    	}
    }

}

