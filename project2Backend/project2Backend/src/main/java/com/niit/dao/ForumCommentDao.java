package com.niit.dao;

import java.util.List;
import com.niit.model.ForumComment;

public interface ForumCommentDao {
	public boolean addComment(ForumComment forumComment);
	public boolean deleteComment(ForumComment forumComment);
	public ForumComment getForumComment(int forumCommentId);
	public List<ForumComment> getAllComments(int forumId);
}
