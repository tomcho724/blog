package base;

import java.util.Date;

public class Post {
	private Date _date;
	private String _content;
	
	public Post(Date date, String content){
		_date = date;
		_content = content;		
	}
	
	public String getContent(){
		return _content;
	}
	
	public void setContent(String content){
		_content = content;
	}
	
	public Date getDate(){
		return _date;
	}
	
	public void setDate(Date date){
		_date = date;
	}
	
	public String toString(){
		return (_date.toString() + "\n" + _content);
	}
	
	public boolean equals(Object o){
		o.getClass();
		Post post = (Post) o;
		return(this.getDate() == post.getDate() && this.getContent() == post.getContent());
	}
	
	public int hashCode(){
		int hashcode = 0;
		return hashcode;
	}
	
	public boolean contains(String keyword){
		String[] temp = _content.split(" ");
		for (int i=0; i<temp.length; i++){
			if (temp[i].equals(keyword)){
				return true;
			}
		}		
		return false;
	}

}
