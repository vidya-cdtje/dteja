package com.niit.DAO;

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
	public  boolean registration(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
		//select * from User_s180396 where email='james.s@abc.com"
		Query query=session.createQuery("from User where email=?");
		query.setString(0, email);
		User user=(User)query.uniqueResult();
		//if user==null, then entered email id doesnt exists in the table
		//which means it is unique
		
		//if user!=null, then entered email already exists
		//which means email is not unique
		if(user!=null)//NOT UNIQUE
			return false;
		else
			return true; //UNIQUE
	}
	public User login(User user) {//user is input from client
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=:email and password=:password");
		query.setString("email", user.getEmailid());
		query.setString("password", user.getPassword());
		User validUser=(User)query.uniqueResult(); //validUser is the result of the query
		return validUser; //validUser is either null or 1 object
	}
	public void updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		
	}
	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		return user;
	}

}
