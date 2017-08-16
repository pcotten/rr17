package com.reciperex.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Comment {

	private Integer id;
	private Integer user;
	private String text;
	private List<Integer> comments;
	private Date timestamp;
	
	public Comment(){
		
	}
	
	public Comment(Integer id, Integer user, String text) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.comments = new ArrayList<Integer>();
		this.timestamp = Calendar.getInstance().getTime();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Integer> getComments() {
		return comments;
	}

	public void setComments(List<Integer> comments) {
		this.comments = comments;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}