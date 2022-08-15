package application;

import java.util.ArrayList;

public class UserWorkout extends User {
	
	private ArrayList<Day> days;
	private Day monday;
	private Day tuesday;
	private Day wednesday;
	private Day thursday;
	private Day friday;
	private Day saturday;
	private Day sunday;

	public UserWorkout(String memberFirst, String memberLast, String memberAge, String memberGender, String height,
			String memberCurrentWeight, String memberPassword, boolean includeWorkout) {
		super(memberFirst, memberLast, memberAge, memberGender, height, memberCurrentWeight, memberPassword, includeWorkout);
		
	}
	
	

	ArrayList<Day> getDays() {
		return days;
		
	
	}
	void setDays(ArrayList<Day> days) {
		this.days = days;
	}
	public Day getMonday() {
		return monday;
	}
	public void setMonday(Day monday) {
		this.monday = monday;
	}
	public Day getTuesday() {
		return tuesday;
	}
	public void setTuesday(Day tuesday) {
		this.tuesday = tuesday;
	}
	public Day getWednesday() {
		return wednesday;
	}
	public void setWednesday(Day wednesday) {
		this.wednesday = wednesday;
	}
	public Day getThursday() {
		return thursday;
	}
	public void setThursday(Day thursday) {
		this.thursday = thursday;
	}
	public Day getFriday() {
		return friday;
	}
	public void setFriday(Day friday) {
		this.friday = friday;
	}
	public Day getSaturday() {
		return saturday;
	}
	public void setSaturday(Day saturday) {
		this.saturday = saturday;
	}
	public Day getSunday() {
		return sunday;
	}
	public void setSunday(Day sunday) {
		this.sunday = sunday;
	}
	
	
	
	
	

}
