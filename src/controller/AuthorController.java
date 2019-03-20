package controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Author;
import model.AuthorRepository;
@Controller
public class AuthorController {
	AuthorRepository repository = new AuthorRepository();
	@RequestMapping("author.html")
	public String author(Model model) {
		model.addAttribute("list",repository.getAuthors());
		return "bg";
		//return "author/index";
	}
	@RequestMapping("author/add.html")
	public String add() {
		return "author.add";
	}
	@RequestMapping(value="author/add.html",method=RequestMethod.POST)
	public String add(Author obj) {
		repository.add(obj);
		return "redirect:/author.html";
	}
	@RequestMapping(value = "author.html", method = RequestMethod.POST)
	public String author(Author obj,Model model) {
		
		model.addAttribute("id", obj.getId());
		model.addAttribute("name", obj.getName());
		return "author";
	}
	@RequestMapping("author/del.html/{id}")
	public String delete(@PathVariable("id")int id) {
		repository.delete(id);
		return "redirect:/author.html";
	}
	@RequestMapping(value="author/del.html", method=RequestMethod.POST)
	public String delete(int[]a) {
			repository.delete(a);
		return "redirect:/author.html";
		
	}
	@GetMapping("author/edit.html/{id}")
	public String edit(@PathVariable("id")int id,Model model) {
		model.addAttribute("o", repository.getAuthors(id));
		return "author/edit";
	}
	@PostMapping("/author/edit.html/{id}")
	public String edit(Author obj,@PathVariable int id) {
		repository.edit(obj);
		return "redirect:/author.html";
	}
}
