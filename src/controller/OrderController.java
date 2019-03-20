package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.InvoiceRepository;

@Controller
public class OrderController {
	InvoiceRepository repository = new InvoiceRepository();
	@RequestMapping("order.html")
	public String index(Model model) {
		model.addAttribute("list",repository.getInvoices());
		return "order.index";
	}
}
