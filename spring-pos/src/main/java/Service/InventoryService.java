package Service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.ProductDao;
import dto.Product;

@Service
public class InventoryService {
	private ProductDao productDao;
	
    public InventoryService(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    public List<Product> getAllProducts() {
        return productDao.selectAllProduct();
    }
}
