package com.capgemini.capstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Stock;
import com.capgemini.capstore.dao.MerchantFeedbackDao;
import com.capgemini.capstore.dao.ProductDao;
import com.capgemini.capstore.dao.StockDao;

@Service
public class MerchantService implements IMerchantService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private MerchantFeedbackDao merchantFeedbackDao;

	@Override
	public Product addProduct(Product product,int quantity) {


		Product returnProductData =  productDao.save(product);
		long productId = product.getProductId();
		Optional<Product> optionalProduct = productDao.findById(productId);
		Product currentProduct = optionalProduct.get();
		
		Stock currentProductStock = new Stock();
		currentProductStock.setProduct(currentProduct);
		currentProductStock.setTotalQuantity(quantity);
		currentProductStock.setAvailable(1);
		stockDao.save(currentProductStock);
	
		return returnProductData;
		

	}

	@Override
	public List<Product> findByMerchantId(long merchantId) {
		
		System.out.println(merchantId);
		
		return productDao.findProductByMerchant(merchantId);
	}

	@Override
	public Product updateDiscount(Product product) {
		if(!productDao.existsById(product.getProductId())) {
			return null;
		}
		Optional<Product> optionalProduct =  productDao.findById(product.getProductId());
		Product currentProduct = optionalProduct.get();
		currentProduct.setProductDiscount(product.getProductDiscount());

		return productDao.save(currentProduct);
	}

	@Override
	public boolean removeProduct(Product product) {
		if(!productDao.existsById(product.getProductId())) {
			return false;
		}
		
		productDao.deleteById(product.getProductId());
		
		return true;
	}

	@Override
	public boolean deleteProductQuantity(int quantity,long productId) {

		stockDao.deleteQuantityByProductId(quantity,productId);
		
		return true;
	}

	@Override
	public boolean addProductQuantity(int quantity, long productId) {
		
		stockDao.addQuantityByProductId(quantity,productId);
		
		return true;
	}

	@Override
	public List<MerchantFeedback> getMerchantFeedback(long merchantId) {
		return merchantFeedbackDao.findMerchantFeedbackByMerchantId(merchantId);
	}

	@Override
	public MerchantFeedback sendMerchantFeedback(MerchantFeedback merchantFeedback) {
		
		Optional<MerchantFeedback> optionalMerchantFeedback = merchantFeedbackDao.findById(merchantFeedback.getId());
		
		MerchantFeedback merchantFeedbackObj = optionalMerchantFeedback.get();
		merchantFeedbackObj.setResponse(merchantFeedback.getResponse());
		merchantFeedbackObj.setStatus(merchantFeedback.getStatus());
		
		
		return merchantFeedbackDao.save(merchantFeedbackObj);
	}
	
	
	

}
