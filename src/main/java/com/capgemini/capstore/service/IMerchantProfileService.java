package com.capgemini.capstore.service;

import com.capgemini.capstore.beans.Merchant;

public interface IMerchantProfileService {

	Merchant updateMerchantProfile(Merchant merchant);

	Merchant createAccount(Merchant merchant);

	Merchant viewMerchantProfile(long merchantId);;

	//Merchant updateAccount(long merchantId, String merchantName);

}
