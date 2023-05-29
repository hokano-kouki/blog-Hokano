package test.ex.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="comment")
public class CommentEntity {
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	
	@Column(name="comment_text")
	private String commentText;
	
	@Column(name="blog_id")
	
	private Long blogId;
	
	@Column(name="user_name")
	private String userName;
	
	public CommentEntity() {
		
	}

	public CommentEntity(String commentText, Long blogId, String userName) {
		this.commentText = commentText;
		this.blogId = blogId;
		this.userName = userName;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogID(Long blogID) {
		this.blogId = blogID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}