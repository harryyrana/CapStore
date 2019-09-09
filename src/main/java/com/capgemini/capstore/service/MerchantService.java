package com.capgemini.capstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.Order;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Stock;
import com.capgemini.capstore.dao.MerchantFeedbackDao;
import com.capgemini.capstore.dao.OrderDao;
import com.capgemini.capstore.dao.ProductDao;
import com.capgemini.capstore.dao.StockDao;
import com.capgemini.capstore.exceptions.ResourceNotFoundException;
import com.capgemini.capstore.exceptions.WrongUserInputException;

@Service
public class MerchantService implements IMerchantService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private MerchantFeedbackDao merchantFeedbackDao;
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Product addProduct(Product product,int quantity) {
		
		if(quantity <= 0) {
			throw new WrongUserInputException("Quantity must be greater than 0.");
		}


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
	public List<Product> getProductsByMerchantId(long merchantId) {
		
		return productDao.findProductByMerchant(merchantId);
	}

	@Override
	public Product updateDiscount(Product product) {
		if(!productDao.existsById(product.getProductId())) {
			throw new ResourceNotFoundException("Product Not Found.");
		}
		Optional<Product> optionalProduct =  productDao.findById(product.getProductId());
		Product currentProduct = optionalProduct.get();
		currentProduct.setProductDiscount(product.getProductDiscount());

		return productDao.save(currentProduct);
	}

	@Override
	public boolean removeProduct(Product product) {
		if(!productDao.existsById(product.getProductId())) {
			throw new ResourceNotFoundException("Given product ID is not available.");
		}
		
		productDao.deleteById(product.getProductId());
		
		return true;
	}

	@Override
	public boolean deleteProductQuantity(int quantity,long productId) {

		if(quantity <= 0) {
			throw new WrongUserInputException("Please enter valid quantity.");
		}
		Stock currentStock = stockDao.findStockByProductId(productId);
		if(currentStock.getTotalQuantity() < quantity ) {
			throw new WrongUserInputException("Please enter valid quantity.");
		}
//		if(currentStock.getTotalQuantity() == quantity) {
//			productDao.deleteById(productId);
//			return true;
//		}
		
		stockDao.deleteQuantityByProductId(quantity,productId);
		
		return true;
	}

	@Override
	public boolean addProductQuantity(int quantity, long productId) {
		if(quantity <= 0 || quantity >= 1000) {
			throw new WrongUserInputException("Quantity must be between 1 to 1000");
		}
			
		stockDao.addQuantityByProductId(quantity,productId);
		
		return true;
	}

	@Override
	public List<MerchantFeedback> getMerchantFeedback(long merchantId) {
		
		return merchantFeedbackDao.findMerchantFeedbackByMerchantId(merchantId);
	
	}

	@Override
	public MerchantFeedback sendMerchantFeedback(MerchantFeedback merchantFeedback) {
		if(merchantFeedback.getResponse().length() == 0) {
			throw new WrongUserInputException("Please add some response");
		}
		
		Optional<MerchantFeedback> optionalMerchantFeedback = merchantFeedbackDao.findById(merchantFeedback.getId());
		
		MerchantFeedback merchantFeedbackObj = optionalMerchantFeedback.get();
		merchantFeedbackObj.setResponse(merchantFeedback.getResponse());
		merchantFeedbackObj.setStatus(merchantFeedback.getStatus());
		
		
		return merchantFeedbackDao.save(merchantFeedbackObj);
	}

	@Override
	public List<Order> displayAllOrders(long merchantId) {
				
		return orderDao.getOrdersByMerchant(merchantId);
	}

	@Override
    public List<Product> searchProducts(long merchantId, String productName) {
        return productDao.searchProduct(merchantId, productName);
    }
	
	
	

}
