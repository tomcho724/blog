package base;

import java.util.Date;

public class FriendsPost extends Post{
	private User _user;

	public FriendsPost(Date date, String content, User user) {
		super(date, content);
		_user = user;
	}
	
	public void setUser(User user){
		_user = user;
	}
	
	public User getUser(){
		return _user;
	}
	
	public String toString(){
		return (_user.toString() + "\n" + super.getDate().toString() + "\n" + super.getContent());
	}

}
