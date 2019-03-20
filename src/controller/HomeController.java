package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Category;
import model.CategoryRepository;
import model.Product;
import model.ProductRepository;
import model.Wishlist;
import model.WishlistRepository;

@Controller
public class HomeController {
	private int size = 6;
	ProductRepository repository = new ProductRepository();
	CategoryRepository cateRepository = new CategoryRepository();
	WishlistRepository wisRepository = new WishlistRepository();
	
	
//	@ModelAttribute("categories")
//	private List<Category> getCategories(){
//		return cateRepository.getCategories();
//	}
//	
	
	
	
	@RequestMapping("/home/browser.html/{id}")
	public String browser(@PathVariable("id")int id,Model model) {
		model.addAttribute("list",repository.getProducts(id));
		model.addAttribute("o",cateRepository.getCategory(id));
		return "home.browser";
	}
	
	@RequestMapping(value={"/","/{p}"})
	public String index(Model model,@CookieValue("token")String token, @PathVariable(value="p", required = false)Integer p ) {
		if(p==null) {
			p=1;
		}	
		model.addAttribute("n",Math.ceil(repository.count()/(double)size));
		model.addAttribute("list",repository.getProducts((p-1)*size,size));
		model.addAttribute("wishlist", wisRepository.getWishlist(token));
		return"home";
	}
	@RequestMapping("home/detail.html/{id}")
	public String detail(@PathVariable("id") int id, @CookieValue("token")String token, Model model) {
		Product obj = repository.getProduct(id);
		wisRepository.addWishlist(new Wishlist(token, id));
		model.addAttribute("o",obj);
		model.addAttribute("list",repository.getProductRelated(obj.getId(), obj.getCategoryId()));
		return "home.detail";
	}
	@RequestMapping("home/search.html")
	public String search(@RequestParam("q")String q, Model model) {
		model.addAttribute("q",q);
		model.addAttribute("list",repository.search(q));
		return "home.search";
	}
	

}
