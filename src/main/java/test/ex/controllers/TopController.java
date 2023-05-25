package test.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.ex.models.entity.AccountEntity;
import test.ex.service.BlogService;



@Controller
public class TopController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	

	@GetMapping("/top")
	public String getList(Model model) {

		model.addAttribute("blogList",blogService.selectFindAll());
		return "top.html";
	}
	
}
