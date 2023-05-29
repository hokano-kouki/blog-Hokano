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
		//ログインしているユーザーの情報を取得
		AccountEntity userList = (AccountEntity) session.getAttribute("admin");
		Long account_id = userList.getAccountId();
		
		//登録されているすべての記事の情報を取得（HTML内で使用）
		model.addAttribute("blogList",blogService.selectFindAll());
		//ログインユーザーのアカウントIDを取得（HTML内で使用）
		model.addAttribute("accountId",account_id);
		return "top.html";
	}
	
	@PostMapping("/top")
	public String delete(@RequestParam Long blogId) {
		//削除処理
		blogService.delete(blogId);
		return "redirect:/top";
	}
	
}
