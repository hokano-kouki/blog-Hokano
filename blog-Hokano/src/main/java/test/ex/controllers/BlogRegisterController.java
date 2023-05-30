package test.ex.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import test.ex.models.entity.AccountEntity;
import test.ex.service.BlogService;

@Controller
public class BlogRegisterController {
	@Autowired
	private BlogService blogService;

	@Autowired
	HttpSession session;

	//ブログ作成画面の表示--------------------------------------------
	@GetMapping("/blog/register")
	public String getBlogRegisterPage() {
		return "blog-register.html";
	}

	// ブログ記事の投稿---------------------------------------------------------------------------
	/**
	 * @param blogTitle 投稿する記事のタイトル
	 * @param blogText　　投稿する記事の内容
	 * @param blogImage　投稿する記事の画像
	 * @param model　　
	 * @return
	 */
	@PostMapping("/blog/register")
	public String blogRegister(@RequestParam String blogTitle,
							   @RequestParam String blogText,
							   @RequestParam("blogImage") MultipartFile blogImage, Model model) {

		// ログイン中のユーザ情報を取得
		AccountEntity userList = (AccountEntity) session.getAttribute("admin");
		Long account_id = userList.getAccountId();

		// 画像ファイル名を取得
		String fileName = blogImage.getOriginalFilename();

		try {
			// 保存先の指定
			File blogFile = new File("./images/" + fileName);
			// バイナリデータの取得
			byte[] bytes = blogImage.getBytes();
			// 画像を保存するためのバッファを用意
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(blogFile));
			// ファイルの書き出し
			out.write(bytes);
			// バッファを閉じることで書き出しを正常終了
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 保存処理
		blogService.insert(blogTitle, blogText, fileName, account_id);
		return "redirect:/top";

	}

}
