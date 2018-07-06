package com.niit.Backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.*;
import com.niit.model.Forum;

public class ForumDaoTest {
	static ForumDao forumDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao=(ForumDao)context.getBean("forumDao");
	}
	@Ignore
	@Test
	public void ForumDaotest() {
		Forum forum=new Forum();
		forum.setForumname("DT");
		forum.setForumContent("dev-ops");
		forum.setLoginname("vi");
		forum.setCreatedDate(new java.util.Date());
		forum.setStatus("NA");
		assertTrue("problem in adding forum", forumDao.addForum(forum));
	}
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=forumDao.getForum(50);
		assertTrue("Problem in Forum Deletion:",forumDao.deleteForum(forum));
	}
	@Ignore
	@Test
	public void updateForumTest()
	{
		Forum forum=forumDao.getForum(50);
		
		forum.setForumname("JAVA SE");
		forum.setForumContent("");
		
		assertTrue("Problem in Forum Updation",forumDao.updateForum(forum));
	}
	@Ignore
	@Test
	public void listForumTest()
	{	List<Forum> listForum=forumDao.listForum();
		assertTrue("Problem in Listing Forum",listForum.size()>0);
		
		for(Forum forum:listForum)
		{
			System.out.print(forum.getForumId()+":::");
			System.out.print(forum.getForumname()+":::");
			System.out.println(forum.getForumContent()+":::");
		}
	}
	@Ignore
	@Test
	public void approveForumTest()
	{
		assertTrue("Problem in Approving Forum",forumDao.approveForum(100));
	}
	//@Ignore
	@Test
	public void rejectForumTest()
	{
		assertTrue("Problem in Approving Forum",forumDao.rejectForum(100));
	}
}
