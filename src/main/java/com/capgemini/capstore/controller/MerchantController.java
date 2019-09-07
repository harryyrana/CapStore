package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.service.IMerchantService;

@RestController
@RequestMapping("/merchant")
//@CrossOrigin(origins = "http://localhost:4200")
public class MerchantController {
	
	
	@Autowired
	private IMerchantService merchantService;
	
	 @PostMapping(value = "/product/add/{quantity}")
	 public Product addProduct(@RequestBody final Product product,@PathVariable final int quantity)  {
		 
		 return merchantService.addProduct(product,quantity);
		 
	 }
	 
	 @GetMapping(value = "/product/findByMerchantId/{merchantId}")
	 public List<Product> findByMerchant(@PathVariable final long merchantId) {
		 return merchantService.findByMerchantId(merchantId);
	 }
	 
	 @PutMapping(value = "/product/addDiscount")
	 public Product updateDiscount(@RequestBody final Product product) {
		 return merchantService.updateDiscount(product);
	 }
	 
	 @DeleteMapping(value = "/product/deleteProduct")
	 public boolean deleteProduct(@RequestBody final Product product) {
		 return merchantService.removeProduct(product);
	 }
	 
	 
	

}
