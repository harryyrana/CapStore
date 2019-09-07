package com.capgemini.capstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.MerchantFeedback;

public interface MerchantFeedbackDao extends JpaRepository<MerchantFeedback, Long> {


	@Query("SELECT m FROM MerchantFeedback m WHERE m.merchant.merchantId = ?1 and m.status = 1")
	List<MerchantFeedback> findMerchantFeedbackByMerchantId(long merchantId);
	
	
	
}
