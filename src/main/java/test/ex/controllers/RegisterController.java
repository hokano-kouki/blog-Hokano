package test.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.ex.service.AccountService;

@Controller
public class RegisterController {
	@Autowired
	private AccountService accountService;
	
	//新規登録画面の表示/register
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register.html";
	}
	//保存処理/register return　リダイレクトして登録画面を表示させる
	
	@PostMapping("/register")
	public String register(@RequestParam String username,
			               @RequestParam String password,
			               @RequestParam String email) {
		//保存処理
		accountService.insert(username,password,email);
		return "login.html";
		
	}
}
