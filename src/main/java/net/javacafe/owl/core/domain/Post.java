package net.javacafe.owl.core.domain;

public class Post {
	private final String content;

	/**
	 * @param content
	 */
	public Post(final String content) {
		super();
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public final String getContent() {
		return content;
	}

}