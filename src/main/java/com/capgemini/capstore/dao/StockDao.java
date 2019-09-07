package com.capgemini.capstore.dao;

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
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Stock s SET s.totalQuantity = s.totalQuantity - ?1 WHERE s.product.productId = ?2")
	void deleteQuantityByProductId(int quantity,long productId);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Stock s SET s.totalQuantity = s.totalQuantity + ?1 WHERE s.product.productId = ?2")
	void addQuantityByProductId(int quantity,long productId);

}
