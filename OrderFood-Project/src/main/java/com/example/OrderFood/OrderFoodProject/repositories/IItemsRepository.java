package com.example.OrderFood.OrderFoodProject.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OrderFood.OrderFoodProject.entities.ItemsEntity;

@Repository
public interface IItemsRepository extends JpaRepository<ItemsEntity, Long>{
	
	@Query(value = "SELECT it.id, it.item_name, it.description, it.category_id FROM items it WHERE it.category_id = :idx", nativeQuery = true)
	public Set<ItemsEntity> findItemsByCatId(@Param("idx") long idx);
}
