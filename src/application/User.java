package application;

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
 
  public String updateWeight(String weightEntered) {
		String result;
		try {
			Double updatedWeight = Double.parseDouble(weightEntered);
		
		
		double weightChange = updatedWeight - getCurrentWeight();
		setCurrentWeight(weightEntered);
		if (weightChange > 0) {
			result = ("Your current weight is " + getCurrentWeight() + " kg. You gainded " + weightChange + " kg"); 
		}
		else if (weightChange < 0) {
			result = ("Your current weight is " + getCurrentWeight() + " kg. You lost " + Math.abs(weightChange) + " kg");
		}
		else {
			result = ("Your current weight is " + getCurrentWeight() + " kg. Your weight has not changed!");
		}
		return result;
		}
		catch(NumberFormatException e) {
			return null;
		}
	
}
  

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	boolean errorFirst = false;
	for(int i = 0; i < firstName.length(); i++) {
		if(!Character.isLetter(firstName.charAt(i))) {
			errorFirst = true;
		}
	}
	if(!errorFirst) {
	this.firstName = firstName;}
}

public String getLastName() {
	return lastName;
}

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

public int getAge() {
	
	return age;
}

public void setAge(String age) {
	try {
		int ageAsInt = Integer.parseInt(age);
		if(ageAsInt >= 18) {
			this.age = ageAsInt;
		}
		else {this.age = -1;}
	}
	catch(NumberFormatException e) {
		
	}
	
	
	
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public double getCurrentWeight() {
	return currentWeight;
}

public void setCurrentWeight(String currentWeight) {
	try {
		this.currentWeight = Double.parseDouble(currentWeight);
	
	}
	catch(NumberFormatException e) {
		
	}
	
}

public String getPassword() {
	
	return password;

}

public void setPassword(String password) {
	
	if (password.length() >= 6 && password.length() <= 10 ) {
		this.password = password;
	}
	
}

double getHeight() {
	return height;
}

void setHeight(String height) {
	try {
		this.height = Double.parseDouble(height);
	
	}
	catch(NumberFormatException e) {
		
	}
}

public double getBmi() {
	return bmi;
}

public String setBmi() {
	bmi = getCurrentWeight()/Math.pow(getHeight(), 2);
	String x = "";
	if (bmi < 18.5) {
		x =  String.format("Your BMI is %.2f . You are underweight", bmi);; // if 1 then underweight 
	}
	if ((bmi >=  18.5)&&(bmi<=24.9)) {
		x =  String.format("Your BMI is %.2f . You are healthy", bmi);; // if 2 then normal
	}
	if ((bmi >=  25.0)&&(bmi<=29.9)) {
		x =  String.format("Your BMI is %.2f . You are overweight", bmi);; // if 3 then overweight
	}
	if (bmi >= 30.0) {
		//x = "Your BMI is " + bmi + "You are Obese"; // if 4 then obese
		x = String.format("Your BMI is %.2f . You are Obese", bmi);
	}
	return x;
	
}

boolean isIncludeWorkout() {
	return includeWorkout;
}

void setIncludeWorkout(boolean includeWorkout) {
	
	this.includeWorkout = includeWorkout;
}	
}

