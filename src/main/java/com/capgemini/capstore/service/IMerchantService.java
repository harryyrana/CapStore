package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.Order;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Stock;

public interface IMerchantService {
	
	Product addProduct(Product product,int quantity);
	
	List<Stock> getProductsByMerchantId(long merchantId);
	
	Product updateDiscount(Product product);
	
	boolean removeProduct(long productId);
	
	Product deleteProductQuantity(int quantity,long productId);
	
	Product addProductQuantity(int quantity,long productId);
	
	List<MerchantFeedback> getMerchantFeedback(long merchantId);
	
	MerchantFeedback sendMerchantFeedback(MerchantFeedback merchantFeedback);
	
	List<Order> displayAllOrders(long merchantId);
	
	List<Stock> searchProducts(long merchantId,String categoryType);
	
	List<Category> getCategories();
	
//	boolean updateProductDiscount(double productDiscount,long merchantId,String categoryType);
}
