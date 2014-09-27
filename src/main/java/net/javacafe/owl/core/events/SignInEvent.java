package net.javacafe.owl.core.events;

public class SignInEvent {
	private final String emailOrUsername;
	private final String hashedPassword;

	/**
	 * @param emailOrUsername
	 * @param hashedPassword
	 */
	public SignInEvent(String emailOrUsername, String hashedPassword) {
		super();
		this.emailOrUsername = emailOrUsername;
		this.hashedPassword = hashedPassword;
	}

	/**
	 * @return the emailOrUsername
	 */
	public String getEmailOrUsername() {
		return emailOrUsername;
	}

	/**
	 * @return the hashedPassword
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

}
