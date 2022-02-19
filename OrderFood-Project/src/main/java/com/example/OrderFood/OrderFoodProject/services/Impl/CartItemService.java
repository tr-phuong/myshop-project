package com.example.OrderFood.OrderFoodProject.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderFood.OrderFoodProject.entities.CartItemEntity;
import com.example.OrderFood.OrderFoodProject.repositories.ICartItemRepository;
import com.example.OrderFood.OrderFoodProject.services.ICartItemService;

@Service @Transactional
public class CartItemService implements ICartItemService{
	@Autowired
	ICartItemRepository cartItemRepository;
	
	@Override
	public List<CartItemEntity> getCartItemByShoppingCartId(long id) {
		return cartItemRepository.findCartItemByShoppingCartId(id);
	}
}
