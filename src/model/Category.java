package model;

public class Category {
	private int id;
	private String name;
	private Integer parent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public Category(int id, String name, Integer parent) {
		
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	public Category() {
		
	}
	
}
