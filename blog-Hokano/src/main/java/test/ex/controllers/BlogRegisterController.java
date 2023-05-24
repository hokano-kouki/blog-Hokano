package test.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.ex.models.entity.AccountEntity;
import test.ex.service.BlogService;



@Controller
public class BlogRegisterController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/blog-register")
	public String getRegisterPage() {
		return "blog-register.html";
	}
	
	

	//投稿(余裕があったらログインユーザーのアカウントid登録）
	@PostMapping("/blog-register")
	public String register(@RequestParam String blogTitle,
						   @RequestParam String blogText) {
		AccountEntity userList = (AccountEntity) session.getAttribute("admin");
		Long account_id = userList.getAccountId();
		
		//保存処理
		blogService.insert(blogTitle,blogText,account_id);
		return "top.html";
		
	}
	
}
