package com.niit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.dao.*;
import com.niit.model.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;



@Configuration
@EnableTransactionManagement   

public class DBconfiguration {
		@Bean(name="dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("system");
	    dataSource.setPassword("password");
	    System.out.println("Datasourcebean:"+dataSource);
	    return dataSource;
	}

	@Bean 

	public SessionFactory sessionFactory() {

		System.out.println("Entering sessionFactory creation method");

		LocalSessionFactoryBuilder lsf=

				new LocalSessionFactoryBuilder(getDataSource());

		Properties hibernateProperties=new Properties();

		hibernateProperties.setProperty(

				"hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

		hibernateProperties.setProperty("hibernate.show_sql", "true");

		lsf.addProperties(hibernateProperties);
Class classes[]=new Class[]{User.class, Blog.class, BlogComment.class, ProfilePicture.class, Friend.class  };
		System.out.println("SessionFactory bean " + lsf);

	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();

	}

	@Bean

	public HibernateTransactionManager hibTransManagement(){

		return new HibernateTransactionManager(sessionFactory());

	}

	@Bean(name="userDao")

	public UserDao getUserDao() {

		System.out.println("user bean created");

		return new UserDaoImpl();

		}

	@Bean(name="jobDao")

	public JobDao getJobDao()

	{

		System.out.println("JOB BEAN CREATED");

		return new JobDaoImpl();

	}

	@Bean(name="blogDao")

	public BlogDao getBlogDao() {

		System.out.println("blog bean created");

		return new BlogDaoImpl();

	}

	@Bean

	public BlogCommentDao getBlogCommentDao() {

		System.out.println("blogcomment bean created");

		return new BlogCommentDaoImpl();

	}

	@Bean

	public ProfilePictureDao getProfilePictureDao() {

		System.out.println("profile picture bean created");

		return new ProfilePictureDaoImpl();

	}
	@Bean

	public FriendDao getFriendDao() {

		System.out.println("friend bean created");

		return new FriendDaoImpl();

	}


}

