package model;

public class Priority {

	private Integer id;
	private String priorityName;
	
	
	
	public Priority(String priorityName) {
		this.priorityName = priorityName;
	}
	public Priority(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPriorityName() {
		return priorityName;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	
	
	
}
