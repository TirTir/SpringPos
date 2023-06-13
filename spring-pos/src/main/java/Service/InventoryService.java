package Service;

import java.util.List;

import dao.ProductDao;
import dto.Product;

public class InventoryService {
	private ProductDao productDao;
	
    public InventoryService(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    public List<Product> getAllProducts() {
        return productDao.selectAllProduct();
    }
}
