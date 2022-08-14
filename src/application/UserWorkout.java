package application;

import java.util.ArrayList;

public class UserWorkout extends User {

	public UserWorkout(String memberFirst, String memberLast, String memberAge, String memberGender, String height,
			String memberCurrentWeight, String memberPassword) {
		super(memberFirst, memberLast, memberAge, memberGender, height, memberCurrentWeight, memberPassword);
		
	}
	
	
	
	private ArrayList<Day> day;
	
	ArrayList<Day> getDay() {
		return day;
		
	
	}
	void setDay(ArrayList<Day> day) {
		this.day = day;
	}
	
	
	
	
	

}
