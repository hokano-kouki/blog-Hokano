package test.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ex.models.dao.AccountDao;
import test.ex.models.dao.BlogDao;
import test.ex.models.entity.AccountEntity;
import test.ex.models.entity.BlogEntity;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	
	//登録内容を保存する処理
	public void insert(String blogTitle,String blogText,String fileName,Long account_id) {
		blogDao.save(new BlogEntity(blogTitle,blogText,fileName,account_id));
	}
	

	
	//一覧を取得する処理
	public List<BlogEntity> selectFindAll(){
		return blogDao.findAll();
	}
	
	//blogIdからデータを取得することをしていく
	public BlogEntity selectByBlogId(Long blogId) {
		return blogDao.findByBlogId(blogId);
	}
	
	//内容をupdate
	public void update(String blogTitle,String blogText,String fileName,Long account_id,Long blog_id) {
		BlogEntity blogEntity = blogDao.findByBlogId(blog_id);
		if(fileName == null) {
			String newFileName = blogEntity.getBlogImage();
			blogDao.save(new BlogEntity(blog_id,blogTitle,blogText,newFileName,account_id));
		}else {
			blogDao.save(new BlogEntity(blog_id,blogTitle,blogText,fileName,account_id));
		}
		
	}
	
	//削除処理
    public void delete(Long blogId) {
    	blogDao.deleteByBlogId(blogId);
    }
    
//    public void aa(String fileName) {
//    	return blogDao.;
//    }

}
