package api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import model.Product;
import model.ProductRepository;


@RestController
public class ProductApi {
	ProductRepository repository = new ProductRepository();
	
	
	
	@RequestMapping(value="api/product",method=RequestMethod.POST)
	public @ResponseBody Product search(String isbn) {
		return repository.getProduct(isbn);
	}
	

		
	}
	
	
