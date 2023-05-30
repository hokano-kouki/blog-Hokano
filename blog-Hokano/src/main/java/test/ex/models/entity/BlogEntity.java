package test.ex.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity {

	@Id
	@Column(name = "blog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;

	@Column(name = "blog_title")
	private String blogTitle;

	@Column(name = "blog_text")
	private String blogText;

	@Column(name = "blog_img")
	private String blogImage;

	@Column(name = "account_id")
	private Long accountId;

	// コンストラクタ
	public BlogEntity() {

	}

	public BlogEntity(Long blogId, String blogTitle, String blogText, String blogImage, Long accountId) {
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogText = blogText;
		this.blogImage = blogImage;
		this.accountId = accountId;
	}

	public BlogEntity(String blogTitle, String blogText) {
		this.blogTitle = blogTitle;
		this.blogText = blogText;
	}

	public BlogEntity(String blogTitle, String blogText, String blogImage, Long accountId) {
		this.blogTitle = blogTitle;
		this.blogText = blogText;
		this.blogImage = blogImage;
		this.accountId = accountId;
	}

	// getter & setter
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogText() {
		return blogText;
	}

	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}

	public String getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
