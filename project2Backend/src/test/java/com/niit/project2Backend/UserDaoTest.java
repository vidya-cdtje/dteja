package com.niit.project2Backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserDaoTest 
{
	static UserDao userDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDao=(UserDao)context.getBean("userDao");
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		User userDetail=new User();
		
		userDetail.setLoginname("ragsh");
		userDetail.setPassword("111");
		userDetail.setUsername("ragesh");
		userDetail.setEmailid("ragsh@gmail.com");
		userDetail.setRole("ROLE_USER");
		userDetail.setAddress("chennai");
		userDetail.setMobile("987654323");
		userDao.registerUser(userDetail);
		assertTrue(true);
	}
	@Ignore
	@Test
	public void updateUserTest()
	{
		User userDetail=userDao.getUser("ragsh");
		userDetail.setMobile("987654323");
		
		assertTrue("Problem in Updating User:",userDao.updateUser(userDetail));
	}
	@Ignore
	@Test
	public void checkLoginTest()
	{
		User userDetail=new User();
		userDetail.setLoginname("ragsh");
		userDetail.setPassword("111");
		
		User userDetail1=userDao.checkUser(userDetail);
		
		assertNotNull("Problem in loginCheck",userDetail1);
		
		System.out.println("User Name:"+userDetail1.getUsername());
	}
}