package net.javacafe.owl.core.events;

public class SignUpEvent {
	private final String username;
	private final String email;
	private final String hashedPassword;

	/**
	 * @param username
	 * @param email
	 * @param hashedPassword
	 */
	public SignUpEvent(String username, String email, String hashedPassword) {
		super();
		this.username = username;
		this.email = email;
		this.hashedPassword = hashedPassword;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the hashedPassword
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

}
