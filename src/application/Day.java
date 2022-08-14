package application;

public class Day  {

	

	private String workoutType;
	private double hours;
	
	public Day(String workoutType, String hours) {
		setWorkoutType(workoutType);
		setHours(hours);
		
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
	

}
