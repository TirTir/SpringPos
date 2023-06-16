package Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.ProductRegisterRequest;

import dao.ProductDao;
import dto.Product;

@Service
public class ProductService {
	private ProductDao productDao;
	
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void regist(ProductRegisterRequest req) throws Exception {
		Product product = productDao.selectByProductName(req.getProductName());
		if (product != null) {
			throw new Exception("Duplicate Product Exception");
		}
		
		Product newProduct = new Product(req.getProductName(), req.getPrice(), req.getTotalCount(),
				LocalDateTime.now());
		productDao.insert(newProduct);
	}

}
