package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.dao.ProductDao;

@Service
public class MerchantService implements IMerchantService {
	@Autowired
	private ProductDao productDao;

	@Override
	public Product addProduct(Product product) {

//		if(productDao.existsById(product.getProductId())) {
//			Optional<Product> optionalProduct = productDao.findById(product.getProductId());
//			Product existsProduct = optionalProduct.get();
//			existsProduct.setProductQuantity(existsProduct.getProductQuantity() + product.getProductQuantity());
//			productDao.save(existsProduct);
//			return null;
//		}
//		else {
		return productDao.save(product);
		// }

	}

	@Override
	public List<Product> findByMerchantId(long merchantId) {
		
		System.out.println(merchantId);
		
		return productDao.findProductByMerchant(merchantId);
	}
	

}
