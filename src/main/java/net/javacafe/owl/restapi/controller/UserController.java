package net.javacafe.owl.restapi.controller;

import java.util.Locale;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.events.SignInEvent;
import net.javacafe.owl.core.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserService loginService;

	public UserController(final UserService l) {
		this.loginService = l;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("access loing api ", locale);

		LoginUser u = loginService.signIn(new SignInEvent("placebo2me@gmail.com", "1234"));

		model.addAttribute("email", u.getEmail());
		model.addAttribute("userName", u.getUsername());

		return "login";
	}
}
