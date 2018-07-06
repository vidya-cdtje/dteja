package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


//import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="s180403_JobDetails")
@SequenceGenerator(name="jobidseq", sequenceName="jobid_seq")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="jobidseq")
	int jobId;
	
	String jobDesignation;
	String company;
	int salary;
	String location;
	String jobDate;
	private boolean active;
	//@JsonFormat(shape=JasonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date lastDateToApply;
	
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobDate() {
		return jobDate;
	}

	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}

	public Date getLastDateToApply() {
		return lastDateToApply;
	}

	public void setLastDateToApply(Date lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

}
