package application;

import java.util.ArrayList;
/**
 * 
 * @author Naheen Kabir, Raisa Fairuz, Tahamina Mostafa Chowdhury
 *
 */
public class UserWorkout extends User {
	
	private ArrayList<Day> days;
	private Day monday;
	private Day tuesday;
	private Day wednesday;
	private Day thursday;
	private Day friday;
	private Day saturday;
	private Day sunday;

	/**
	 * a constructor for a UserWorkout object, which is a child of the User class but can include a workout routine for each day
	 * @param memberFirst String which represents first name
	 * @param memberLast String which represents last name
	 * @param memberPassword String which represents password associated with the user
	 * @param memberAge String representing age, which we will try to parse as double
	 * @param memberGender String representing gender
	 * @param height String representing height, which we will try to parse as double
	 * @param memberCurrentWeight String representing weight, which we will try to parse as double
	 * @param includeWorkout boolean to store whether the user wants to include a workout routine
	 */
	public UserWorkout(String memberFirst, String memberLast, String memberAge, String memberGender, String height,
			String memberCurrentWeight, String memberPassword, boolean includeWorkout) {
		super(memberFirst, memberLast, memberAge, memberGender, height, memberCurrentWeight, memberPassword, includeWorkout);
		
	}
	
	
	/**
	 * a getter to return the ArrayList of workout routines for each day of the week
	 * @return an ArrayList of Days containing the workout routine for each day of the week
	 */
	ArrayList<Day> getDays() {
		return days;
	}
	/**
	 * set the workout routine of the user in the form of an ArrayList provided as an argument
	 * @param days an ArrayList of days of the week including information about the workout routine for each day
	 */
	void setDays(ArrayList<Day> days) {
		this.days = days;
	}
	/**
	 * get the workout routine for Monday
	 * @return the Day representation of monday's workout routine
	 */
	public Day getMonday() {
		return monday;
	}
	/**
	 * set the workout routine for Monday using the Day class
	 * @param monday Day representation of the workout routine for monday
	 */
	public void setMonday(Day monday) {
		this.monday = monday;
	}
	/**
	 * get the workout routine for Tuesday
	 * @return the Day representation of tuesday's workout routine
	 */
	public Day getTuesday() {
		return tuesday;
	}
	/**
	 * set the workout routine for Tuesday using the Day class
	 * @param tuesday Day representation of the workout routine for tuesday
	 */
	public void setTuesday(Day tuesday) {
		this.tuesday = tuesday;
	}
	/**
	 * get the workout routine for Wednesday
	 * @return the Day representation of wednesday's workout routine
	 */
	public Day getWednesday() {
		return wednesday;
	}
	/**
	 * set the workout routine for Wednesday using the Day class
	 * @param wednesday Day representation of the workout routine for wednesday
	 */
	public void setWednesday(Day wednesday) {
		this.wednesday = wednesday;
	}
	/**
	 * get the workout routine for Thursday
	 * @return the Day representation of thursday's workout routine
	 */
	public Day getThursday() {
		return thursday;
	}
	/**
	 * set the workout routine for Thursday using the Day class
	 * @param thursday Day representation of the workout routine for thursday
	 */
	public void setThursday(Day thursday) {
		this.thursday = thursday;
	}
	/**
	 * get the workout routine for Friday
	 * @return the Day representation of friday's workout routine
	 */
	public Day getFriday() {
		return friday;
	}
	/**
	 * set the workout routine for Friday using the Day class
	 * @param friday Day representation of the workout routine for friday
	 */
	public void setFriday(Day friday) {
		this.friday = friday;
	}
	/**
	 * get the workout routine for Saturday
	 * @return the Day representation of saturday's workout routine
	 */
	public Day getSaturday() {
		return saturday;
	}
	/**
	 * set the workout routine for Saturday using the Day class
	 * @param saturday Day representation of the workout routine for saturday
	 */
	public void setSaturday(Day saturday) {
		this.saturday = saturday;
	}
	/**
	 * get the workout routine for Sunday
	 * @return the Day representation of sunday's workout routine
	 */
	public Day getSunday() {
		return sunday;
	}
	/**
	 * set the workout routine for Sunday using the Day class
	 * @param sunday Day representation of the workout routine for sunday
	 */
	public void setSunday(Day sunday) {
		this.sunday = sunday;
	}
	
	
	
	
	

}
