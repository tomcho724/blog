package base;

public class User {
	private int _ID;
	private String _name;
	private String _email;
	
	public User(int ID, String name, String email){
		_ID = ID;
		_name = name;
		_email = email;
	}
	
	public void setID(int ID){
		_ID = ID;
	}
	
	public int getID(){
		return _ID;
	}
	public void setname(String name){
		_name = name;
	}
	
	public String getname(){
		return _name;
	}
	
	public void setemail(String email){
		_email = email;
	}
	
	public String getemail(){
		return _email;
	}	
	

}
