package net.javacafe.owl.restapi.controller;

import javax.servlet.http.HttpServletRequest;

import net.javacafe.owl.core.domain.Post;
import net.javacafe.owl.core.events.PostEvent;
import net.javacafe.owl.core.events.RemovePostingEvent;
import net.javacafe.owl.core.services.LoginUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginUserController {
	private static final Logger logger = LoggerFactory.getLogger(LoginUserController.class);

	@Autowired
	private ApplicationContext context;

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(HttpServletRequest request, Model model) {
		model.addAttribute("state", "post");
		logger.info("post {}", request.getParameter("content"));
		LoginUserService s = context.getBean("loginUserService", LoginUserService.class);
		Post p = s.post(new PostEvent(request.getParameter("content")));

		model.addAttribute("content", p.getContent());
		model.addAttribute("classId", s.toString());

		return "view";
	}

	@RequestMapping(value = "/removePosting", method = RequestMethod.GET)
	public String remove(HttpServletRequest request, Model model) {
		model.addAttribute("state", "remove");
		logger.info("remove {}", request.getParameter("id"));
		LoginUserService s = context.getBean("loginUserService", LoginUserService.class);
		int i = s.remove(new RemovePostingEvent(request.getParameter("id")));

		model.addAttribute("content", request.getParameter("id"));
		model.addAttribute("classId", s.toString());

		return "view";
	}
}
