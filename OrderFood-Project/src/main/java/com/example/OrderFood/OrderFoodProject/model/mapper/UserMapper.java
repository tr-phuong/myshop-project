package com.example.OrderFood.OrderFoodProject.model.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.OrderFood.OrderFoodProject.entities.UsersEntity;
import com.example.OrderFood.OrderFoodProject.model.dto.UserDTO;
import com.example.OrderFood.OrderFoodProject.model.request.CreateUserRequest;

public class UserMapper {
	public static UserDTO toUserDTO(UsersEntity user) {
		UserDTO temp = new UserDTO();
		temp.setId(user.getUserId());
		temp.setFullname(user.getFullname());
		temp.setTelephone(user.getTelephone());
		temp.setAvatar(user.getAvatar());
		temp.setUserName(user.getUsername());
		
		return temp;
	}
    public static UsersEntity toUser(CreateUserRequest req) {
    	UsersEntity user = new UsersEntity();
    	
        user.setFullname(req.getFullname());
        user.setTelephone(req.getTelephone());
        user.setAvatar(req.getAvatar());
        user.setUsername(req.getUsername());
        // Hash password using BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash = passwordEncoder.encode(req.getPassword());
//        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);

        return user;
    }
}
