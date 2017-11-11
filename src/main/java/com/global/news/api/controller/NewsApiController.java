package com.global.news.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.news.api.dto.ApiResponse;
import com.global.news.api.dto.NewsResponse;
import com.global.news.api.dto.Respone;
import com.global.news.api.dto.Source;
import com.global.news.api.dto.service.NewsAPIService;
import com.global.news.api.exception.advice.NewsApiException;

@Controller
@RequestMapping("/news-api")
public class NewsApiController {
	@Autowired
	private NewsAPIService service;
	private Map<String, String> mediaMap = new HashMap<>();
	List<ApiResponse> mediaIds = null;
	List<Respone> currentResponse = null;
	String mediaSource = null;
	String newsId = null;
	private String sortByNews = "";

	@RequestMapping("/home")
	public String viewHome(Model model) throws NewsApiException {
		List<ApiResponse> idLists = service.getNewsId();
		mediaIds = idLists;
		model.addAttribute("idLists", idLists);
		return "home";
	}

	@RequestMapping("/getSource")
	public String getSource(@RequestParam("id") String id, Model model) throws NewsApiException {
		List<ApiResponse> sortBys = new LinkedList<>();
		Source source = service.getSourceById(id);
		source.getSortBysAvailable().forEach(s -> sortBys.add(new ApiResponse(null, s)));
		// added manually value for drop down(select)
		sortBys.add(new ApiResponse(null, "Select"));
		Collections.reverse(sortBys);
		newsId = source.getName();
		mediaMap.put(newsId, id);
		model.addAttribute("newsId", newsId);
		model.addAttribute("sortBys", sortBys);
		model.addAttribute("idLists", mediaIds);
		return "home";
	}

	@RequestMapping("/getNews")
	public String getNews(@RequestParam("source") String source, @RequestParam("sortBy") String sortBy, Model model)
			throws NewsApiException {
		String mediaSourceLink = mediaMap.get(source);
		NewsResponse response = service.getNewsApiResponse(mediaMap.get(source), sortBy);
		mediaSource = source;
		sortByNews = sortBy;
		List<Respone> respones = response.getResponse();
		currentResponse = respones;
		model.addAttribute("respones", respones);
		model.addAttribute("mediaSource", mediaSource);
		model.addAttribute("mediaSourceLink", mediaSourceLink);
		model.addAttribute("idLists", mediaIds);
		return "news";
	}

	@GetMapping("/contactUs")
	public String contactUs(Model model) {
		model.addAttribute("contact", service.getContactInfo());
		return "contactUs";
	}

	@RequestMapping("/rate")
	public String getLikeDislike(Model model, @RequestParam("rate") String rate) {
		String rateMessage = rate.equalsIgnoreCase("like") ? "Thanks for Like My Application"
				: "Sorry ! i will try to improve (if any concern really appriciable) you can mail me Thanks";
		model.addAttribute("rateMessage", rateMessage);
		List<String> msg = new ArrayList<>();
		msg.add("Dummy list to hide popup");
		model.addAttribute("msg", msg);
		return "home";
	}

	@GetMapping("/getEmailForm")
	public String getNotificationForm(Model model) {
		List<String> msg = new ArrayList<>();
		msg.add("Dummy list to hide popup");
		model.addAttribute("msg1", msg);
		model.addAttribute("idLists", mediaIds);
		return "home";
	}

	@RequestMapping("/sendEmail")
	public String sendEmail(Model model, @RequestParam("email") String emailId) throws NewsApiException {
		String mailMessage = service.sendEmail(emailId, newsId + " Current Update", currentResponse, mediaSource,
				sortByNews);
		model.addAttribute("mailMessage", mailMessage);
		model.addAttribute("idLists", mediaIds);
		return "home";
	}
}
