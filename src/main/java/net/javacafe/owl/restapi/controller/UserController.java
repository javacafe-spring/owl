package net.javacafe.owl.restapi.controller;

import javax.servlet.http.HttpServletRequest;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.events.ModifyUsernameEvent;
import net.javacafe.owl.core.events.SignInEvent;
import net.javacafe.owl.core.events.SignUpEvent;
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

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn(HttpServletRequest request, Model model) {
		model.addAttribute("state", "signIn");
		logger.info("signIn {}", request.getParameter("emailOrUsername"));

		LoginUser u = userService.signIn(new SignInEvent(request.getParameter("emailOrUsername"), request
				.getParameter("hashedPassword")));

		model.addAttribute("email", u.getEmail());
		model.addAttribute("username", u.getUsername());

		return "view";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(HttpServletRequest request, Model model) {
		model.addAttribute("state", "signUp");
		logger.info("signUp {}", request.getParameter("email"));

		User u = userService.signUp(new SignUpEvent(request.getParameter("username"), request.getParameter("email"),
				request.getParameter("hashedPassword")));

		model.addAttribute("email", u.getEmail());
		model.addAttribute("username", u.getUsername());

		return "view";
	}

	@RequestMapping(value = "/modifyUsername", method = RequestMethod.GET)
	public String modifyUsername(HttpServletRequest request, Model model) {
		model.addAttribute("state", "modifyUsername");
		logger.info("modifyUsername {}", request.getParameter("updatableUsername"));

		User u = userService.modifyUsername(new ModifyUsernameEvent(request.getParameter("email"), request
				.getParameter("updatableUsername")));

		model.addAttribute("email", u.getEmail());
		model.addAttribute("username", u.getUsername());

		return "view";
	}
}
