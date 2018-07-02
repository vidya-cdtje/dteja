package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
private SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User userDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Override
	public boolean updateUser(User userDetail) {
		try
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	@Override
	public User getUser(String loginname) {
		Session session=sessionFactory.openSession();
		User userDetail=(User)session.get(User.class,loginname);
		session.close();
		return userDetail;
	}

	@Override
	public User checkUser(User userDetail) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where loginname=:myloginname and password=:password");
		query.setParameter("myloginname", userDetail.getLoginname());
		query.setParameter("password",userDetail.getPassword());
		List<User> listUser=query.list();
		User userDetail1=listUser.get(0);
		session.close();
		return userDetail1;
	}
	

}
