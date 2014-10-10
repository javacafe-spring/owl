package net.javacafe.owl.core.repository;

import net.javacafe.owl.core.domain.Post;

public interface PostDao {
	public int insert(Post p);

	public int delete(String id);
}
