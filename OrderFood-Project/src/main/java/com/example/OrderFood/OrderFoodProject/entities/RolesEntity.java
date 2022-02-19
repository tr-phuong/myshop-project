package com.example.OrderFood.OrderFoodProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;


@Entity
@Table(name = "roles")
public class RolesEntity {
	
	@Id
	@GeneratedValue(generator = "int", strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(20)")
	private String name;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(20)")
	private String key;
	
	public RolesEntity() {}

	public RolesEntity(long id, String name, String key) {
		super();
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