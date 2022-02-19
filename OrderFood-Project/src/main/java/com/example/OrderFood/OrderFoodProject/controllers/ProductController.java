package com.example.OrderFood.OrderFoodProject.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.OrderFood.OrderFoodProject.entities.ProductsEntity;
import com.example.OrderFood.OrderFoodProject.services.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/item")
	@ResponseBody
	public ModelAndView getProducts(@RequestParam("id") long id){
		ModelAndView modelAndView = new ModelAndView("product");
		modelAndView.addObject("product_list", productService.getAllProducts(id));
		return modelAndView;
	}
	
	@GetMapping("/p")
	@ResponseBody
	public ResponseEntity<?> getId(@RequestParam UUID id){
		UUID idString = UUID.fromString("a5cc581c-5f5e-4c49-95b5-00c187bc7d3b");
		productService.getId(id).ifPresent(System.out::println);
		var product = productService.getId(idString);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());			
		}
		return ResponseEntity.ok("ERROR");	
	}
	
	
	// Model and view

	@GetMapping("/detail")
	public ModelAndView detailProduct(@RequestParam("id") UUID id){
		ModelAndView modelAndView = new ModelAndView("product-detail");
		Optional<ProductsEntity> product = productService.getId(id);
		if(product.isPresent()) {
			modelAndView.addObject("product", product.get());			
		}
		else {
			//Error
		}
		return modelAndView;
	}
}
        
