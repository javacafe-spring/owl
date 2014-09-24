package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.events.LoginEvent;

public interface LoginService {
	public LoginUser login(final LoginEvent e);
}
