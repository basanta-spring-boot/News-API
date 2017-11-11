
package com.global.news.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "author", "title", "description", "url", "urlToImage", "publishedAt" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Respone {

	@JsonProperty("author")
	private String author;
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("url")
	private String url;
	@JsonProperty("urlToImage")
	private String urlToImage;
	@JsonProperty("publishedAt")
	private String publishedAt;

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
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

	@JsonProperty("urlToImage")
	public String getUrlToImage() {
		return urlToImage;
	}

	@JsonProperty("urlToImage")
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	@JsonProperty("publishedAt")
	public String getPublishedAt() {
		return publishedAt;
	}

	@JsonProperty("publishedAt")
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

}
