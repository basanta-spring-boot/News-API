
package com.global.news.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "description", "url", "category", "language", "country", "sortBysAvailable" })
public class Source {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("url")
	private String url;
	@JsonProperty("category")
	private String category;
	@JsonProperty("language")
	private String language;
	@JsonProperty("country")
	private String country;
	@JsonProperty("sortBysAvailable")
	private List<String> sortBysAvailable = null;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("sortBysAvailable")
	public List<String> getSortBysAvailable() {
		return sortBysAvailable;
	}

	@JsonProperty("sortBysAvailable")
	public void setSortBysAvailable(List<String> sortBysAvailable) {
		this.sortBysAvailable = sortBysAvailable;
	}

}
