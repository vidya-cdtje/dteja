package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProfilePicture;

@Repository("profilePictureDao")
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao{
	

	@Autowired
	SessionFactory sessionFactory;
	public void save(ProfilePicture profilePicture) {
		sessionFactory.getCurrentSession().save(profilePicture);
	}

	
	public ProfilePicture getProfilePicture(String loginname) {
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, loginname);
		
		return profilePicture;
	}

}