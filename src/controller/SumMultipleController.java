package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SumMultipleController {
	@RequestMapping(value="multiplesum.html", method=RequestMethod.GET )
	public String sumMultiple() {
		
		return "multiplesum";
	}
//	@RequestMapping(value="multiplesum.html", method=RequestMethod.POST)
//	public String sumMultiple(HttpServletRequest req) {
//		int s=0;
//		for(String item :req.getParameterValues("num")) {
//			s+= Integer.parseInt(item);
//		}
//		req.setAttribute("s", s);
//		return "multiplesum";
//	}
	@RequestMapping(value="multiplesum.html", method=RequestMethod.POST)
	public String sumMultiple(Model model,Integer[] num) {
		int s=0;
		for(Integer item :num) {
			s+= item;
		}
		model.addAttribute("s", s);
		return "multiplesum";
	}
}
