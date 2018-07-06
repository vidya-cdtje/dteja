package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.User;

public interface FriendDao {
	public List<Friend> showFriendlist(String loginname);

	public List<Friend> showPendingFriendRequests(String loginname);

	public List<User> showSuggestedFriend(String loginname);

		public boolean sendFrienRequest(Friend friend);

		public boolean acceptFrienRequest(int friendId);

		public boolean deleteFrienRequest(int friendId);

}
