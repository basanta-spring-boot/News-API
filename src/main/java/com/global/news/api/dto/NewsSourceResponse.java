
package com.global.news.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "sources" })
public class NewsSourceResponse {

	@JsonProperty("status")
	private String status;
	@JsonProperty("sources")
	private List<Source> sources = null;

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("sources")
	public List<Source> getSources() {
		return sources;
	}

	@JsonProperty("sources")
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

}
