package com.capgemini.capstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.product.merchant.merchantId =?1")
	List<Order> getOrdersByMerchant(long merchantId);

}
