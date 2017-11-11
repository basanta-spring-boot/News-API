package com.global.news.api.util;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.global.news.api.dto.Respone;

@Component
public class MailUtil {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private TemplateEngine templateEngine;

	public String sendEmail(String to, String subject, List<Respone> respones, String mediaSource, String sortBy)
			throws Exception {
		String templateName = "email/emailTemplate";
		Context context = new Context();
		context.setVariable("respones", respones);
		context.setVariable("mediaSource", mediaSource);
		context.setVariable("sortBy", sortBy);
		String body = templateEngine.process(templateName, context);
		MimeMessage mail = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.setFrom("basant1993.dev@gmail.com");
		sender.send(mail);
		return "mail send successfully to :" + to;
	}

}
