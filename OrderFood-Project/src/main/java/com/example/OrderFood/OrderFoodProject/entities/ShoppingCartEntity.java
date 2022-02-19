package com.example.OrderFood.OrderFoodProject.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private UsersEntity user;
	
	@OneToMany(mappedBy = "shoppingCart")
	private Set<CartItemEntity> cartItem;

	public ShoppingCartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartEntity(long id, UsersEntity user, Set<CartItemEntity> cartItem) {
		super();
		this.id = id;
		this.user = user;
		this.cartItem = cartItem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public Set<CartItemEntity> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItemEntity> cartItem) {
		this.cartItem = cartItem;
	}
}
