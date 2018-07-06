package com.niit.Backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.*;
import com.niit.model.ForumComment;

public class ForumCommentDaoTest {
	static ForumCommentDao forumCommentDao;
    @BeforeClass
    public static void initialize() {
    	AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	forumCommentDao=(ForumCommentDao)context.getBean("forumCommentDao");
    }
    @Ignore
	@Test
	public void addForumCommenttest() {
    	ForumComment forumComment= new ForumComment();
    	forumComment.setForumId(100);
    	forumComment.setLoginname("vi");
    	forumComment.setDiscussiontext("what is hql");
    	forumComment.setDiscussionDate(new java.util.Date());
    	
    	assertTrue("problem in adding forum comment", forumCommentDao.addComment(forumComment));
	}@Ignore
	@Test
	public void listForumCommentTest()
	{
		List<ForumComment> listComments=forumCommentDao.getAllComments(100);
		
		assertTrue("Problem in Listing BlogComments:",listComments.size()>0);
		
		for(ForumComment forumComment:listComments)
		{
			System.out.print(forumComment.getForumId()+":");
			System.out.println(forumComment.getDiscussiontext());
		}
	}
	//@Ignore
	@Test
	public void deleteForumCommentTest() {
		ForumComment forumComment=forumCommentDao.getForumComment(100);
		assertTrue("problem in deleting the forum", forumCommentDao.deleteComment(forumComment));
		
	}

}
