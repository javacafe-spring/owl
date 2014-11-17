package net.javacafe.owl.restapi.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserController(final UserService l) {
		this.userService = l;
	}

	@RequestMapping(value = "/signIn")
	public String signIn(@ModelAttribute SignInEvent e, Model m) {
		LoginUser u = userService.signIn(e);
		m.addAttribute(u);
		logger.info("sign in login user : {} ", u);
		return "signIn";
	}

	@RequestMapping(value = "/signUp")
	public String signUp(@ModelAttribute SignUpEvent e, Model m) {
		User u = userService.signUp(e);
		m.addAttribute(u);
		return "signUp";
	}

	@RequestMapping(value = "/modifyUsername", method = RequestMethod.GET)
	public String modifyUsername(@ModelAttribute ModifyUsernameEvent e) {
		userService.modifyUsername(e);
		return "view";
	}
}
