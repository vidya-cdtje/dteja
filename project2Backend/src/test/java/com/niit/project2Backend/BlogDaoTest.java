package com.niit.project2Backend;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

public class BlogDaoTest 
{
	
	static BlogDao blogDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blogDao=(BlogDao)context.getBean("blogDao");
	}
	
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("Hibernate Framework");
		blog.setBlogContent("Hibernate Framework Related Concept");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislikes(1);
		blog.setLoginname("kiran");
		blog.setStatus("NA");
		
		assertTrue("Problem in Blog Insertion",blogDao.addBlog(blog));
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDao.getBlog(973);
		assertTrue("Problem in Blog Deletion:",blogDao.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDao.getBlog(952);
		
		blog.setBlogName("JAVA SE");
		blog.setLikes(2);
		
		assertTrue("Problem in Blog Updation",blogDao.updateBlog(blog));
	}
	@Ignore
	@Test
	public void listBlogTest()
	{	List<Blog> listBlogs=blogDao.listBlogs();
		assertTrue("Problem in Listing Blog",listBlogs.size()>0);
		
		for(Blog blog:listBlogs)
		{
			System.out.print(blog.getBlogId()+":::");
			System.out.print(blog.getBlogName()+":::");
			System.out.println(blog.getBlogContent()+":::");
		}
	}
	@Ignore
	@Test
	public void approveBlogTest()
	{
		assertTrue("Problem in Approving Blog",blogDao.approveBlog(974));
	}
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		assertTrue("Problem in Approving Blog",blogDao.rejectBlog(972));
	}
	@Ignore
	@Test
	public void incrementLikeBlogTest()
	{
		assertTrue("Problem in Incrementing Blog:",blogDao.incLikes(952));
	}
	@Ignore
	@Test
	public void disLikeBlogTestCase()
	{
		List<Blog> listBlogs=blogDao.listBlogs();
		assertTrue("Problem in Decrementing Likes Blog:",blogDao.disLikes(974));
	}
	
}