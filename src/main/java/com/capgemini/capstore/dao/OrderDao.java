package com.capgemini.capstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

	@Query("FROM Order as o WHERE o.product.merchant =?1")
	List<Order> getOrdersByMerchant(Merchant merchant);

}
