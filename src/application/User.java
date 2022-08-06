package application;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private double currentWeight;
	private String password;
	
	public User(String memberFirst, String memberLast, int memberAge, String memberGender, int memberCurrentWeight, String memberPassword) {
		setFirstName(memberFirst);
		setLastName(memberLast);
		setAge(memberAge);
		setGender(memberGender);
		setCurrentWeight(memberCurrentWeight);
		setPassword(memberPassword);
		
	}	
 
  public String updateWeight(int weightEntered) {
		String result;
		
		double weightChange = weightEntered - getCurrentWeight();
		setCurrentWeight(weightEntered);
		if (weightChange > 0) {
			result = ("You gainded" + weightChange + "kg"); 
		}
		if (weightChange < 0) {
			result = ("You lost" + Math.abs(weightChange) + "kg");
		}
		else {
			result = ("Your weight has not changed!");
		}
		return result;
	
}
  

public String getFirstName() {
	
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

int getAge() {
	
	return age;
}

void setAge(int age) {
	if ( age > 18 && age <100) {
		this.age = age;
	}
	else {
		this.age = 0;
	}
	
}

String getGender() {
	return gender;
}

void setGender(String gender) {
	this.gender = gender;
}

double getCurrentWeight() {
	return currentWeight;
}

void setCurrentWeight(double currentWeight) {
	
	this.currentWeight = currentWeight;
}

public String getPassword() {
	
	return password;

}

public void setPassword(String password) {
	
	if (password.length() >= 6 && password.length() <= 10 ) {
		this.password = password;
	}
	
}	
}

