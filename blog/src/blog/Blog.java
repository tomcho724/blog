package blog;

import java.util.*;

import base.*;

public class Blog {
	
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

}
