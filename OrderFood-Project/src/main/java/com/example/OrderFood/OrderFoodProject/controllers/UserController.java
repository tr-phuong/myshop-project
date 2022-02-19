package com.example.OrderFood.OrderFoodProject.controllers;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.lang.RuntimeException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.OrderFood.OrderFoodProject.entities.RolesEntity;
import com.example.OrderFood.OrderFoodProject.entities.UsersEntity;
import com.example.OrderFood.OrderFoodProject.model.dto.UserDTO;
import com.example.OrderFood.OrderFoodProject.model.request.CreateUserRequest;
import com.example.OrderFood.OrderFoodProject.model.request.SignInRequest;
import com.example.OrderFood.OrderFoodProject.services.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	// API
	@GetMapping("/find")
	@ResponseBody
	public ResponseEntity<?> findUser(@RequestParam UUID id){
		return ResponseEntity.ok(userService.getId(id));
	}
	
	@GetMapping("user/hello")
	public ResponseEntity<?> hello(@Valid @RequestBody CreateUserRequest req){
		System.out.println(req.getFullname());
		System.out.println(req.getUsername());
		System.out.println(req.getAvatar());
		System.out.println(req.getTelephone());
		System.out.println(req.getPassword());
		
		return ResponseEntity.ok("Hello world");
	}
	@GetMapping("/users")
	public ResponseEntity<?> getUsersList(){
		return ResponseEntity.ok(userService.getUsersList());
	}
	
	@PostMapping("user/sign-in")
	public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest req){
		UserDTO user = userService.getUser(req);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("user/sign-up")
	public ResponseEntity<?> signUp(@Valid @RequestBody CreateUserRequest req) {
		UserDTO userDto = userService.createUser(req);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refreshToken = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refreshToken);
				String username = decodedJWT.getSubject();
				UsersEntity user = userService.getUserByUsername(username);
				String accessToken = JWT.create()
						.withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
						.withIssuer(request.getRequestURI().toString())
						.withClaim("roles", user.getRoles().stream().map(RolesEntity::getName).collect(Collectors.toList()))
						.sign(algorithm);
				Map<String, String> tokens = new HashMap<>();
				tokens.put("accessToken", accessToken);
				tokens.put("refreshToken", refreshToken);
				response.setContentType(APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				response.setHeader("error", e.getMessage());
				response.setStatus(FORBIDDEN.value());
				Map<String, String> error = new HashMap<>();
				error.put("errorMessage", e.getMessage());
				response.setContentType(APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}
		}
		else {
			throw new RuntimeException("Refresh token is missing");
		}
	}
	
	
	// Model and view
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("authentication/login");
	}
}
