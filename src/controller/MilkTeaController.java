package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MilkTeaController {
	@RequestMapping(value="trasua.html", method=RequestMethod.GET)
	public String sum() {
		return "trasua";
	}
	@RequestMapping(value="trasua.html",method=RequestMethod.POST)
	public String sum(Model  model,Float[] checkbox) {
		float s=0;
		for(float i:checkbox) {
			s += i;
		}
		model.addAttribute("s",s);
		return "trasua";
	}
}
