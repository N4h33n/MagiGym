package application;

public class User {
	private String firstName = null;
	private String lastName = null;
	private int age = -1;
	private String gender = null;
	private double currentWeight = -1;
	private String password = null;
	
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
	boolean errorFirst = false;
	//for(int i = 0; i < firstName.length(); i++) {
		//if(isalpha('a')) {
	//}
	
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
	if ( age > 18 ) {
		this.age = age;
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

