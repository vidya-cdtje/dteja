package com.niit.model;

import java.util.Date;

public class OutputMessage extends Message 
{
	private Date time;

	public OutputMessage(Message message, Date date) {
		// TODO Auto-generated constructor stub
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
