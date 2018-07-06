package com.niit.project2Backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.*;
import com.niit.model.BlogComment;

public class BlogCommentDaoTest 
{
	
	static BlogCommentDao blogCommentDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blogCommentDao=(BlogCommentDao)context.getBean("blogCommentDao");
	}
	@Ignore
	@Test
	public void addCommentTest()
	{
		BlogComment blogComment=new BlogComment();
		blogComment.setBlogId(50);
		blogComment.setCommentDate(new java.util.Date());
		blogComment.setLoginname("vi");
		blogComment.setCommentText("Very Informative Blog");
		blogCommentDao.addComment(blogComment);
		assertTrue(true);
	}
	@Ignore
	@Test
	public void listBlogCommentTest()
	{
		List<BlogComment> listComments=blogCommentDao.getAllComments(974);
		
		assertTrue("Problem in Listing BlogComments:",listComments.size()>0);
		
		for(BlogComment blogComment:listComments)
		{
			System.out.print(blogComment.getBlogId()+":::");
			System.out.println(blogComment.getCommentText());
		}
	}

}