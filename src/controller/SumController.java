package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SumController {
	//@RequestMapping("sum.html")
	@RequestMapping(value= "sum.html", method= RequestMethod.GET)
	public String sumController() {
		return "sum";
	}
	
	
/*	public String sum(int a,int b,HttpServletRequest req) {
		int rs = a + b;
		req.setAttribute("rs", rs);
		return "sum";
	}*/
	@RequestMapping(value = "sum.html", method = RequestMethod.POST)
	public String sum(int a,int b,Model model) {
		int rs = a + b;
		model.addAttribute("rs", rs);
		return "sum";
	}
}
