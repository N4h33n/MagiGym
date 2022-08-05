package application;

public class User {
	String firstName;
	String lastName;
	int age;
	String gender;
	int currentWeight;
	
	public User(String memberFirst, String memberLast, int memberAge, String memberGender, int memberCurrentWeight) {
		firstName = memberFirst;
		lastName = memberLast;
		age = memberAge;
		gender = memberGender;
		currentWeight = memberCurrentWeight;
	}
}
