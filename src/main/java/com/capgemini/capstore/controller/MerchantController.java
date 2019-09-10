package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.Order;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Stock;
import com.capgemini.capstore.service.IMerchantService;

@RestController
@RequestMapping("/merchant")
@CrossOrigin(origins = "http://localhost:4200")
public class MerchantController {
	
	
	@Autowired
	private IMerchantService merchantService;
	
	 @PostMapping(value = "/product/add/{quantity}")
	 public Product addProduct(@RequestBody final Product product,@PathVariable final int quantity)  {
		 
		 return merchantService.addProduct(product,quantity);
		 
	 }
	 
	 @GetMapping(value = "/product/getProductsByMerchantId/{merchantId}")
	 public List<Stock> getProductsByMerchant(@PathVariable final long merchantId) {
		 return merchantService.getProductsByMerchantId(merchantId);
	 }
	 
	 @PutMapping(value = "/product/addDiscount")
	 public Product updateDiscount(@RequestBody final Product product) {
		 return merchantService.updateDiscount(product);
	 }
	 
	 @DeleteMapping(value = "/product/deleteProduct/productId/{productId}")
	 public boolean deleteProduct(@PathVariable final long productId) {
		 return merchantService.removeProduct(productId);
	 }
	 
	 @PutMapping(value = "/product/deleteProductQuantity/{productId}/{quantity}")
	 public Product deleteProductQuantity(@PathVariable final long productId,@PathVariable final int quantity) {
		 return merchantService.deleteProductQuantity(quantity,productId);
	 }
	 
	 @PutMapping(value = "/product/addProductQuantity/{productId}/{quantity}")
	 public Product addProductQuantity(@PathVariable final long productId,@PathVariable final int quantity) {
		 return merchantService.addProductQuantity(quantity,productId);
	 }
	 
	 @GetMapping(value = "/product/getMerchantFeedback/{merchantId}")
	 public List<MerchantFeedback> getMerchantFeedback(@PathVariable final long merchantId) {
		 return merchantService.getMerchantFeedback(merchantId);
	 }
	 
	 @PutMapping(value = "/product/sendMerchantFeedback")
	 public MerchantFeedback sendMerchantFeedback(@RequestBody final MerchantFeedback merchantFeedback) {
		 return merchantService.sendMerchantFeedback(merchantFeedback);
	 }
	 
	 @GetMapping(value = "/order/getAllOrders/{merchantId}")
	 public List<Order> getAllOrders(@PathVariable final long merchantId){
		 return merchantService.displayAllOrders(merchantId);
	 }
	 
	 @GetMapping(value = "/product/searchProducts/{merchantId}/{productName}")
     public List<Stock> searchProducts(@PathVariable final long merchantId,@PathVariable final String productName){
         //String gender = category.getCategoryGender();
//         String categoryType = category.getCategoryType();
         return merchantService.searchProducts(merchantId, productName);
        
     }
	 
	 @GetMapping(value = "/product/categories")
	 public List<Category> getCategories(){
		 return merchantService.getCategories();
	 }
	 
//	 @GetMapping(value = "product/searchProducts/{merchantId}")
//	 public List<Product> searchProducts(@RequestBody final Category category,@PathVariable final long merchantId){
//		 String gender = category.getCategoryGender();
//		 String categoryType = category.getCategoryType();
//		 return merchantService.searchProducts(merchantId, categoryType);
//		 
//	 }
//	 
	 
	 
	

}
