package net.javacafe.owl.core.events;

public class ModifyUsernameEvent {
	private final String email;
	private final String updatableUsername;

	/**
	 * @param email
	 * @param username
	 */
	public ModifyUsernameEvent(final String email, final String updatableUsername) {
		super();
		this.email = email;
		this.updatableUsername = updatableUsername;
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
	public String getUpdatableUsername() {
		return updatableUsername;
	}

}
