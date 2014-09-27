package net.javacafe.owl.core.events;

public class ModifyUsernameEvent {
	private final String email;
	private final String username;

	/**
	 * @param email
	 * @param username
	 */
	public ModifyUsernameEvent(final String email, final String username) {
		super();
		this.email = email;
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

}
