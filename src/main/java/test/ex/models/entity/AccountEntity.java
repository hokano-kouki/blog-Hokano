package test.ex.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity {
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	public AccountEntity() {
		
	}
	public AccountEntity(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public AccountEntity(Long accountId, String userName, String password, String email) {
		this.accountId = accountId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	
	
}
