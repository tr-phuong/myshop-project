package com.example.OrderFood.OrderFoodProject.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long categoryId;
	
	@Column(name= "category_name", nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<ItemsEntity> items;
	

	public CategoriesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriesEntity(long categoryId, String name, String description, Set<ItemsEntity> items) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.items = items;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ItemsEntity> getItems() {
		return items;
	}

	public void setItems(Set<ItemsEntity> items) {
		this.items = items;
	}
	
	
}
