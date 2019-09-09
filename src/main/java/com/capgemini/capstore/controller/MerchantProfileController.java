package com.capgemini.capstore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.service.IMerchantProfileService;


@RestController
@RequestMapping("/merchant")
public class MerchantProfileController {
	
	@Autowired
	IMerchantProfileService merchantService;
	
	@PostMapping(value="/create")
	public Merchant createAccount(@RequestBody Merchant merchant)
	{
		return merchantService.createAccount(merchant);
	}
	
	
	@GetMapping(value="/getMerchantProfile/{merchantId}")
	public Merchant viewById(@PathVariable long merchantId)
	{
		return merchantService.viewMerchantProfile(merchantId);
	}
	
	@PutMapping(value="/updateMerchantProfile")
	public Merchant updateMerchant(@RequestBody Merchant merchant) 
	{
		return merchantService.updateMerchantProfile(merchant);
	}
}
