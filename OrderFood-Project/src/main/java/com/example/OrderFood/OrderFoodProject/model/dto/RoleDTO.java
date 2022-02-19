package com.example.OrderFood.OrderFoodProject.model.dto;

public class RoleDTO {
	private long id;
	private String name;
	private String key;
	
	public RoleDTO() {}
	
	public RoleDTO(long id, String name, String key) {
		this.id = id;
		this.name = name;
		this.key = key;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
