package com.example.OrderFood.OrderFoodProject.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.OrderFood.OrderFoodProject.entities.ProductsEntity;

public interface IProductService {
	public ProductsEntity getProductName(String name);
	public Optional<ProductsEntity> getId(UUID id);
	
	public ProductsEntity getName(String name);
	
	public List<ProductsEntity> getAllProducts(long itemId);
}
