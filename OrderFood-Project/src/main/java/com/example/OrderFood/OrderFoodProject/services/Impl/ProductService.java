package com.example.OrderFood.OrderFoodProject.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderFood.OrderFoodProject.entities.ProductsEntity;
import com.example.OrderFood.OrderFoodProject.repositories.IProductRepository;
import com.example.OrderFood.OrderFoodProject.services.IProductService;

@Service @Transactional
public class ProductService implements IProductService{

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public ProductsEntity getProductName(String name) {
		return productRepository.findByName(name);
	}
	
	@Override
	public Optional<ProductsEntity> getId(UUID id){
		return productRepository.findById(id);
	}
	
	@Override
	public ProductsEntity getName(String name) {
		return productRepository.findName(name);
	}
	@Override
	public List<ProductsEntity> getAllProducts(long itemId){
		return productRepository.findAllProducts(itemId);
	}
	
//	@Override
//	public ProductsEntity getOne(UUID id) {
//		return productRepository.findById(id)
//		        .orElseThrow(() -> new EntityNotFoundException(id));
//	}
	
//	@Override
//	public ProductsEntity getAllProducts(){
//		return productRepository.findAllProducts();
//	}
}
