package net.javacafe.owl.restapi.controller;

import java.util.Locale;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.events.LoginEvent;
import net.javacafe.owl.core.services.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final LoginService loginService;

	public LoginController(final LoginService l) {
		this.loginService = l;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("access login api ", locale);

		LoginUser u = loginService.login(new LoginEvent("tech@skyaperture.com", "1234"));

		model.addAttribute("email", u.getEmail());
		model.addAttribute("userName", u.getUsername());

		return "login";
	}
}
