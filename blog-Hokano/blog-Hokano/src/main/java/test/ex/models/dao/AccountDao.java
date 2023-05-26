package test.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.ex.models.entity.AccountEntity;

@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Long> {
	// データの内容を保存
	AccountEntity save(AccountEntity accountEntity);

	// 一覧取得
	List<AccountEntity> findAll();

	// idを見つける
	AccountEntity findByAccountId(Long accountId);

	// accountEmailとpasswordを使用したAnd検索
	List<AccountEntity> findByEmailAndPassword(String email, String password);

}
