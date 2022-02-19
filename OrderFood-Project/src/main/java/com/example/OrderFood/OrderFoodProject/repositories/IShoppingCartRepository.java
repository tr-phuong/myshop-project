package com.example.OrderFood.OrderFoodProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderFood.OrderFoodProject.entities.ShoppingCartEntity;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long>{

}
