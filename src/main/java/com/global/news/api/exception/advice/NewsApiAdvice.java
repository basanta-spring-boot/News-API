package com.global.news.api.exception.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class NewsApiAdvice {
	@ExceptionHandler(NewsApiException.class)
	public ModelAndView handleException(NewsApiException exception) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("errorMessage", exception.getMessage());
		return mav;
	}
}
