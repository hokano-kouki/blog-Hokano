package test.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import test.ex.models.entity.AccountEntity;
import test.ex.service.BlogService;
import test.ex.service.CommentService;



@Controller
public class BlogViewController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private BlogService blogService;

	
	@Autowired
	HttpSession session;
	
	

	@GetMapping("/blog/view/{blogId}")
	public String getList(@PathVariable Long blogId,Model model) {
		//blogIdから表示しているブログ記事に対応したコメントを取得（HTML内で使用）
		model.addAttribute("commentList",commentService.selectByBlogId(blogId));
		//blogIdから表示しているブログ情報を取得（HTML内で使用）
		model.addAttribute("blogList",blogService.selectByBlogId(blogId));
		return "blog-view.html";
	}
	
	@PostMapping("/blog/view/{blogId}")
	public String addComment(@RequestParam String commentText,
							 @PathVariable Long blogId,
							 Model model) {

		//ログインしているユーザーの情報を取得
		AccountEntity userList = (AccountEntity) session.getAttribute("admin");
		String account_name = userList.getUserName();
	
		//コメントをDBに登録
		commentService.insert(commentText, blogId, account_name);
		
		return "redirect:/blog/view/{blogId}";
	}
	
}
