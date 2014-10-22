/**
 * 
 */
package net.javacafe.owl.infra.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import net.javacafe.owl.config.RootConfig;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pLacebo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class LocalUserDaoTest {

	@Autowired
	LocalUserDao dao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link net.javacafe.owl.infra.repository.LocalUserDao#findByEmailOrUsername(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByEmailOrUsername() throws Exception {
		assertThat(dao.findByEmailOrUsername("name"), is(nullValue()));
	}

	/**
	 * Test method for
	 * {@link net.javacafe.owl.infra.repository.LocalUserDao#insert(net.javacafe.owl.core.domain.User)}
	 * .
	 */
	@Test
	public void testInsert() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for
	 * {@link net.javacafe.owl.infra.repository.LocalUserDao#updateUsernameByEmail(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testUpdateUsernameByEmail() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
