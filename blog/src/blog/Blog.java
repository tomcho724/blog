package blog;

import java.io.*;
import java.util.*;

import base.*;

public class Blog implements Serializable {
	
	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		this.user = user;
		allPosts = new ArrayList<Post>(); 
	}
	
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
	
	public void setPosts(ArrayList<Post> posts){
		allPosts = posts;
	}
	
	public ArrayList<Post> getPost(){
		return allPosts;
	}
	
	public void setPost(ArrayList<Post> p){
		allPosts = p;
	}
	
	public void post(Post p){
		allPosts.add(p);
		System.out.println("A new Post:\n" + p.toString());
	}
	
	public void list(){
		System.out.println("Current Post:");
		for(int i=0; i<allPosts.size(); i++){
			System.out.println("Post["+ (i+1) +"]" + "\n" + allPosts.get(i).toString());
		}
	}
	
	public void delete(int index){
		if (index>0 && index<allPosts.size()){
			allPosts.remove(index-1);
			}
		else{
			System.out.println("Illegal deletion");
			}
	}
	
	public String toString(){
		return (user.toString() +"\n"+ allPosts.toString());
	}
	
	public boolean equals(Object o){
		o.getClass();
		Blog blog = (Blog) o;
		return(this.getUser() == blog.getUser() && this.allPosts.equals(blog.allPosts));
	}
	
	public int hashCode(){
		return (user.hashCode() + allPosts.hashCode());
	}
	
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		for(Post p:allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			if (postMonth+1 == month && p.contains("@"+someone)){
				System.out.println(p.toString());			
			}			
		}
	}	

	public void save(String filepath){
		try{
			FileOutputStream fs = new FileOutputStream(filepath);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void load(String filepath){
		try{
			FileInputStream is = new FileInputStream(filepath);
			ObjectInputStream os = new ObjectInputStream(is);
			Object o = os.readObject();
			Blog blog = (Blog) o;
			this.setPost(blog.getPost());
			this.setUser(blog.getUser());
			os.close();			
			
		}catch(FileNotFoundException e){
			System.out.println("Wait! There is something wrong. I cannot find the file..");
			}catch(Exception e){
			e.printStackTrace();
			}
		}

}
