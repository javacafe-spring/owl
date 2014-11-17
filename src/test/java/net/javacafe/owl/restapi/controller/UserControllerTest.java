package net.javacafe.owl.restapi.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import net.javacafe.owl.config.RootConfig;
import net.javacafe.owl.config.WebConfig;
import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.events.SignInEvent;
import net.javacafe.owl.core.events.SignUpEvent;
import net.javacafe.owl.core.services.UserService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
public class UserControllerTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSignUp() throws Exception {
		when(userService.signUp(org.mockito.Mockito.any(SignUpEvent.class))).thenReturn(
				new User("placebo@gmail.com", "placebo", "1234"));

		MvcResult r = this.mockMvc
				.perform(
						get("/signUp.json").param("email", "placebo@gmail.com").param("username", "placebo")
								.param("hashedPassword", "1234")).andExpect(status().isOk()).andReturn();
		assertThat(r.getModelAndView().getModel().get("user"), is(notNullValue()));

	}

	@Test
	public void testSignIn() throws Exception {
		when(userService.signIn(org.mockito.Mockito.any(SignInEvent.class))).thenReturn(
				new LoginUser(new User("placebo@gmail.com", "placebo", "1234")));

		MvcResult r = this.mockMvc
				.perform(get("/signIn.json").param("email", "placebo@gmail.com").param("hashedPassword", "1234"))
				.andExpect(status().isOk()).andReturn();
		assertThat(r.getModelAndView().getModel().get("loginUser"), is(notNullValue()));

	}
}
