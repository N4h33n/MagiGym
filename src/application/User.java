package application;

/**
 * 
 * @author Naheen Kabir, Raisa Fairuz, Tahamina Mostafa Chowdhury
 *
 */
public class User {
	private String firstName = null;
	private String lastName = null;
	private int age = -1;
	private String gender = null;
	private double height = -1;
	private double currentWeight = -1;
	private String password = null;
	private double bmi;
	private boolean includeWorkout;
	
	/**
	 * Creates a user object using values given for each of the attribute
	 * @param memberFirst String which represents first name
	 * @param memberLast String which represents last name
	 * @param memberPassword String which represents password associated with the user
	 * @param memberAge String representing age, which we will try to parse as double
	 * @param memberGender String representing gender
	 * @param height String representing height, which we will try to parse as double
	 * @param memberCurrentWeight String representing weight, which we will try to parse as double
	 * @param includeWorkout boolean to store whether the user wants to include a workout routine
	 */
	public User(String memberFirst, String memberLast, String memberPassword, String memberAge, String memberGender, String height, String memberCurrentWeight, Boolean includeWorkout) {
		setFirstName(memberFirst);
		setLastName(memberLast);
		setAge(memberAge);
		setGender(memberGender);
		setHeight(height);
		setCurrentWeight(memberCurrentWeight);
		setPassword(memberPassword);
		setIncludeWorkout(includeWorkout);
		
	}	
 /**
  * Updates weight of the user to the given value as string after it has been parsed to a double if no error in the given value
  *  if error, then keeps previous value and returns error message. else, prints update about the user's weight
  * @param weightEntered updated weight entered by user as a String
  * @return a String representing an error message if any error in the user input else prints data regarding user's weight change
  */
  public String updateWeight(String weightEntered) {
	  // initialize a string which will store an error message if error in given value or print data regarding the user's weight change if no error
		String result;
		// try to parse given value to a double
		try {
			Double updatedWeight = Double.parseDouble(weightEntered);
		
			// calculate change in weight and print messages accordingly if weight lost, gained or same
			double weightChange = updatedWeight - getCurrentWeight();
			// if value entered is negative, return an error message
			if(updatedWeight < 0) {
				return "Please enter a positive value";
			}
			setCurrentWeight(weightEntered);
			if (weightChange > 0) {
				result = ("Your current weight is " + getCurrentWeight() + " kg. You gained " + weightChange + " kg"); 
			}
			else if (weightChange < 0) {
				result = ("Your current weight is " + getCurrentWeight() + " kg. You lost " + Math.abs(weightChange) + " kg");
			}
			else {
				result = ("Your current weight is " + getCurrentWeight() + " kg. Your weight has not changed!");
			}
			return result;
			}
		// if unable to parse value as string, return an error message
		catch(NumberFormatException e) {
			return "Please enter a valid number";
		}
	
}
  

/**
 *a getter to return first name of user
 * @return first name of the user as a string
 */
public String getFirstName() {
	return firstName;
}

/**
 * set first name of user as the given argument after doing some error checking
 * @param firstName String to be used to set as first name
 */
public void setFirstName(String firstName) {
	boolean errorFirst = false;
	// check if any character in given string is not alphabetic
	for(int i = 0; i < firstName.length(); i++) {
		if(!Character.isLetter(firstName.charAt(i))) {
			errorFirst = true;
		}
	}
	if(!errorFirst) {
	this.firstName = firstName;}
}

/**
 *a getter to return last name of user
 * @return last name of the user as a string
 */
public String getLastName() {
	return lastName;
}

/**
 * set last name of user as the given argument after doing some error checking
 * @param lasttName String to be used to set as last name
 */
public void setLastName(String lastName) {
	boolean errorLast = false;
	for(int i = 0; i < lastName.length(); i++) {
		if(!Character.isLetter(lastName.charAt(i))) {
			errorLast = true;
		}
	}
	if(!errorLast) {
	this.lastName = lastName;}
}

/**
 *a getter to return age of user
 * @return first age of the user as int
 */
public int getAge() {
	
	return age;
}

/**
 * set age of user as the given argument after doing some error checking
 * @param age String to be used to convert and set age of user as a int
 */
public void setAge(String age) {
	try {
		int ageAsInt = Integer.parseInt(age);
		if(ageAsInt >= 18) {
			this.age = ageAsInt;
		}
		else {this.age = -2;}
	}
	catch(NumberFormatException e) {
		
	}
	
	
	
}
/**
 *a getter to return gender of user
 * @return first gender of the user as a string
 */

public String getGender() {
	return gender;
}

/**
 * set gender of user as the given argument (no error checking needed since gender is selected from choicebox
 * @param gender String to be used to set gender of user
 */
public void setGender(String gender) {
	this.gender = gender;
}

/**
 *a getter to return weight of user
 * @return weight of the user as a double
 */
public double getCurrentWeight() {
	return currentWeight;
}

/**
 * set weight of user as the given argument after doing some error checking
 * @param currentWeight String to be used to convert and set weight of user as a double
 */
public void setCurrentWeight(String currentWeight) {
	try {
		this.currentWeight = Double.parseDouble(currentWeight);
	
	}
	catch(NumberFormatException e) {
		
	}
	
}
/**
 *a getter to return password of user
 * @return password of the user as a string
 */
public String getPassword() {
	
	return password;

}

/**
 * set password of user as the given argument after doing some error checking
 * @param password String to be used to set password of user
 */
public void setPassword(String password) {
	
	if (password.length() >= 6 && password.length() <= 10 ) {
		this.password = password;
	}
	
}
/**
 *a getter to return height of user
 * @return height of the user as a double
 */

double getHeight() {
	return height;
}

/**
 * set height of user as the given argument after doing some error checking
 * @param height String to be used to convert and set height of user as a double
 */
void setHeight(String height) {
	try {
		this.height = Double.parseDouble(height);
	
	}
	catch(NumberFormatException e) {
		
	}
}

/**
 *a getter to return bmi of user
 * @return first bmi of the user as a double
 */
public double getBmi() {
	return bmi;
}

/**
 * set the bmi of the user using the user's weight and height attributes and return a message displaying the information
 * @return String displaying bmi and health status of user
 */
public String setBmi() {
	// bmi calculations were found from here:
	// https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html
	bmi = getCurrentWeight()/Math.pow(getHeight(), 2);
	String x = "";
	if (bmi < 18.5) {
		x =  String.format("Your BMI is %.2f . You are underweight", bmi);
	}
	if ((bmi >=  18.5)&&(bmi<=24.9)) {
		x =  String.format("Your BMI is %.2f . You are healthy", bmi);
	}
	if ((bmi >=  25.0)&&(bmi<=29.9)) {
		x =  String.format("Your BMI is %.2f . You are overweight", bmi);
	}
	if (bmi >= 30.0) {
		x = String.format("Your BMI is %.2f . You are Obese", bmi);
	}
	return x;
	
}

/**
 *a getter to return whether user wants to include a workout routine
 * @return boolean indicating whether the user will include a workout routine
 */
boolean isIncludeWorkout() {
	return includeWorkout;
}

/**
 * set whether user wants a workout routine or not as a boolean
 * @param includeWorkout boolean showing whether user wants to include a workout routine
 */
void setIncludeWorkout(boolean includeWorkout) {
	
	this.includeWorkout = includeWorkout;
}	
}

