package com.niit.project2Backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.*;
import com.niit.model.Friend;

public class FriendDaoTest 
{
	static FriendDao friendDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		friendDao=(FriendDao)context.getBean("friendDao");
	}
	@Ignore
	@Test
	public void sendFriendtest() {
		Friend friend =new Friend();
		friend.setLoginname("vi");
		friend.setFriendloginname("vijay");
		friend.setStatus("NA");
		
		assertTrue("problem in sending friend request", friendDao.sendFrienRequest(friend));
	}

}
