package com.map.dto;

public class UserDto {

	
	private String username;
	private String mail;
	private String useraddress;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(String username, String mail, String useraddress, String password) {
		super();
		this.username = username;
		this.mail = mail;
		this.useraddress = useraddress;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", mail=" + mail + ", useraddress=" + useraddress + ", password="
				+ password + "]";
	}

	public UserDto() {
		super();
	}

	
	
	
	
	
	
}
