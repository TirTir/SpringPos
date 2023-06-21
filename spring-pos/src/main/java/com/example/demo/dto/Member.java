package com.example.demo.dto;

public class Member {
	private String userName; //유저 이름
	private String userId; //아이디
	private String password; //비밀번호
	private String position; //직책
	
	public Member() {
		
	}
	
	public Member(String userName, String userId, String password, String position)
	{
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.position = position;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
