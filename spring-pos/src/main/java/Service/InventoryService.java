package Service;

import java.time.LocalDateTime;
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
    
	public void regist(Product product) throws Exception{ //상품 등록
		Product newProduct = new Product(product.getProductName(), product.getPrice(), product.getTotalCount(), LocalDateTime.now());
		productDao.insert(newProduct);
	}
	
    public List<Product> getAllProducts() { //전체 상품 조회
        return productDao.selectAllProduct();
    }
}
