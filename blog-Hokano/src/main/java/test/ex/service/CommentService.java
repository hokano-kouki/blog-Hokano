package test.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import test.ex.models.dao.CommentDao;
import test.ex.models.entity.CommentEntity;

@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	//登録内容を保存する処理
	public void insert(String commentText, Long blogID, String userName) {
		commentDao.save(new CommentEntity(commentText,blogID,userName));
	}
	

	
	//一覧を取得する処理
	public List<CommentEntity> selectFindAll(){
		return commentDao.findAll();
	}
	
	//blogIdからデータを取得する
	public List<CommentEntity> selectByBlogId(Long blogId) {
		return commentDao.findByBlogId(blogId);
	}
	
	

}
