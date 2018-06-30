package com.niit.project2Backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDao;
import com.niit.model.User;

public class UserDaoTest {
	static UserDao userDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDao=(UserDao)context.getBean("userDao");
	}

	@Test
	public void registrationtest() {
		User user=new User();
		user.setRole("ROLE_USER");
		
		user.setLoginname("vi");
		user.setPassword("123");
		user.setEmailid("vi@g.com");
		user.setUsername("vidya");
		user.setMobile("12345");
		user.setAddress("chennai");
		
		userDao.registration(user);
		
		assertTrue(true);
	}

}
