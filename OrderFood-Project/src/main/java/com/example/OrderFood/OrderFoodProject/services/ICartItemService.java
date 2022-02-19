package com.example.OrderFood.OrderFoodProject.services;

import java.util.List;

import com.example.OrderFood.OrderFoodProject.entities.CartItemEntity;

public interface ICartItemService {
	public List<CartItemEntity> getCartItemByShoppingCartId(long id);
}
