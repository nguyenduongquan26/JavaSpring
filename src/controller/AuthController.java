package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Member;
import model.MemberRepository;
import ulti.Helper;

@Controller

public class AuthController {
	MemberRepository repository = new MemberRepository();
	@GetMapping("auth/register.html")
	public String register() {
		return "auth.register";
	}
	
	@PostMapping("auth/register.html")
	public String register(Member obj) {
		obj.setId(Helper.randomLong());
		repository.add(obj);
		return "redirect:/auth/logon.html";
	}
	
	@GetMapping("auth/logon.html")
	public String logon() {
		return "auth.logon";
	}
	@PostMapping("auth/logon.html")
	public String logon(String username) {
		repository.logOn(username);
		return "redirect:/";
		
	}
	
}
