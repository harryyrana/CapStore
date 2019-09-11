package com.capgemini.capstore.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.MerchantFeedback;
import com.capgemini.capstore.beans.Order;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Stock;
import com.capgemini.capstore.dao.CategoryDao;
import com.capgemini.capstore.dao.MerchantFeedbackDao;
import com.capgemini.capstore.dao.OrderDao;
import com.capgemini.capstore.dao.ProductDao;
import com.capgemini.capstore.dao.StockDao;
import com.capgemini.capstore.exceptions.ResourceNotFoundException;
import com.capgemini.capstore.exceptions.UnsuccessfullOperations;
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
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Product addProduct(Product product,int quantity) {
		
		if(quantity <= 0) {
			throw new WrongUserInputException("Quantity must be greater than 0.");
		}
		if(product.getProductDiscount() < 0 || product.getProductDiscount() > 100) {
			throw new WrongUserInputException("Discount must be between 0 and 100");
		}
		if(product.getProductPrice() < 9 || product.getProductPrice() > 99999) {
			throw new WrongUserInputException("Price must be between 9 and 99999");
		}
		String convrtedName = product.getProductName().toLowerCase();
		product.setProductName(convrtedName);
		Product returnProductData =  productDao.save(product);
		long productId = product.getProductId();
		Optional<Product> optionalProduct = productDao.findById(productId);
		Product currentProduct = optionalProduct.get();
		
		Stock currentProductStock = new Stock();
		currentProductStock.setProduct(currentProduct);
		currentProductStock.setTotalQuantity(quantity);
		currentProductStock.setAvailable(quantity);
		stockDao.save(currentProductStock);
	
		return returnProductData;
		

	}

	@Override
	public List<Stock> getProductsByMerchantId(long merchantId) {
		return stockDao.findByMerchantId(merchantId);
//		return productDao.findProductByMerchant(merchantId);
	}

	@Override
	public Product updateDiscount(Product product) {
		if(!productDao.existsById(product.getProductId())) {
			
			throw new ResourceNotFoundException("Product Not Found.");
		}
		if(product.getProductDiscount() < 0 || product.getProductDiscount() > 100) {
			
			throw new WrongUserInputException("Discount Should be between 0 and 100.");
		}
		Optional<Product> optionalProduct =  productDao.findById(product.getProductId());
		Product currentProduct = optionalProduct.get();
		currentProduct.setProductDiscount(product.getProductDiscount());
		currentProduct.setProductPrice(currentProduct.getProductPrice()-(currentProduct.getProductPrice()*(product.getProductDiscount()/100)));

		return productDao.save(currentProduct);
	}

	@Override
	public boolean removeProduct(long productId) {
		if(!productDao.existsById(productId)) {
			throw new ResourceNotFoundException("Given product ID is not available.");
		}
		
		productDao.deleteById(productId);
		if(productDao.existsById(productId)) {
			throw new UnsuccessfullOperations("Server error");
		}
		return true;
	}

	@Override
	public Product deleteProductQuantity(int quantity,long productId) {

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
		Optional<Product> optionalProduct = productDao.findById(productId);
		Product product = optionalProduct.get();
		return product;
	}

	@Override
	public Product addProductQuantity(int quantity, long productId) {
		if(quantity <= 0 || quantity >= 1000) {
			throw new WrongUserInputException("Quantity must be between 1 to 1000");
		}
			
		stockDao.addQuantityByProductId(quantity,productId);
		
		Optional<Product> optionalProduct = productDao.findById(productId);
		Product product = optionalProduct.get();
		return product;
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
    public List<Stock> searchProducts(long merchantId, String productName) {
		String convertedProductName = productName.toLowerCase();
        return stockDao.searchProducts(merchantId, convertedProductName);
    }

	@Override
	public List<Category> getCategories() {
		return categoryDao.findAll();
	}


	
	
	

}
