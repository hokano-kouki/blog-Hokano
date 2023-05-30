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

	// 新規登録画面の表示------------------------------------------
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register.html";
	}

	// 保存処理------------------------------------------------------
	/**
	 * @param username 登録したいユーザー名
	 * @param password 登録したいパスワード
	 * @param email    登録したいE-mail
	 * @return
	 */
	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
		// 保存処理
		accountService.insert(username, password, email);
		return "login.html";

	}
}
