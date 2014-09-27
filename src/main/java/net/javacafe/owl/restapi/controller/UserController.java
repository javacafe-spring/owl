package net.javacafe.owl.restapi.controller;

import javax.servlet.http.HttpServletRequest;

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
	private final UserService userService;

	public UserController(final UserService l) {
		this.userService = l;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn(HttpServletRequest request, Model model) {
		logger.info("signIn {}", request.getParameter("emailOrUsername"));
		LoginUser u = userService.signIn(new SignInEvent(request.getParameter("emailOrUsername"), request
				.getParameter("hashedPassword")));

		model.addAttribute("email", u.getEmail());
		model.addAttribute("userName", u.getUsername());

		return "login";
	}
}
