package com.capgemini.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.capgemini.capstore.beans.Merchant;

public interface MerchantDao extends JpaRepository<Merchant, Long> {

	@Query("from Merchant where merchantId=?1")
	Merchant findByMerchantId(long merchantId);
	
}
