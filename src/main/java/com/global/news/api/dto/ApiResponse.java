
package com.global.news.api.dto;

public class ApiResponse {
	private String id;
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ApiResponse(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ApiResponse [id=" + id + ", value=" + value + "]";
	}

}
