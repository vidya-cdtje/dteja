package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Job;

@Repository
@Transactional
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private SessionFactory sessionFactory;
    public boolean addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		return true;
	}

	public boolean deleteJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(job);
		return true;
	}

	public boolean updateJob(Job job) {
			Session session=sessionFactory.getCurrentSession();
			session.update(job);
			return true;
		}

	public List<Job> listAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job where jobDesignation=?");
		List<Job> listJobs=query.list();
		return listJobs;
	}

	public Job getJob(int jobId) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job)session.get(Job.class, jobId);
		return job;
	}

}
