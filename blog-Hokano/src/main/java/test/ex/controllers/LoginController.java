package test.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.ex.models.entity.AccountEntity;
import test.ex.service.AccountService;

@Controller
public class LoginController {

	@Autowired 
	private AccountService accountService;
	
	@Autowired
	HttpSession session;
	
	//ログイン画面の表示
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password){
		//accountServiceクラスのfindByEmailAndPasswordメソッドを使用して、該当するユーザー情報を取得する。
		AccountEntity accountEntity = accountService.selectByEmailAndPassword(email, password);
		if(accountEntity == null) {
			return "login.html";
		}else {
			//accountEntityの内容をsessionに保存する
			session.setAttribute("admin", accountEntity);
			return "redirect:/top";
		}
		
	}
		
	
}
