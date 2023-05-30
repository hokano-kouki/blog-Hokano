package test.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	// ログイン画面の表示-----------------------------------------------------
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}

	// ログイン処理-----------------------------------------------------------------------------------
	/**
	 * @param email    ログインユーザーのE-mail
	 * @param password ログインユーザーのパスワード
	 * @param model
	 * @return
	 */
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		// accountServiceクラスのfindByEmailAndPasswordメソッドを使用して、該当するユーザー情報を取得する。
		AccountEntity accountEntity = accountService.selectByEmailAndPassword(email, password);
		if (accountEntity == null) {
			// 入力されたメールアドレスまたはパスワードが存在しなかった場合
			//// errorをtrueにする（HTML側でエラーメッセージを出力するため）
			model.addAttribute("error", true);
			return "login.html";
		} else {
			// 入力されたメールアドレスまたはパスワードが存在した場合
			// accountEntityの内容をsessionに保存する
			session.setAttribute("admin", accountEntity);
			// errorをfalseにする（HTML側でエラーメッセージを出力させないため）
			model.addAttribute("error", false);
			return "redirect:/top";
		}

	}

}
