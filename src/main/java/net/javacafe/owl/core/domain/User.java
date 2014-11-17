package net.javacafe.owl.core.domain;

public class User {
	private String email;
	private String username;
	private String hashedPassword;

	public User() {
	}

	/**
	 * @param username
	 * @param email
	 * @param password
	 */
	public User(final String email, final String username, final String hashedPassword) {
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

	public final boolean isMatchedPassword(final String hashedPassword) {
		return this.hashedPassword.equalsIgnoreCase(hashedPassword);
	}

	/**
	 * @return the hashedPassword
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param hashedPassword
	 *            the hashedPassword to set
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

}
