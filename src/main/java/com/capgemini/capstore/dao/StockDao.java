package com.capgemini.capstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Stock;

@Repository
@Transactional
public interface StockDao extends JpaRepository<Stock, Long> {
	
	@Query("SELECT s FROM Stock s WHERE s.product.merchant.merchantId = ?1")
	List<Stock> findByMerchantId(long merchantId);
	
	@Query("SELECT s FROM Stock s WHERE s.product.productId = ?1")
	Stock findStockByProductId(long productId);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Stock s SET s.totalQuantity = s.totalQuantity - ?1 WHERE s.product.productId = ?2")
	void deleteQuantityByProductId(int quantity,long productId);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Stock s SET s.totalQuantity = s.totalQuantity + ?1 WHERE s.product.productId = ?2")
	void addQuantityByProductId(int quantity,long productId);
	
	@Query("SELECT s FROM Stock s WHERE s.product.merchant.merchantId = ?1 and s.product.productName like %?2% ")
	List<Stock> searchProducts(long merchantId,String productName);

}
