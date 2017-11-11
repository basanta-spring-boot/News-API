package com.global.news.api.dto.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.global.news.api.dto.ApiResponse;
import com.global.news.api.dto.ContactInfo;
import com.global.news.api.dto.NewsResponse;
import com.global.news.api.dto.NewsSourceResponse;
import com.global.news.api.dto.Respone;
import com.global.news.api.dto.Source;
import com.global.news.api.exception.advice.NewsApiException;
import com.global.news.api.util.MailUtil;
import com.global.news.api.util.RuleUtil;

@Service

@PropertySource(value = { "classpath:application.properties" })
public class NewsAPIService {

	private NewsSourceResponse response;
	@Value("${contact.name}")
	private String name;
	@Value("${contact.email}")
	private String email;
	@Value("${contact.mobile}")
	private String mobile;
	@Value("${contact.fb.url}")
	private String facebookProfileURL;
	@Value("${contact.fb.group}")
	private String facebookGroupUrl;

	@Autowired
	private RuleUtil ruleUtil;
	@Autowired
	private MailUtil mailUtil;

	public NewsResponse getNewsApiResponse(String source, String sortBy) throws NewsApiException {
		NewsResponse response = ruleUtil.getNews(source, sortBy);
		response.getResponse().stream().filter(obj -> obj.getDescription().isEmpty())
				.forEach(obj -> obj.setDescription("Content Not Available Click on Above Link"));
		return response;
	}

	@PostConstruct
	public NewsSourceResponse getSources() throws NewsApiException {
		if (response == null) {
			return response = ruleUtil.getNewsSources();
		}
		return this.response;
	}

	public List<ApiResponse> getNewsId() throws NewsApiException {
		response = getSources();
		List<ApiResponse> idList = new ArrayList<>();
		response.getSources().stream().forEach(s -> idList.add(new ApiResponse(s.getId(), null)));
		return idList;
	}

	public Source getSourceById(String id) throws NewsApiException {
		response = getSources();
		Source source = response.getSources().stream().filter(s -> id.equalsIgnoreCase(s.getId())).findAny().get();
		return source;
	}

	public ContactInfo getContactInfo() {
		return new ContactInfo(name, email, mobile, facebookProfileURL, facebookGroupUrl);
	}

	public String sendEmail(String to, String subject, List<Respone> respones, String mediaSource,String sortBy)
			throws NewsApiException {
		try {
			return mailUtil.sendEmail(to, subject, respones, mediaSource,sortBy);
		} catch (Exception e) {
			throw new NewsApiException("Unable to send Notification ,Server might have issue please retry !!");
		}
	}
}
