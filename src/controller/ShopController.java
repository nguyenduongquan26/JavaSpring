package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import model.Invoice;
import model.InvoiceDetail;
import model.InvoiceRepository;
import model.ProductRepository;
import ulti.Helper;


@Controller
public class ShopController {
	ProductRepository repository = new ProductRepository();
	InvoiceRepository invoiceRepository = new InvoiceRepository();
	@RequestMapping("shop.html")
	public String index() {
		return "shop";
	}
	
/*	@PostMapping("shop/add.html")
	public String add(Invoice obj, int[] id, int[] price, short[] quantity) {
		int n = id.length;
		
		obj.setId(Helper.randomString(32));
		
		List<InvoiceDetail> details = new LinkedList<>();
		System.out.println(n);
		
		
		for(int i=0;i<n;i++) {
			details.add(new InvoiceDetail(obj.getId(),id[i],quantity[i],price[i]));
		}
	
		obj.setDetails(details);
		invoiceRepository.add2(obj);
		return "redirect:/shop/detail.html/"+ obj.getId();
	}*/
	
	@PostMapping("shop/add.html")
	public String add(HttpServletRequest req, HttpServletResponse resp) {
		Invoice obj = new Invoice(Helper.randomString(32),req.getParameter("email"),req.getParameter("tel"),req.getParameter("address"));
		Map<String, String[]> map = req.getParameterMap();
		int n = map.get("id").length;
		List<InvoiceDetail> details = new LinkedList<>();
		for(int i=0;i<n;i++) {
			details.add(new InvoiceDetail(obj.getId(),Integer.parseInt(map.get("id")[i]),Short.parseShort(map.get("quantity")[i]),
					Integer.parseInt(map.get("price")[i])));
			
		}
		obj.setDetails(details);
		invoiceRepository.add2(obj);
		return "redirect:/shop/detail.html/"+obj.getId();
	}
	
	@GetMapping("shop/detail.html/{id}")
	public String detail(@PathVariable("id")String id , Model model) {
		model.addAttribute("o",invoiceRepository.getInvoice(id));
		return "shop.detail";
	}
}
