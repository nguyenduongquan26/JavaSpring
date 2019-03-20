package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Cart;
import model.CartRepository;
import model.Invoice;
import model.InvoiceRepository;
import ulti.Helper;

@Controller
public class CartController {
	CartRepository repository = new CartRepository();
	InvoiceRepository invoiceRepository = new InvoiceRepository();
	
	
	@RequestMapping("cart.html")
	public String index(@CookieValue("cart")String id,Model model) {
		model.addAttribute("list",repository.getCarts(id));
		return "cart.index";
	}
	
	
	@PostMapping("cart/add.html")
	public String add(@CookieValue("cart") String id, Cart obj) {
		obj.setId(id);
		repository.add(obj);
		
		return "redirect:/cart.html";
		
	}
	
	
	
/*	@PostMapping("cart/add.html")
	public String add(Cart obj, HttpServletRequest req, HttpServletResponse resp) {
		
		String id = null;
		for(Cookie cookie: req.getCookies()) {
			if(cookie.getName().equals("cart")) {
				id = cookie.getValue();
			}
		}
		
		if(id == null) {
			id = Helper.randomString(32);
			Cookie cookie = new Cookie("cart", id);
			cookie.setMaxAge(3600*24*30);
			cookie.setPath(req.getServletContext().getContextPath());
			resp.addCookie(cookie);
		}
			obj.setId(id);
		repository.add(obj);
		return "redirect:/cart.html";
	}*/
	
	
	@RequestMapping("cart/checkout.html")
	public String checkout(@CookieValue("cart") String id,Model model) {
	
		model.addAttribute("list",repository.getCarts(id));

		return "cart.checkout";
	}
	
	@PostMapping("cart/checkout.html")
	public String checkout(@CookieValue("cart") String id,Invoice obj,Model model,HttpServletRequest req,HttpServletResponse resp) {
		obj.setId(id);
		invoiceRepository.add(obj);
	//	model.addAttribute("list",repository.getCarts(id));
		/*Cookie cookie = new Cookie("cart", Helper.randomString(32));
		cookie.setMaxAge(3600*24*30);
		cookie.setPath(req.getServletContext().getContextPath());
		resp.addCookie(cookie);*/
		Helper.addCookie("cart",req, resp);
		return "redirect:/cart/detail.html/"+id;
	}
	@RequestMapping("cart/detail.html/{id}")
	public String detail(@PathVariable("id") String id, Model model) {
		model.addAttribute("o",invoiceRepository.getInvoice(id));
		return "cart.detail";
	}
	@PostMapping("cart/edit.html")
	public @ResponseBody String edit(short quantity,@CookieValue("cart") String id, Cart obj) {
		obj.setId(id);
		
		return String.valueOf(repository.edit(obj));
	}

}
