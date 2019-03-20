package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.CategoryRepository;

@Controller
@RequestMapping(value="admin",method=RequestMethod.GET)
public class CategoryController {
	CategoryRepository repository = new CategoryRepository();
	@RequestMapping("category.html")
	public String index(Model model) {
		model.addAttribute("list",repository.getCategories());
		return "category.index";
	}
	@RequestMapping("admin/category/add.html")
	public String add(Model model) {
	//	model.addAttribute("list",repository.getParents());
		return "category.add";
	}
	@RequestMapping(value="admin/category/add.html",method=RequestMethod.POST)
	public String add(Category obj) {
		repository.add(obj);
		return "redirect:/category.html";
	}
	@ModelAttribute("list")
	private List<Category> getParents(){
		return repository.getParents();
	}
	@RequestMapping("admin/category/add2.html")
	public String add2(Model model) {
	//	model.addAttribute("list",repository.getParents());
		model.addAttribute("category", new Category());
		return "category.add2";
	}
	@RequestMapping("admin/category/edit.html/{id}")
	public String edit(@PathVariable("id")int id,Model model) {
		model.addAttribute("o",repository.getCategory(id));
		model.addAttribute("parents",repository.getParents());
		return "category.edit";
	}
	@RequestMapping("category/admin/edit2.html/{id}")
	public String edit2(@PathVariable("id")int id,Model model) {
		model.addAttribute("o",repository.getCategory(id));
		model.addAttribute("parents",repository.getParents());
		return "category.edit2";
	}
	@PostMapping("category/admin/edit.html/{id}")
	public String edit(Category obj) {
		repository.edit(obj);
		return "redirect:/category.html";
	}
	@PostMapping("category/admin/edit2.html/{id}")
	public String edit2(Category obj) {
		repository.edit(obj);
		return "redirect:/category.html";
	}
}
