package application;

public class Day  {
	

	

	private String workoutType;
	private double hours = -1;
	private String day;
	/**
	 * creates a day object using values given for each of the attribute
	 * @param workoutName String which tells us about which workout type 
	 * @param workoutHours String which tells us how many hours a user wishes to workout
	 * @param workoutDay String which represents the day of the week
	 */
	
	
	public Day(String workoutName, String workoutHours, String workoutDay) {
		setWorkoutType(workoutName);
		setHours(workoutHours);
		setDay(workoutDay);
		
		
	}
	/**
	 * a getter to return the workout type  
	 * @return the workout type as string
	 */
	
	
	String getWorkoutType() {
		return workoutType;
	}
	/**
	 * set workout type as the given argument.
	 * @param workoutType String is used to set workout type of user
	 */
	
	void setWorkoutType(String workoutType) {
		
		this.workoutType = workoutType;
	}
	/**
	 * a getter to return the hours of workout a user wants to do
	 * @return hours as double
	 */
	
	double getHours() {
		return hours;
	}
	/**
	 * set hours of the argument after doing some error checking 
	 * @param hours String to be used to convert and set hours of user as a double
	 */
	
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
	/**
	 * a getter to return the day of the week the user wants to workout
	 * @return day as string
	 */


	public String getDay() {
		return day;
	}
	/**
	 * set day 
	 * @param day string to set the day of the workout 
	 */


	public void setDay(String day) {
		this.day = day;
	}
	

}
