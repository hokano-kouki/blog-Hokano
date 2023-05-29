package test.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.ex.models.entity.BlogEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Long> {
	// データの内容を保存
	BlogEntity save(BlogEntity blogEntity);

	// 一覧取得
	List<BlogEntity> findAll();

	// idを見つける
	BlogEntity findByBlogId(Long blogId);

	//削除
	@Transactional
	 List<BlogEntity> deleteByBlogId(Long blogId);
}
