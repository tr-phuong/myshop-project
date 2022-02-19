package com.example.OrderFood.OrderFoodProject.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItemEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private ProductsEntity product;
	
	@ManyToOne
	private ShoppingCartEntity shoppingCart;
	
	public CartItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemEntity(long id, ShoppingCartEntity shoppingCart, ProductsEntity products) {
		super();
		this.id = id;
		this.shoppingCart = shoppingCart;
		this.product = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ShoppingCartEntity getShoppingCart() {
		return shoppingCart;
	}

	public void setUser(ShoppingCartEntity shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ProductsEntity getProducts() {
		return product;
	}

	public void setProducts(ProductsEntity products) {
		this.product = products;
	}
}
