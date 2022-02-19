package com.example.OrderFood.OrderFoodProject.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OrderFood.OrderFoodProject.entities.ProductsEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductsEntity, UUID>{
	public ProductsEntity findByName(String name);
	
	public Optional<ProductsEntity> findById(UUID id);
	
	@Query(value = "SELECT p.id, p.name, p.price, p.quantity, p.cat_id, p.sku, p.description FROM products p WHERE p.name = ?1", nativeQuery = true)
	public ProductsEntity findName(String name);
	
	@Query(value = "SELECT p.id, p.name, p.price, p.quantity, p.description, p.poster, p.sku, p.it_id FROM products p WHERE p.it_id = :itemId", nativeQuery = true)
	public List<ProductsEntity> findAllProducts(@Param("itemId") long itemId);
}
