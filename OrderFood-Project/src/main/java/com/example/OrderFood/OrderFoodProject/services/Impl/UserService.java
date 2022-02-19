package com.example.OrderFood.OrderFoodProject.services.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.OrderFood.OrderFoodProject.entities.UsersEntity;
import com.example.OrderFood.OrderFoodProject.exception.DuplicateRecordException;
import com.example.OrderFood.OrderFoodProject.model.dto.RoleDTO;
import com.example.OrderFood.OrderFoodProject.model.dto.UserDTO;
import com.example.OrderFood.OrderFoodProject.model.mapper.UserMapper;
import com.example.OrderFood.OrderFoodProject.model.request.CreateUserRequest;
import com.example.OrderFood.OrderFoodProject.model.request.SignInRequest;
import com.example.OrderFood.OrderFoodProject.repositories.IUserRepository;
import com.example.OrderFood.OrderFoodProject.services.IUserService;

@Service @Transactional
public class UserService implements IUserService, UserDetailsService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Optional<UsersEntity> getId(UUID id){
		return userRepository.findById(id);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity user = userRepository.findByUsername(username);
		if(user == null) {
			System.out.println("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		}
		else {
			System.out.println("User found in the database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getKey())));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
	
	@Override
	public UserDTO createUser(CreateUserRequest req) {
		UsersEntity existingUser = userRepository.findByUsername(req.getUsername());
		if(existingUser != null) throw new DuplicateRecordException("Username không tồn tại");
		UsersEntity newUser = UserMapper.toUser(req);
		UsersEntity added = userRepository.save(newUser);
		return UserMapper.toUserDTO(added);
	}
	
	@Override
	public UserDTO getUser(SignInRequest req) {
		UsersEntity existingUser = userRepository.findByUsername(req.getUsername());
		if(existingUser == null) throw new DuplicateRecordException("Username không tồn tại.");
		boolean checkPw = BCrypt.checkpw(req.getPassword(), existingUser.getPassword());
		if(!checkPw) throw new DuplicateRecordException("Mật khẩu không đúng");
		return UserMapper.toUserDTO(existingUser);
	}
	
	@Override
	public List<UserDTO> getUsersList() {
		List<UserDTO> usersList = new ArrayList<>();
		List<UsersEntity> users = userRepository.findAll();
		users.forEach(user -> usersList.add(
				new UserDTO(
						user.getUserId(),
						user.getFullname(),
						user.getTelephone(),
						user.getAvatar(),
						user.getUsername(),
						user.getRoles().stream().map(role -> new RoleDTO(
								role.getId(),
								role.getName(),
								role.getKey())).toList()
				)
			)
		);
		return usersList;
	}
	
	@Override
	public UsersEntity getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
