package com.capgemini.capstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Product;



@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

//	@Query('SELECT p FROM Product p where p.merchant.merchantId = ?1')
//	Product findByMerchantId(long merchantId);
	
	@Query("SELECT p FROM Product p WHERE p.merchant.merchantId = ?1")
	List<Product> findProductByMerchant(long merchantId);
	
//	@Query("SELECT p FROM Product p WHERE p.merchant.merchantId = ?1 and p.category.categoryType = ?2")
//	List<Product> searchProduct(long merchantId,String categoryType);
//	
	@Query("SELECT p FROM Product p WHERE p.merchant.merchantId = ?1 and p.productName like %?2%")
    List<Product> searchProduct(long merchantId,String productName);
	

}
