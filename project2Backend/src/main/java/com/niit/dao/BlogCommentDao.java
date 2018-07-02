package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComment;

public interface BlogCommentDao 
{
	public boolean addComment(BlogComment blogComment);
	public boolean deleteComment(BlogComment blogComment);
	public List<BlogComment> getAllComments(int blogId);
}
