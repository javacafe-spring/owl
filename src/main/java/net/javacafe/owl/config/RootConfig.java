package net.javacafe.owl.config;

import java.util.Properties;

import javax.sql.DataSource;

import net.javacafe.owl.core.repository.PostDao;
import net.javacafe.owl.core.repository.UserDao;
import net.javacafe.owl.core.services.LoginUserEventHandler;
import net.javacafe.owl.core.services.LoginUserService;
import net.javacafe.owl.core.services.UserEventHandler;
import net.javacafe.owl.core.services.UserService;
import net.javacafe.owl.infra.repository.FakePostDao;
import net.javacafe.owl.infra.repository.LocalUserDao;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class RootConfig {

	@Bean
	public UserService userEventService(UserDao o) {
		return new UserEventHandler(o);
	}

	@Bean
	public UserDao userDao() {
		return new LocalUserDao();
	}

	@Bean
	public PostDao postDao() {
		return new FakePostDao();
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public LoginUserService loginUserService(PostDao o) {
		return new LoginUserEventHandler(o);
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setMappingResources(new String[] { "persistance/user.hbm.xml" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory, DataSource dataSource) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		txManager.setDataSource(dataSource);
		return txManager;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/owl?createDatabaseIfNotExist=true");
		dataSource.setUsername("placebo");
		dataSource.setPassword("placebo");
		return dataSource;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = -129819734682723912L;
			{
				// setProperty("hibernate.hbm2ddl.auto", "create-drop");
				setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}
}
