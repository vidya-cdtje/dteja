package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="s180403_forumcomment")
@SequenceGenerator(name="forumcommentidseq", sequenceName="forumcommentidseq")
public class ForumComment {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="forumcommentidseq")
int commentId;
int forumId;
String discussiontext;
String forumname;
String loginname;
Date discussionDate;
public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public int getForumId() {
	return forumId;
}
public void setForumId(int forumId) {
	this.forumId = forumId;
}
public String getDiscussiontext() {
	return discussiontext;
}
public void setDiscussiontext(String discussiontext) {
	this.discussiontext = discussiontext;
}
public String getForumname() {
	return forumname;
}
public void setForumname(String forumname) {
	this.forumname = forumname;
}
public String getLoginname() {
	return loginname;
}
public void setLoginname(String loginname) {
	this.loginname = loginname;
}
public Date getDiscussionDate() {
	return discussionDate;
}
public void setDiscussionDate(Date discussionDate) {
	this.discussionDate = discussionDate;
}

}
