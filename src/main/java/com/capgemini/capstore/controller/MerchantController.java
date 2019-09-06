package com.capgemini.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.service.IMerchantService;

@RestController
@RequestMapping("/merchant")
//@CrossOrigin(origins = "http://localhost:4200")
public class MerchantController {
	
	
	@Autowired
	private IMerchantService merchantService;
	
	 @PostMapping(value = "/product/add")
	 public Product addProduct(@RequestBody final Product product)  {
		 
		 return merchantService.addProduct(product);
		 
	 }
	

}
