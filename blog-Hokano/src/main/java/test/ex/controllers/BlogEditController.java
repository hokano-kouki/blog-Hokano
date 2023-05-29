package test.ex.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import test.ex.models.entity.AccountEntity;
import test.ex.service.BlogService;



@Controller
public class BlogEditController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/blog/edit/{blogId}")
	public String getRegisterPage(@PathVariable Long blogId,Model model) {
		//blogIdから編集を行いたいブログ情報を取得（HTML内で使用）
		model.addAttribute("blogList",blogService.selectByBlogId(blogId));
		return "blog-edit.html";
	}
	
	

	//投稿
	@PostMapping("/blog/update")
	public String register(@RequestParam String blogTitle,
						   @RequestParam String blogText,
						   @RequestParam("blogImage") MultipartFile blogImage,
						   @RequestParam Long blogId,
						   Model model) {
		
		//ログイン中のユーザ情報を取得
		AccountEntity userList = (AccountEntity) session.getAttribute("admin");
		Long account_id = userList.getAccountId();
		
		//画像ファイル名を取得
		String fileName = blogImage.getOriginalFilename();
		
		try {
			//保存先の指定
			File blogFile = new File("./images/"+fileName);
			//バイナリデータの取得
			byte[] bytes = blogImage.getBytes();
			//画像を保存するためのバッファを用意
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(blogFile));
			//ファイルの書き出し
			out.write(bytes);
			//バッファを閉じることで書き出しを正常終了
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		//保存処理
		blogService.update(blogTitle,blogText,fileName,account_id,blogId);
		return "redirect:/top";
		
	}
	
}
