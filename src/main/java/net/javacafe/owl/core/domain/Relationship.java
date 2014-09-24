/**
 * 
 */
package net.javacafe.owl.core.domain;

/**
 * @author pLacebo
 *
 */
public class Relationship {
	private final String from;
	private final String to;

	/**
	 * @param from
	 * @param to
	 */
	public Relationship(final String from, final String to) {
		super();
		this.from = from;
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public final String getFrom() {
		return from;
	}

	/**
	 * @return the to
	 */
	public final String getTo() {
		return to;
	}

}
