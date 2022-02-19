package com.example.OrderFood.OrderFoodProject.services;

import java.util.List;

import com.example.OrderFood.OrderFoodProject.entities.CategoriesEntity;

public interface ICategoryService {
	public List<CategoriesEntity> getAllCategories();
	public List<CategoriesEntity> getItemsByCatId();
}
