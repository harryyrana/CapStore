package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.Order;
import com.capgemini.capstore.beans.Product;

public interface IMerchantService {
	
	Product addProduct(Product product,int quantity);
	
	List<Product> getProductsByMerchantId(long merchantId);
	
	Product updateDiscount(Product product);
	
	boolean removeProduct(Product product);
	
	boolean deleteProductQuantity(int quantity,long productId);
	
	boolean addProductQuantity(int quantity,long productId);
	
	List<MerchantFeedback> getMerchantFeedback(long merchantId);
	
	MerchantFeedback sendMerchantFeedback(MerchantFeedback merchantFeedback);
	
	List<Order> displayAllOrders(long merchantId);
	
	List<Product> searchProducts(long merchantId,String categoryType);
	

}
