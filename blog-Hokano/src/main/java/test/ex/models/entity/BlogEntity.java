package test.ex.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="blog")
public class BlogEntity {
	
	@Id
	@Column(name="blog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;
	
	@Column(name="blog_title")
	private String blogTitle;
	
	@Column(name="blog_text")
	private String blogText;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="accout_id")
	private Long accountId;

	//コンストラクタ
	public BlogEntity() {

	}
	
	public BlogEntity(Long blogId, String blogTitle, String blogText, String comment, Long accountId) {
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogText = blogText;
		this.comment = comment;
		this.accountId = accountId;
	}
	
	public BlogEntity(String blogTitle, String blogText) {
		this.blogTitle = blogTitle;
		this.blogText = blogText;
	}


	public BlogEntity(String blogTitle, String blogText, Long accountId) {
		this.blogTitle = blogTitle;
		this.blogText = blogText;
		this.accountId = accountId;
	}

	//getter & setter
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	
	

}
