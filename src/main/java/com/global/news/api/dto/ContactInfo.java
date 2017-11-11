package com.global.news.api.dto;

public class ContactInfo {

	private String name;
	private String email;
	private String mobile;
	private String fbUrl;
	private String fbGroupUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFbUrl() {
		return fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	public String getFbGroupUrl() {
		return fbGroupUrl;
	}

	public void setFbGroupUrl(String fbGroupUrl) {
		this.fbGroupUrl = fbGroupUrl;
	}

	public ContactInfo(String name, String email, String mobile, String fbUrl, String fbGroupUrl) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.fbUrl = fbUrl;
		this.fbGroupUrl = fbGroupUrl;
	}

	public ContactInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
