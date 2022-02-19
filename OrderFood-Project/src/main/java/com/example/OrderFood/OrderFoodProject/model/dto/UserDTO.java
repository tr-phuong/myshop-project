package com.example.OrderFood.OrderFoodProject.model.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class UserDTO {
	private UUID id;
	private String fullname;
	private String telephone;
	private String avatar;
	private String userName;
	private Collection<RoleDTO> roles = new ArrayList<RoleDTO>();
	
	public UserDTO() {
		
	}

	public UserDTO(UUID id, String fullname, String telephone, String avatar, String userName, Collection<RoleDTO> roles) {
		this.id = id;
		this.fullname = fullname;
		this.telephone = telephone;
		this.avatar = avatar;
		this.userName = userName;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Collection<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleDTO> roles) {
		this.roles = roles;
	}
}
