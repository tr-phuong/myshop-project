package com.example.OrderFood.OrderFoodProject.services.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderFood.OrderFoodProject.entities.CategoriesEntity;
import com.example.OrderFood.OrderFoodProject.entities.ItemsEntity;
import com.example.OrderFood.OrderFoodProject.repositories.ICategoryRepository;
import com.example.OrderFood.OrderFoodProject.repositories.IItemsRepository;
import com.example.OrderFood.OrderFoodProject.services.ICategoryService;

@Service
@Transactional
public class CateogryService implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;
	
	@Autowired
	IItemsRepository itemsRepository;
	
	@Override
	public List<CategoriesEntity> getAllCategories(){
		return categoryRepository.findAllCategories();
	}
	
	@Override
	public List<CategoriesEntity> getItemsByCatId(){
		List<CategoriesEntity> categories_list = categoryRepository.findAllCategories();
		for(CategoriesEntity e : categories_list) {	
			e.setItems(itemsRepository.findItemsByCatId(e.getCategoryId()));
		}
		return categories_list;
	}
	
}
