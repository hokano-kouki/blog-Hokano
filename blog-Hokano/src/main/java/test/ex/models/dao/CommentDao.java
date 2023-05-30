package test.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.ex.models.entity.CommentEntity;

@Repository
public interface CommentDao extends JpaRepository<CommentEntity, Long> {
	// データの内容を保存
	CommentEntity save(CommentEntity commentEntity);

	// 一覧取得
	List<CommentEntity> findAll();

	// idを見つける
	List<CommentEntity> findByBlogId(Long blogId);

}
