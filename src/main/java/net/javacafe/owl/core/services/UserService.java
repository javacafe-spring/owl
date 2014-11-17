package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.events.ModifyUsernameEvent;
import net.javacafe.owl.core.events.SignInEvent;
import net.javacafe.owl.core.events.SignUpEvent;

public interface UserService {
	public String signUp(final SignUpEvent e);

	public LoginUser signIn(final SignInEvent e);

	public void modifyUsername(final ModifyUsernameEvent e);
}
