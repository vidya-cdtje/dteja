package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.*;
import com.niit.model.*;

@Configuration
@EnableTransactionManagement
public class DBconfiguration {
	public DBconfiguration() {
		System.out.println("dbconfig instantiated");
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbmddl2.auto","update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);
		
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);


		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		System.out.println("SessionFactory Object");
		return sessionFactory;
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("system");
	    dataSource.setPassword("password");
	    return dataSource;
	    
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Object");
		return new HibernateTransactionManager(sessionFactory);
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
	public BlogDao addBlog()
	{
		System.out.println("BLOG BEAN CREATEDD");
		return new BlogDaoImpl();
	}
	@Bean(name="blogCommentDao")
	public BlogCommentDao getBlogComment()
	{
		System.out.println("BLOG COMMENT BEAN CREATEDD");
		return new BlogCommentDaoImpl();
	
}
	@Bean(name="profilePictureDao")
	public ProfilePictureDao getProfilePictureDao()
	{
		System.out.println("PROFILE PICTURE BEAN CREATEDD");
		return new ProfilePictureDaoImpl();
}
}
