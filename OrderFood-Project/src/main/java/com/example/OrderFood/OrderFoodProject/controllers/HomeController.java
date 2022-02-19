package com.example.OrderFood.OrderFoodProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.OrderFood.OrderFoodProject.services.ICategoryService;

@RestController
public class HomeController {
	
	@Autowired
	ICategoryService categoryService;
	
	
	// View and Model
	
	@GetMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("categories_list", categoryService.getAllCategories());
		modelAndView.addObject("cateogries_items_list", categoryService.getItemsByCatId());
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
