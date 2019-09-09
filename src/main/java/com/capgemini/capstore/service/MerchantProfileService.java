package com.capgemini.capstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.dao.MerchantDao;
import com.capgemini.capstore.exceptions.UnauthorizedException;
import com.capgemini.capstore.exceptions.WrongUserInputException;


@Service
public class MerchantProfileService implements IMerchantProfileService{
		
	@Autowired
	MerchantDao merchantDao;

	@Override
	public Merchant createAccount(Merchant merchant) {
		merchant.setMerchantPassword(merchant.getMerchantPassword());
		merchantDao.save(merchant);
		return merchantDao.findById(merchant.getMerchantId()).get();
	}

	@Override
	public Merchant viewMerchantProfile(long merchantId) {
		
		
		Merchant merchant=  merchantDao.findByMerchantId(merchantId);
		if(merchant == null) {
			throw new UnauthorizedException("Merchant not logged in.");
		}

		return merchant;
	}

	@Override
	public Merchant updateMerchantProfile(Merchant merchant){
		
			Optional<Merchant> optionalMerchant = merchantDao.findById(merchant.getMerchantId());
			if(!optionalMerchant.isPresent()) {
				throw new UnauthorizedException("Merchant not logged in.");
			}
			
			Merchant merchantObj = optionalMerchant.get();
			if(merchantObj.getMerchantName().equals(merchant.getMerchantName())){
				throw new WrongUserInputException("Please enter new user name.");
			}
			if(merchantObj.getMerchantContactNo().equals(merchant.getMerchantContactNo())) {
				throw new WrongUserInputException("Please enter new mobile number.");
			}
			if(merchantObj.getMerchantCompanyName().equals(merchant.getMerchantCompanyName())) {
				throw new WrongUserInputException("Please enter new company name.");
			}
			
			merchantObj.setMerchantName(merchant.getMerchantName());
			merchantObj.setMerchantContactNo(merchant.getMerchantContactNo());
			merchantObj.setMerchantCompanyName(merchant.getMerchantCompanyName());
			
			return merchantDao.save(merchantObj);
		
	}



	
}
