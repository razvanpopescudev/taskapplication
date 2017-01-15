package model;

public class TaskType {

	private Integer id;
	private String typeName;
	
	public TaskType(){
		
	}
	
	
	public TaskType(String typeName) {
		this.typeName = typeName;
	}
	public TaskType(Integer id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
