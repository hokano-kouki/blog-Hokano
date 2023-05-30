package test.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ex.models.dao.AccountDao;
import test.ex.models.entity.AccountEntity;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;

	// 登録内容を保存する処理--------------------------------------------
	public void insert(String userName, String password, String email) {
		accountDao.save(new AccountEntity(userName, password, email));
	}

	// ログイン処理---------------------------------------------------------------------
	public AccountEntity selectByEmailAndPassword(String email, String password) {
		List<AccountEntity> accountList = accountDao.findByEmailAndPassword(email, password);
		if (accountList.isEmpty()) {
			return null;
		} else {
			return accountList.get(0);
		}
	}

	// 一覧を取得する処理-----------------------------------------------------------
	public List<AccountEntity> selectFindAll() {
		return accountDao.findAll();
	}

	// accountIdからデータを取得する------------------------------------------------
	public AccountEntity selectByAccountId(Long accountId) {
		return accountDao.findByAccountId(accountId);
	}

	// 内容をupdate-----------------------------------------------------------
	public void update(String userName, String email, String password) {
		accountDao.save(new AccountEntity(userName, email, password));
	}

	// 削除処理--------------------------------------------------------------
	public void delete(Long accountId) {
		accountDao.deleteById(accountId);
	}

}
