package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.beans.Product;

public interface IMerchantService {
	
	Product addProduct(Product product);
	List<Product> findByMerchantId(long merchantId);

}
