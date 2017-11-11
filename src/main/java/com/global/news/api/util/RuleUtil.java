package com.global.news.api.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.news.api.common.NewsApiConstants;
import com.global.news.api.dto.NewsResponse;
import com.global.news.api.dto.NewsSourceResponse;
import com.global.news.api.exception.advice.NewsApiException;

@Component
@PropertySource(value = { "classpath:application.properties" })
public class RuleUtil {
	private RestTemplate template;
	ObjectMapper mapper = null;
	HttpHeaders headers = null;
	@Value("${news.api.root.url}")
	private String API_URL;
	@Value("${news.api.key}")
	private String API_KEY;
	@Value("${news.api.source.url}")
	private String NEWS_SOURCE_URL;

	@PostConstruct
	public void init() {
		template = new RestTemplate();
		mapper = new ObjectMapper();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		template.getMessageConverters().add(new StringHttpMessageConverter());
	}

	public NewsResponse getNews(String source, String sortBy) throws NewsApiException {
		String URL = API_URL + NewsApiConstants.SOURCE + NewsApiConstants.EQUAL + source + NewsApiConstants.AND
				+ NewsApiConstants.SORTBY + NewsApiConstants.EQUAL + sortBy + NewsApiConstants.AND
				+ NewsApiConstants.API_KEY + NewsApiConstants.EQUAL + API_KEY;
		NewsResponse response = null;
		try {
			String result = template.getForObject(URL, String.class);
			response = mapper.readValue(result, NewsResponse.class);
		} catch (Exception e) {
			throw new NewsApiException("News API Service Gateway Failed");
		}
		return response;
	}

	public NewsSourceResponse getNewsSources() throws NewsApiException {
		String URL = NEWS_SOURCE_URL;
		NewsSourceResponse response = null;
		try {
			String result = template.getForObject(URL, String.class);
			response = mapper.readValue(result, NewsSourceResponse.class);
		} catch (Exception e) {
			throw new NewsApiException("News API Service Gateway Failed");
		}
		return response;
	}
}
