package com.example.OrderFood.OrderFoodProject.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderFood.OrderFoodProject.entities.CartItemEntity;
import com.example.OrderFood.OrderFoodProject.repositories.IShoppingCartRepository;
import com.example.OrderFood.OrderFoodProject.services.IShoppingCartService;

@Service
@Transactional
public class ShoppingCartService implements IShoppingCartService{
	@Autowired
	IShoppingCartRepository shoppingCartRepository;
	
//	@Override
//	public List<CartItemEntity> getCartItem(long id){
//		
//	}
}
