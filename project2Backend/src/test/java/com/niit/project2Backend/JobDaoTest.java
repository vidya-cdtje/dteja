package com.niit.project2Backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.JobDao;
import com.niit.model.Job;

public class JobDaoTest {
	
	static JobDao jobDao;
	
	
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		System.out.println("JOB TEST CASE");

		ctx.scan("com.niit");
		ctx.refresh();
		
		jobDao=(JobDao)ctx.getBean("jobDao");
		
		System.out.println("JOB TEST CASE");

	}

	@Test
	public void addJobtest() {
		Job job =new Job();
		
		job.setJobDesignation("programmer");
		job.setCompany("globalsoft");
		job.setSalary(50000);
		job.setLocation("mumbai");
		job.setLastDateToApply(new java.util.Date());
	
		jobDao.addJob(job);
		assertTrue(true);
		}

}
