package application;

public class User {
	private String firstName = null;
	private String lastName = null;
	private int age = -1;
	private String gender = null;
	private double currentWeight = -1;
	private String password = null;
	
	public User(String memberFirst, String memberLast, String memberAge, String memberGender, String memberCurrentWeight, String memberPassword) {
		setFirstName(memberFirst);
		setLastName(memberLast);
		setAge(memberAge);
		setGender(memberGender);
		setCurrentWeight(memberCurrentWeight);
		setPassword(memberPassword);
		
	}	
 
  public String updateWeight(String weightEntered) {
		String result;
		try {
			Double updatedWeight = Double.parseDouble(weightEntered);
		
		
		double weightChange = updatedWeight - getCurrentWeight();
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
}

