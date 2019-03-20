package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {
	@RequestMapping("publisher.html")
	public String index() {
		return "publisher";
	}
}
