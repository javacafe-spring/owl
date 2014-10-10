package net.javacafe.owl.core.domain;

public class Post {
	private String id;
	private final String content;

	/**
	 * @param id
	 * @param content
	 */
	public Post(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	/**
	 * @param content
	 */
	public Post(final String content) {
		super();
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the content
	 */
	public final String getContent() {
		return content;
	}

}
