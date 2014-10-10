package net.javacafe.owl.infra.repository;

import net.javacafe.owl.core.domain.Post;
import net.javacafe.owl.core.repository.PostDao;

public class FakePostDao implements PostDao {

	@Override
	public int insert(Post p) {
		return 1;
	}

	@Override
	public int delete(String id) {
		return 1;
	}

}
