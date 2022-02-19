package com.example.OrderFood.OrderFoodProject.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OrderFood.OrderFoodProject.entities.CategoriesEntity;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoriesEntity, Long> {
	
	@Query(value = "SELECT c.id, c.category_name, c.description FROM categories c ORDER BY c.id ASC", nativeQuery = true)
	public List<CategoriesEntity> findAllCategories();
	
	@Query(value = "SELECT c.id, c.category_name, c.description, it.id, it.item_name, it.description  FROM categories c join items it ON c.id = it.category_id", nativeQuery = true)
	public List<CategoriesEntity> findAllCatId();
}
