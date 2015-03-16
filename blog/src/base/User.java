package base;

import java.io.*;

public class User implements Comparable<User>,Serializable {
	private int ID;
	private String name;
	private String email;
	
	public User(int ID, String name, String email){
		this.ID = ID;
		this.name = name;
		this.email = email;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
	public void setUserName(String name){
		this.name = name;
	}
	
	public String getUserName(){
		return name;
	}
	
	public void setemail(String email){
		this.email = email;
	}
	
	public String getemail(){
		return email;
	}	
	
	public int compareTo(User u){
		if (this.getID() > u.getID()){
			return 1;
			}
		else if (this.getID() < u.getID()){
			return -1;
			}
		else {
			return 0;
			}
	}
	
	public String toString(){
		return("User [userId=" + this.ID +", userName=" + this.name + ", userEmail=" + this.email + "]");
	}

}
