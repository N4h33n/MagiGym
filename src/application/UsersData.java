package application;

import java.util.ArrayList;

public class UsersData {
	private ArrayList<User> listOfUsers ;
	
	public UsersData(ArrayList<User> userList) {
		listOfUsers = new ArrayList<User>();
	}

	public ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public void addUser(User newUser) {
		listOfUsers.add(newUser);
	}
	
}
