package com.example.OrderFood.OrderFoodProject.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.OrderFood.OrderFoodProject.entities.UsersEntity;
import com.example.OrderFood.OrderFoodProject.model.dto.UserDTO;
import com.example.OrderFood.OrderFoodProject.model.request.CreateUserRequest;
import com.example.OrderFood.OrderFoodProject.model.request.SignInRequest;

public interface IUserService {
	public Optional<UsersEntity> getId(UUID id);
	public UserDTO createUser(CreateUserRequest req);
	public UserDTO getUser(SignInRequest req);
	public UsersEntity getUserByUsername(String username);
	public List<UserDTO> getUsersList();
}
