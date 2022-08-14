package application;

public class Day  {

	

	private String workoutType;
	private double hours;
	private String day;
	
	
	public Day(String workoutName, String workoutHours, String workoutDay) {
		setWorkoutType(workoutName);
		setHours(workoutHours);
		setDay(workoutDay);
		
		
	}
	
	
	String getWorkoutType() {
		return workoutType;
	}
	
	void setWorkoutType(String workoutType) {
		
		this.workoutType = workoutType;
	}
	
	double getHours() {
		return hours;
	}
	
	void setHours(String hours) {
		this.hours = Double.parseDouble(hours);
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}
	

}
