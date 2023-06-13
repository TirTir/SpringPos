package com.example.demo;

public class UserAuthRequest { //login request
	private String userId;
	private String password;
	
	public UserAuthRequest() {
        // 기본 생성자
    }
	public UserAuthRequest(String userId, String password) {
		this.userId = userId;
		this.password = password;
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
	
}
