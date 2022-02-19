package com.example.OrderFood.OrderFoodProject.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long itemId;
	
	@Column(name = "item_name",nullable = false)
	private String itemName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CategoriesEntity category;
	
	@Column(nullable = false)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
	private Set<ProductsEntity> products;

	public ItemsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsEntity(long itemId, String itemName, CategoriesEntity category, String description,
			Set<ProductsEntity> products) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.description = description;
		this.products = products;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public CategoriesEntity getCategory() {
		return category;
	}

	public void setCategory(CategoriesEntity category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsEntity> products) {
		this.products = products;
	}
	
}
