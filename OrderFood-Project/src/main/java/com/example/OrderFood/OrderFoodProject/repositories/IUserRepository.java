package com.example.OrderFood.OrderFoodProject.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.OrderFood.OrderFoodProject.entities.UsersEntity;

public interface IUserRepository extends JpaRepository<UsersEntity, UUID> {
	public Optional<UsersEntity> findById(UUID id);
	
	@Query(value = "SELECT u.id, u.username, u.password, u.fullname, u.telephone, u.avatar FROM users u WHERE u.username = :username", nativeQuery = true)
	public UsersEntity findByUsername(@Param("username")String username);
}
