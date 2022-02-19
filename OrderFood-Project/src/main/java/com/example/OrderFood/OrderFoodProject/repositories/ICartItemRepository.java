package com.example.OrderFood.OrderFoodProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OrderFood.OrderFoodProject.entities.CartItemEntity;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItemEntity, Long> {
	
	@Query(value = "SELECT ci.id, ci.product_id, ci.shopping_cart_id FROM cart_item ci WHERE ci.shopping_cart_id = :shoppingCartId", nativeQuery = true)
	public List<CartItemEntity> findCartItemByShoppingCartId(@Param("shoppingCartId") long shoppingCartId);
}
