package com.example.OrderFood.OrderFoodProject.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.OrderFood.OrderFoodProject.services.ICartItemService;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
	@Autowired
	ICartItemService cartItemService;
	
	//Model and View
	@GetMapping("/cart-item")
	public ModelAndView shoppingCart(@RequestParam("user_id") UUID id) {
		ModelAndView modelAndView = new ModelAndView("shopping-cart");
		System.out.println(id);
		return modelAndView;
	}
}
