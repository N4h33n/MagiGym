package application;

public class Day  {

	

	private String workoutType;
	private double hours = -1;
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
		try {
			double hoursDouble = Double.parseDouble(hours);
				if(hoursDouble >= 0 && hoursDouble <= 24) {
					this.hours = hoursDouble;
				}
				else {
					this.hours = -1;
				}
		}
		catch(NumberFormatException e) {
			
		}
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}
	

}
