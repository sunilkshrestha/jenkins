package com.udemy.microservices.mobileapp.ws.request;

import javax.validation.constraints.*;

public class UserDetailRequest {

	private String userId;
	@NotNull(message="username not supplied")
	private String username;
	@NotNull
	private String password;
	@NotNull
	@Email
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
