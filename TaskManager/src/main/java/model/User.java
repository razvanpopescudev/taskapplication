package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Integer id;
	private String email;
	private String password;
	
	private List<Task> userTasks = new ArrayList<>();
	
	public User(Integer id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public User(){
		
	}
	
	
	
	public List<Task> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}
	
	public void addTask(Task taskNou){
		this.userTasks.add(taskNou);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
