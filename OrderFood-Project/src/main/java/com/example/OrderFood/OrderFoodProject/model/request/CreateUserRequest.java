package com.example.OrderFood.OrderFoodProject.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

public class CreateUserRequest {
	@NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    @JsonProperty("fullName")
    private String fullname;

    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String telephone;
    
    @NotNull(message = "Avatar is required")
    @NotEmpty(message = "Avatar is required")
    @JsonProperty("avatar")
    private String avatar;
    
	 @NotNull(message = "Username is required")
	 @NotEmpty(message = "Username is required")
	private String username;
    
//    @NotNull(message = "Email is required")
//    @NotEmpty(message = "Email is required")
//    @Email(message = "Please provide a valid email")
//    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 20, message = "Pasword must be between 4 and 20 characters")
    private String password;
    
    
	public CreateUserRequest(String fullname, String telephone, String avatar,String username, String password) {
		this.fullname = fullname;
		this.telephone = telephone;
		this.avatar = avatar;
		this.username = username;
		this.password = password;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
