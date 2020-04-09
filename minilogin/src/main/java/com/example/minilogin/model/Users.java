package com.example.minilogin.model;

public class Users {
	private Long id;
	private String email;
	private String name;
	private String password;
	private String confirm_password;
	public Users()
	{
		
	}
	public Users(Long id, String email, String name, String password, String confirm_password) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.confirm_password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", confirm_password=" + confirm_password + "]";
	}
	

	

}