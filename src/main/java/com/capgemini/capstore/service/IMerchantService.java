package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.beans.Product;

public interface IMerchantService {
	
	Product addProduct(Product product,int quantity);
	
	List<Product> findByMerchantId(long merchantId);
	
	Product updateDiscount(Product product);
	
	boolean removeProduct(Product product);
	

}
