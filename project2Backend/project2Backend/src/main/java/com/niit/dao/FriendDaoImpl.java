package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Friend;
import com.niit.model.User;
@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Friend> showFriendlist(String loginname) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where (friendloginname=:floginname or loginname=:myloginname) "
				+ "and status='A'");
		query.setParameter("floginname", loginname);
		query.setParameter("myloginame", loginname);
		List<Friend> friendlist=(List<Friend>) query.list();
		return friendlist;
	}

	public List<Friend> showPendingFriendRequests(String loginname) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend wher friendloginname=:floginname and status='NA'");
		query.setParameter("floginname", loginname);
		List<Friend> pendingFriendRequests=query.list();
		return pendingFriendRequests;
	}

	@Override
	public List<User> showSuggestedFriend(String loginname) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select loginname from "
				+ "User where (loginname not in(select friendloginname from Friend where loginname='"+loginname+"')) "
						+ "and loginname not in(select loginname from Friend wher friendloginnname='"+loginname+"')) "
								+ "and loginname!='"+loginname+"'");
		List<String> username=(List<String>)query.list();
		ArrayList<User> suggestedFriends=new ArrayList<User>();
		int i=0;
		while(i<username.size()) {
			User userDetail=(User)session.get(User.class, username.get(i));
			suggestedFriends.add(userDetail);
			i++;
		}
		return suggestedFriends;
	}

	@Override
	public boolean sendFrienRequest(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		    }
		catch(Exception e){
		    return false;
		   }
	}
    @Override
	public boolean acceptFrienRequest(int friendId) {
		try {
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class, friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			session.close();
			return true;
		   }
	   catch(Exception e) {
	        return false;
	       }
	}
	@Override
	public boolean deleteFrienRequest(int friendId) {
		try {
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class, friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().delete(friend);
			session.close();
			return true;
		    }
		catch(Exception e) {
		    return false;
		   }
	}

}
