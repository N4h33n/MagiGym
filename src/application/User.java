package application;

public class User {
	String firstName;
	String lastName;
	int age;
	String gender;
	double currentWeight;


	public String updateWeight(int weightEntered) {
		String result;
		
		double weightChange = weightEntered - currentWeight;
		currentWeight = weightEntered;
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
}	